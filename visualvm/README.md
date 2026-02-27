VisualVM Practice Project
----------------------------------

This project demonstrates how to:

Monitor G1 Garbage Collector

Observe Heap behavior (Eden, Survivor, Old)

Detect Deadlocks

Analyze Thread states

Generate Thread Dumps

1)Requirements
--------------------------

JDK 24 (or any recent JDK)

IntelliJ IDEA

VisualVM installed and unzipped

2)Enable G1GC in IntelliJ
---------------------------------
Go to:
Run → Edit Configurations → VM Options
Add:
-XX:+UseG1GC -Xms256m -Xmx256m
Apply and Run.

3)GC Monitoring Example
------------------------------
Code: TestGC.java
public class TestGC {
public static void main(String[] args) throws Exception {
while (true) {
byte[] data = new byte[200 * 1024]; // 200 KB
Thread.sleep(200);
}
}
}

4)What You Should See in VisualVM
-----------------------------------
Open:
Applications → Your Process → Visual GC tab

Observe:
Eden filling and clearing

Survivor movement

Old Gen behavior

GC count increasing

5)Humongous Allocation Example
-------------------------------------
public class TestGC {
public static void main(String[] args) throws Exception 
{
while (true) 
{
byte[] data = new byte[1024 * 1024]; // 1 MB
Thread.sleep(200);
}
}
}

Expected:

Old Gen grows

GC Cause shows: G1 Humongous Allocation

6)Deadlock Detection Example
------------------------------------
Code: DeadLockEx.java
public class DeadLockEx {

private static final Object lock1 = new Object();
private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread-1 acquired lock1");
                try { Thread.sleep(1000); } catch (Exception ignored) {}
                synchronized (lock2) {
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");
                try { Thread.sleep(1000); } catch (Exception ignored) {}
                synchronized (lock1) {
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
**What To Check in VisualVM**
-----------------------------

Open Threads tab

Click Thread Dump

Look for:

Found one Java-level deadlock

Thread state will show:

BLOCKED

WAITING

7)ITC (Producer-Consumer) Example
------------------------------------------------

Use a wait/notify based print server.

Observe in Threads tab:

WAITING state

RUNNABLE state

BLOCKED state transitions

8)What to Practice in VisualVM
---------------------------------------
 Heap usage monitoring
 GC count tracking
 Thread state analysis
 Deadlock detection
 CPU usage observation

9)Important Observations
--------------------------------------

wait() releases monitor

sleep() does NOT release monitor

notify() wakes one thread

notifyAll() wakes all waiting threads

Always use while() with wait()

10)Troubleshooting
---------------------------

If process not visible:

Restart VisualVM

Ensure IntelliJ and VisualVM run with same permissions

Make sure application is running