class ConvertToBase10(
    val register: Char
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val registerValue = cpu.getRegisterValue(register.toString().toInt())
        cpu.assignAddressValue(registerValue)
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}