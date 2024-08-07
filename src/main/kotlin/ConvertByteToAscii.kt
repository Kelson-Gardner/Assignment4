class ConvertByteToAscii(
    private val registerX: Char,
    private val registerY: Char
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        val firstRegister = cpu.getRegisterValue(registerX.toString().toInt())
        if(firstRegister.toInt() > 16){
            //TODO: make the program crash
        }
        cpu.assignRegisterValue(registerY.toString().toInt(), firstRegister.toString(16))
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}