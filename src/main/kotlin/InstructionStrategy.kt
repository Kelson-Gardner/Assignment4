abstract class InstructionStrategy {
    fun execute(){
        performAction()
        incrementProgramCounter()
    }

    protected abstract fun performAction()

    protected open fun incrementProgramCounter(){
        println("This is the increment program counter method")
    }//TODO: Increment the counter
}