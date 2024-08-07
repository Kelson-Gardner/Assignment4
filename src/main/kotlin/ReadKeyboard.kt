class ReadKeyboard(
    val register: Char,
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        println("Enter a number between 0 and F")
        var input = readln()
        cpu.assignRegisterValue(register.toString().toInt(), input)
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}