class SetA(
    private val address: String
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val intAddress = address.toInt()
        val hexAddress = intAddress.toString(16)
        cpu.assignAddressValue(hexAddress.toUByte(16))
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}