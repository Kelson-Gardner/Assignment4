import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main(){

    val emulator = Emulator()
    emulator.loadAndRunProgram()

    //TODO: make an array that has the instructions in the spot of where the first nibble is
    //so you can just call it from there and get the instruction to execute from it

//    val byte = (0xF6).toUByte()
//    val firstNibble = byte.toInt() shr 4
//    println(firstNibble)
//    val secondNibble = byte.toInt() and 0xF
//    println(secondNibble)
//
//    //Joinging nibbles together
//    var newByte = firstNibble.toInt() shl 4
//    newByte = newByte or secondNibble
//    //newByte is equal to the joining of the nibbles
//
//    val executor = Executors.newSingleThreadScheduledExecutor()
////
//    val runnable = Runnable {
//        println("Hello!")
//    }
//
//    val cpuFuture = executor.scheduleAtFixedRate(
//        runnable,
//        0,
//        1000L / 500L, // repeat frequency - every 2 ms
//        TimeUnit.MILLISECONDS
//    )
//
//    //to stop and interupt a future
//    cpuFuture?.cancel(true)
//
//    try {
//        cpuFuture.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
//    } catch (_: Exception) {
//        executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
//    }
//

}

// to wait for all futures to finish
