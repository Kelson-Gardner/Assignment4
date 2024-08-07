class Draw(
    private val registerX: Char,
    private val row: Char,
    private val column: Char
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val registerValue = cpu.getRegisterValue(registerX.toString().toInt())
        cpu.asciiDisplay.assignDisplayValue(registerValue.toInt().toChar().toString(), row.toString().toInt(), column.toString().toInt())
        cpu.asciiDisplay.displayScreen()
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}