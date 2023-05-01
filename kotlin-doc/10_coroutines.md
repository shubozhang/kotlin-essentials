## Basic

* `Thread.sleep()`: blocking method
* `delay()`: non-blocking method. delay is a special suspending function that does not block a thread, but suspends the 
coroutine, and it can be only used from a coroutine.

* An outer coroutine does not complete until all the coroutines launched in CoroutineScope complete.

* Active coroutines that were launched in GlobalScope do not keep the process alive. They are like daemon threads.



A coroutine is an instance of suspendable computation. It is conceptually similar to a thread, in the sense that it takes a 
block of code to run that works concurrently with the rest of the code. However, a coroutine is not bound to any particular thread. 
It may suspend its execution in one thread and resume in another one.

`launch` is a coroutine builder. It launches a new coroutine concurrently with the rest of the code, which continues to work independently. 
That's why Hello has been printed first.

`delay` is a special suspending function. It suspends the coroutine for a specific time. Suspending a coroutine does not block the underlying thread, 
but allows other coroutines to run and use the underlying thread for their code.

`runBlocking` is also a coroutine builder that bridges the non-coroutine world of a regular fun main() and the code with coroutines 
inside of runBlocking { ... } curly braces. This is highlighted in an IDE by this: CoroutineScope hint right after the runBlocking opening curly brace.
The name of runBlocking means that the thread that runs it (in this case — the main thread) gets blocked for the duration of the call, until all the coroutines inside runBlocking { ... } 
complete their execution.

* Structured concurrency
  Coroutines follow a principle of structured concurrency which means that new coroutines can be only launched in a 
specific CoroutineScope which delimits the lifetime of the coroutine.
  * In a real application, you will be launching a lot of coroutines. Structured concurrency ensures that they are not 
    lost and do not leak. An outer scope cannot complete until all its children coroutines complete. Structured concurrency also 
    ensures that any errors in the code are properly reported and are never lost.


