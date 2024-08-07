class Read(
    private val register: Char,
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val address = cpu.getAddress()
        cpu.assignRegisterValue(register.toString().toInt(), address)
    }
    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}