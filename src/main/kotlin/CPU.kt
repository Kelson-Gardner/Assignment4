import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class CPU private constructor(){
    private val rom = UByteArray(4096)
    private val ram = UByteArray(4096)
    private val registers = UByteArray(8)
    var programCounter: Int = 0 // 16 bit register, stores address of current instruction. SHOULD ALWAYS INCREMENT BY 2!!
    var timer: Int = 0 // 8 bit register for storing the timer value
    // While the t value is above 0, the program decrements the value by 1 at 60hz (every 16ms
    var address: UByte = 0.toUByte() // 16 bit register for storing an address
    private var memoryFlag: Boolean = false // 0 = RAM 1 = ROM

    companion object {
        @Volatile
        private var instance: CPU? = null

        fun getInstance(): CPU{
            return instance ?: synchronized(this) {
                instance ?: CPU().also {instance = it}
            }
        }
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun readROM(address: Int): String {
        val byte = rom[address]
        return String.format("%02X", byte.toInt() and 0xFF)
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun loadProgramInROM(filePath: String) {
        val inputFile = File(filePath)
        val bytes = inputFile.readBytes()
        var count = 0
        for(byte in bytes){
            rom[count] = byte.toUByte()
            count++
        }
    }

    fun getAddress(): String{
        return String.format("%02X", address.toInt() and 0xFF)
    }

    fun assignAddressValue(byte: UByte){
        address = byte
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun assignRegisterValue(register: Int, value: String){
        registers[register] = value.toUByte(16)
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun getRegisterValue(register: Int): UByte{
        return registers[register]
    }

    fun runProgram(): String {
        println("Enter the file you would like me to run?")
        return readln()
    }

    fun incrementProgramCounter(){
        programCounter += 2
    }

    fun toggleMemoryFlag(){
        memoryFlag = !memoryFlag
    }

    fun getMemoryFlag(): Boolean{
        return memoryFlag
    }

    fun execute(){
        val executor = Executors.newSingleThreadScheduledExecutor()
        val runnable = Runnable {
            val byte = readROM(programCounter) + readROM(programCounter + 1)
            val opcode = byte[0]
            val operands = byte.substring(1)
            val instruction = InstructionFactory().createInstruction(opcode.digitToInt(), operands)
            instruction.execute()
            println(registers[0])
        }

        val cpuFuture = executor.scheduleAtFixedRate(
            runnable,
            0,
            1000L / 500L,
            TimeUnit.MILLISECONDS
        )

//        cpuFuture.get()
//
//        //to stop and interupt a future
//        cpuFuture?.cancel(true)
//
//        try {
//            cpuFuture.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
//        } catch (_: Exception) {
//            executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
//        }
    }
}
