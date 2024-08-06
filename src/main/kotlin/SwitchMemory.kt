class SwitchMemory : InstructionStrategy() {
    var cpu = CPU.getInstance()

    override fun performAction() {
        //TODO: implement the switch memory instruction
        cpu.toggleMemoryFlag()
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}