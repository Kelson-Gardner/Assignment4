abstract class InstructionStrategy {
    fun execute(){
        performAction()
        incrementProgramCounter()
    }

    protected abstract fun performAction()

    protected open fun incrementProgramCounter(){}
}