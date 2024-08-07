class Subtract(
    private val registerX: Char,
    private val registerY: Char,
    private val differenceRegister: Char
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction(){
        val registerXValue = cpu.getRegisterValue(registerX.digitToInt())
        val registerYValue = cpu.getRegisterValue(registerY.digitToInt())
        val difference = registerXValue - registerYValue
        cpu.assignRegisterValue(differenceRegister.toString().toInt(), difference.toString())
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}