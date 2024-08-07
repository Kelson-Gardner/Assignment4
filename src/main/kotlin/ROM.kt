import java.io.File
class ROM {
    @OptIn(ExperimentalUnsignedTypes::class)
    private var memory = UByteArray(4096)

    @OptIn(ExperimentalUnsignedTypes::class)
    fun read(address: Int): String {
        val byte = memory[address]
        return String.format("%02X", byte.toInt() and 0xFF)
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun insertByte(byte: UByte, index: Int){
        memory[index] = byte
    }
}