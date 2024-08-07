class Store(
    private val register: Char,
    private val byte: String
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction(){
        cpu.assignRegisterValue(register.digitToInt(16), byte)
    }
    override fun incrementProgramCounter(){
        cpu.incrementProgramCounter()
    }
}