import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

val executor = Executors.newSingleThreadScheduledExecutor()

val runnable = Runnable {
    println("Hello!")
}

val cpuFuture = executor.scheduleAtFixedRate(
    cpuRunnable,
    0,
    1000L / 500L, // repeat frequency - every 2 ms
    TimeUnit.MILLISECONDS
)

//to stop and interupt a future
public fun stop(){
cpuFuture?.cancel(true)

try {
    cpuFuture.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
} catch (_: Exception) {
    executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
}
}

// to wait for all futures to finish
