class Add(
    private val registerX: Char,
    private val registerY: Char,
    private val sumRegister: Char
) : InstructionStrategy(){
    private val cpu = CPU.getInstance()
    override fun performAction(){
        val sum = registerX.toString().toInt(16) + registerY.toString().toInt(16)
        cpu.assignRegisterValue(sumRegister.toString().toInt(), sum.toString())
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}