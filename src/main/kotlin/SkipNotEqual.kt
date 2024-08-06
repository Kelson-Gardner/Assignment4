class SkipNotEqual(
    private val registerX: Char,
    private val registerY: Char,
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        if(cpu.getRegisterValue(registerX.toString().toInt()) != cpu.getRegisterValue(registerY.toString().toInt())){
            cpu.incrementProgramCounter()
        }
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}