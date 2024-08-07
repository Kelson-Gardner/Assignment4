import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class CPU private constructor(){
    private val rom = ROM()
    private val ram = RAM()
    private val registers = UByteArray(8)
    var programCounter: Int = 0 // 16 bit register, stores address of current instruction. SHOULD ALWAYS INCREMENT BY 2!!
    var timer = Timer() // 8 bit register for storing the timer value
    // While the t value is above 0, the program decrements the value by 1 at 60hz (every 16ms
    private var address: UByte = "0".toUByte(16) // 16 bit register for storing an address
    private var memoryFlag: Boolean = false // 0 = RAM 1 = ROM
    var asciiDisplay = AsciiScreen()

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
    fun loadProgramInROM(filePath: String) {
        val inputFile = File(filePath)
        val bytes = inputFile.readBytes()
        var count = 0
        for(byte in bytes){
            rom.insertByte(byte.toUByte(), count)
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

    fun readROM(index: Int): String{
        return rom.read(index)
    }

    lateinit var cpuFuture: ScheduledFuture<*>

    fun execute(){
        val executor = Executors.newSingleThreadScheduledExecutor()
        val runnable = Runnable {
            val byte = readROM(programCounter) + readROM(programCounter + 1)
            if(byte == "0000"){
                cpuFuture.cancel(true)
                executor.shutdown()
            }
            val opcode = byte[0]
            val operands = byte.substring(1)
            val instruction = InstructionFactory().createInstruction(opcode.digitToInt(16), operands)
            instruction.execute()
    }

        cpuFuture = executor.scheduleAtFixedRate(
            runnable,
            0,
            1000L/500L,
            TimeUnit.MILLISECONDS
        )


        cpuFuture.get()


        cpuFuture?.cancel(true)

        try {
            cpuFuture.get()
        } catch (_: Exception) {
            executor.shutdown()
        }
    }
}
