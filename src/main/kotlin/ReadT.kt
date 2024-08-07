class ReadT(
    private val register: Char
) : InstructionStrategy() {
    var cpu = CPU.getInstance()
    override fun performAction(){
        cpu.assignRegisterValue(register.toString().toInt(), cpu.timer.getTime())
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}