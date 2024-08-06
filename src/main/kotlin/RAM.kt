class RAM {
    private var memory = UByteArray(4096)

    @OptIn(ExperimentalUnsignedTypes::class)
    fun read(address: Int): UByte {
        return memory[address]
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun write(address: Int, value: UByte) {
        memory[address] = value
    }
}