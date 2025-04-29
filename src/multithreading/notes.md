# Java Multithreading
- first and foremost we need to understand why threading models exist and what good do they provide
- Threads are not physical objects
- Think of a single processor machine running your favourite IDE.
- if you edit on of the code files and click save, the clicking of the button will initiate a workflow which cause bytes to be written out to the underlying physical disk
- Howvere, Io is an expensive operation, and the CPU will be idle while bytes are being written out to the disk
- while IO takes place, the idle CPU could work on something useful and here is where threads come in - the IO thread is sswitched out and the UI thread gets scheduled on the CPU so that if you click elsewhere on the screen, your IDE is still responsive and does not appear frozen or hung
- Threads can give the illusion of multitasking even though at any given point in time the CPU is executing only one thread.
- each thread gets a slice of time on the CPU and then gets switched out either because it initiates a tas which requires waiting and not utilizing the CPU or it completes its time slot on the cPU
- multi-core machines  enable applications to take advantage of this archtecture and have a dedicated CPU run each thread

## Benefits of Threads
- Higher throughput
- Responsive applications that give the illusion of multitasking
- Efficient resource utilisation


## Performance Gains via Multithreading
```java
class Demonstration {
    public static void main( String args[] ) throws InterruptedException {
        SumUpExample.runTest();
    }
}

class SumUpExample {

    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {

        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static public void twoThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    static public void oneThread() {

        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }


    public static void runTest() throws InterruptedException {

        oneThread();
        twoThreads();

    }
}

```

## Problems with Threads
1. Usually very hard to find bugs, some that may only rear head in production environemts
2. Higher cost f code maintainance since the code  inherently becomes harder to reason about
3. Increase utilization of system resources. creation of each thread consumes additional memory, CPU cycles for book-keeping and aste of time in context switches
4. programs may experience slowdown as coordination amongst threads comes at a price. Acquiring and releasing locks adds to program execution time. Threads fighting over acquiring locks cause lock contention

## Program vs Process vs Thread

**Program**
- A program is a set of instructions and associated data that resides on the disk and is loaded by the operating system to perform some task
- an executable file or a python script file are examples of programs
- in order to run a progeam, the operating system's kernel is frst asked to create a new process, which is an environment in which a program executes

**process**
- A process is a program in execution
- A process is an execution environment that consists of instructions, user-data, and system-data segments, as well as lots of other resources such as CPU, memory, address space, disk and network I/O acquired at runtime.
- Program can have several copies of it running at the same time but a press necessarily belongs to only one program

**Thread**
- Thread is the smallest unit of execution in a process.
- A thread simply executes instructions serially
- a process can have multiple threads running as part of it
- Usually, there would be some state associated with the process that is shared among all the threads and in turn each thread would have would have some state private to itself.
- the globally shared state amongst the threads of a process is visible and accessible to all the threads, and special attention needs to be paid when any thread tries to read or write to this global shared state.
- There are seveal constructs offered by various programming languages to guard and discipline the access to theis global state.

**Caveats**
- a program or a process are often used interchangeably but most of the time the intent is to refer to a process. 

**Multiprocessing**
- this is where multiple processes get scheduled on more than one CPU 
- Usually, this requires hardware support where a single system comes with multiple cores or the execution takes place in a cluster of machines
- Processes dont share any resources amongst themselves whereas threads of a process can share the resources allocated t that particular process, including memory address space
- However, languages do provide facilities to enable interprocess communication
- incorrect synchronization can lead to wildly arguing outputs depending on which order threads get executed
- since the execution of threads are not predictable and is entirely up to the operating system, we cannot make any assumptions about the order in which threads get scheduled and executed

```java
package multithreading;

import java.util.*;

public class DemoThreadUnsafe {
    // we will use to sleep the thresas randomly
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        // create object of unsafe count
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // set up a thread to increase the count 200 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                DemoThreadUnsafe.sleepRandomlyForLessThan0Sec();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                DemoThreadUnsafe.sleepRandomlyForLessThan0Sec();
            }
        });

        // run both threads
        t1.start();
        t2.start();

        // wait for both to complete
        t1.join();
        t2.join();

        badCounter.printFinalCount();
    }

    public static void sleepRandomlyForLessThan0Sec() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {

        }

    }
}


class ThreadUnsafeCounter {
    int count = 0;

    public  void increment() {
        count++;
    }

    public  void decrement() {
        count--;
    }

    void printFinalCount() {
        System.out.println("Count is " + count);
    }
}

```
**Resolution Strategies**

```java
public synchronized void increment() {
    count++;
}

public synchronized void decrement() {
    count--;
}

AtomicInteger count = new AtomicInteger(0);

public void increment() {
    count.incrementAndGet();
}

public void decrement() {
    count.decrementAndGet();
}
```
the above code makes the operations atomic and thread-safe, ensuring we always get 0 as the final result after 100 increements and 100 decreements


## Concurrency Vs Parallelism


**Serial execution**
- whe programs are serially executed, they are scheduled one at a time on the CPU
- once a task gets completed, the next one gets a chance to run.
- each task is run from the beginning to the end without interruption

**Concurrency**
- a concurrent program is one that can be decomposed into constituent parts and each part can be executed out of order or in partial order without afecting the final outcome
- A concurrent system can have two programs in progress at the same time where progress doesn’t imply execution.
- one program can be suspended while the other one executes
- the goal is to maximize throughput and minimise latency

**Techniques to Achieve Concurrency:**
* **Multithreading** — multiple threads sharing resources
* **Asynchronous programming** — tasks run without blocking, using callbacks/promises/futures
* **Event loops** — like in Node.js, handling events and I/O without blocking
* **Coroutines** — lightweight cooperatively-scheduled threads (e.g. Kotlin, Python asyncio)

**Parallelism**
- A parallel system is one which necessarily has the ability to execute multiple programs at the same time.
- Usually, this capacity is aided by hardware in the form of multicore processors on individual machines or as computing clusters where several machines are hooked up to solve independent pieces of a problem simultaneously. 
- here, an individual problem has to be concurrent in nature, i.e portions of it can be worked on independently without affecting the final outcome before it can be executed i  parallel

## Concurrency vs Parallelism
- Concurrency is about structure. Parallelism is about execution.
- a concurrent system need not be parallel, whereas a parallel system is indeed concurrent.
- however a system can be both concurrent and parallel e.g a multitasking OS running on a multi core machine
- concurrency is about dealing with lots of things at the same time while parallelism is about doing lots of things at the same time
- parallelism may be described as a property of a program or a system whereas parallelism as a runtime behaviour of executing multiple tasks


## Cooperative Multitasking Vs Preemptive Multitasking 
- i preemptive the Os controls the context switching and reduces the risk of starvation as opposd to cooperative where a task chooses when to give up control or when its execution ends

## Synchronous Vs Asynchronous
**Synchronous**
- Synchronous execution refers to line-by-line execution of code
- if a function is invoked, the program execution waits until the function call is completed
- Synchronous execution blocks at each method call before proceeding to the next line of code.
- a program executes in the same sequence as the code in the source code file. 
- it is synonymous to serial execution
**Asynchronous**
- async execution refers to the execution that does not block when invoking subroutines
- it does not wait for a task to complete and can move on to the next task
- it can invoke a method and move on to the next line of code without waiting for the invoked function to complete or receive its result
- mostly they return an entity sometimes called a future or a promise that is a representation of an in-progress computation
- the program can query for the status of the computation via the returned future or promise and retrive the result once completed
- another pattern is to pass a call back function to the async call which is invoked with the resukts when the async function is done processing.
- in a non-threaded environments, async programming provides an alternative to threads in order to achieve concurrency and fall under the cooperative multitasking model

## I/o Bound vs CPU Bound
- programs utilises various resources of the computer system on which they run
  - CPU time
  - Memory
  - Networking resources 
  - Disk storage
- a program loading gbs of data from storage int main memory would hog the main memory while another program wiriting several gbs to permanent storage would require abnormally high disk i/o

**CPU Bound**
- Multithreaded programs can improve performance in cases where the problem lends itself to being divided into smaller pieces that different threads can work on independently. this may not always be true though

**I/o Bound**
- these spend most of the time wiatng for input or output to complete while the CPU sits idle
- I/o Bound operations can consist of operations that write or read from main memory or network interfaces
- becaus ethe cpu and main memory are physically separte a data bus exusts between the two to transfer bots to and fro.


- bothe tyoes of programs can benefit from concurrent architectures
- if a program is cpu bound we can increase the bumber of processors and structure our program to spawn multiple threads that individually run on a dedicated or shared cpu.
- for i/o bound programs, it makes sense to have a thread give up cpu control if it is waiting for a i/o operation to complete so that another thread can get scheduled on the cpu and utilize cpu cycles

## Throughput vs latency
**Throughput:** - can be defined as the rate of doing work or how much work gets done per unit of time, how many images your phone or browser downloads per unit of time from ig
**Latency:** - can also be referred as response time. a measure of the time required to complete a task or produce a result. The time it takes for a web browser to download ig images from the internet is the latency for downloading the images

- in the context of concurrency throughput can be thought of as time taken t execute a program or computation
- in a files processing program where we have different threads processing different files we will have more files processed within a minute as copared to single threaded program
- latency is the total time taken to completely process all the files
- in a multithreaded system throughput will go high and latency will go down
- more work gets done in less amount of time. 
- in general the two have an inverse relationship

## Critical sections and race conditions
- A program is a set of instructions being executed, and multiple threads of a program can be executing different sections of the program code.
- caution comes in where threads of the same program attempt to execute the same portion of code.

**Critical section**
- this is any piece of code that has the possibility of being executed concurrently by nore than one thread of the application and exposes any shared data or resources used by the application for access

**Race Condition**
- Happens when threads run through critical sections without thread synchronization
- test then act - a thread tests for a state/conndition, caled a predicate, and then based on the condition takes subsequent action

## Deadlocks, Liveness & Reentrant Locks
- logical follies committed in multithreading code in an effort to avoid race conditions and grading critical sections, can lead to a host of subtle and hard to find bugs and side-effects

**Dead Lock**
- These occur when two or more threads are not able to make any progress because the resurce required by the first thread is help by the second and the resource required by the second is held by the first

**Liveness**
- Ability of a program to execute in a timely manner which can be hindered by dead lock

**Live-lock**
- this occurs when two threads continuosly react in response to the actions by the other thread without making any real progress
- A process seems to be running and not Deadlocked but in reality, is not making any progress

**Starvation**
- other than a deadlock, an application thread can also experience starvation, when it never gets cpu time or access to shared resources
- other greeedy threads continously hog shared resources not letting the starving thread make any progress.


**Reentrant Lock**
- these allow for relocking or re-entering of a synchronization lock
- This can be best explained with an example below
- any object of this class if locked twice in succession would result in a deadlock
- The same thread gets blocked on itself, and the program is unable to make any further progress.
- if you run the execution would time-out
- if a synchronization primitive does not allow reacquisition of itself by a thread that has already acquired it, then such a thread would block as sonn as it attempts to reaquire the primitive a second time

```java
class Demonstration {

    public static void main(String args[]) throws Exception {
        NonReentrantLock nreLock = new NonReentrantLock();

        // First locking would be successful
        nreLock.lock();
        System.out.println("Acquired first lock");
      
        // Second locking results in a self deadlock 
        System.out.println("Trying to acquire second lock");      
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}

class NonReentrantLock {

    boolean isLocked;

    public NonReentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {

        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
```
## Mutex 
- as the name suggests it implies mutual exclusions - it guards resources in data structures like linked-lista nd arrays
- it ensures that only one thread has access to a particular resource
- the resource is only released when the said task is done to a waiting trhead
- a thread has to wait for the acquired mutex to be released

## Semaphore
- a semaphore issues available permits to asking threads
- there is no concept of ownership in semaphore
- a semaphore with a single permit is called a binary semaphoer and can mascarade as a mutex
- here several trheads can be running depending on the number of permits a semaphre has


## Thread safety and Synchronized
- a class and its apis is considered thread safe if its apis can be consumed without the risks of race conditions or state corruption for the class
- a combination of two trhead safe classes does not automatically result to a thread safety







