class SwitchMemory : InstructionStrategy() {
    var cpu = CPU.getInstance()

    override fun performAction() {
        cpu.toggleMemoryFlag()
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}