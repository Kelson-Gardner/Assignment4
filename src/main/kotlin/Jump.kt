class Jump(
    val registerJump: String
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()
    override fun performAction() {
        cpu.programCounter = registerJump.toInt(16)
        if(cpu.programCounter % 2 != 0){
            // TODO: implement either facade pattern method or pu method that will stop the program
        }
    }
}