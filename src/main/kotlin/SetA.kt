class SetA(
    private val address: String
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        cpu.assignAddressValue(address.toUByte(16))
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}