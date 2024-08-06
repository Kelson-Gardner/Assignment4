class Subtract(
    val registerX: Char,
    val registerY: Char,
    val differenceRegister: Char
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction(){
        val difference = registerX.toString().toInt(16) - registerY.toString().toInt(16)
        cpu.assignRegisterValue(differenceRegister.toString().toInt(), difference.toString())
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}