import java.io.File
class ROM private constructor() {
    private var memory = UByteArray(4096)
    companion object{
        @Volatile
        private var instance: ROM? = null

        fun getInstance(): ROM{
            return instance ?: synchronized(this){
                instance ?: ROM().also { instance = it }
            }
        }
    }
    @OptIn(ExperimentalUnsignedTypes::class)
    fun read(address: Int): String {
        val byte = memory[address]
        return String.format("%02X", byte.toInt() and 0xFF)
    }
    @OptIn(ExperimentalUnsignedTypes::class)
    fun loadProgram(filePath: String) {
        val inputFile = File(filePath)
        val bytes = inputFile.readBytes()
        var count = 0
        for(byte in bytes){
            memory[count] = byte.toUByte()
            count++
        }
    }
}