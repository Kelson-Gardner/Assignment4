class Add(
    private val registerX: Char,
    private val registerY: Char,
    private val sumRegister: Char
) : InstructionStrategy(){
    private val cpu = CPU.getInstance()
    override fun performAction(){
        val registerXValue = cpu.getRegisterValue(registerX.digitToInt())
        val registerYValue = cpu.getRegisterValue(registerY.digitToInt())
        val sum = registerXValue + registerYValue
        cpu.assignRegisterValue(sumRegister.toString().toInt(), sum.toString())
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}