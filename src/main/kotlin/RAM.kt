class RAM {
    @OptIn(ExperimentalUnsignedTypes::class)
    private var memory = UByteArray(4096)

    @OptIn(ExperimentalUnsignedTypes::class)
    fun read(address: Int): String {
        val byte = memory[address]
        return String.format("%02X", byte.toInt() and 0xFF)
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun write(address: Int, value: UByte) {
        memory[address] = value
    }
}