class SetT (
    private val timerStartValue: String
) : InstructionStrategy() {
    private val cpu = CPU.getInstance()

    override fun performAction() {
        cpu.timer.setTimer(timerStartValue)
    }

    override fun incrementProgramCounter() {
        cpu.incrementProgramCounter()
    }
}