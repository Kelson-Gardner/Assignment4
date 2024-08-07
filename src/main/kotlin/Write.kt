class Write(
    private val register: Char,
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val registerValue = cpu.getRegisterValue(register.digitToInt())
        cpu.assignAddressValue(registerValue)
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}