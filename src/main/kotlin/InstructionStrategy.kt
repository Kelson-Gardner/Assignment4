abstract class InstructionStrategy {
    private var instructionBytes: UByte = (0).toUByte()
    private
    fun execute(){
        fetchBytes()
        decodeBytes()
        performAction()
        hook()
    }

    protected fun fetchBytes(){
        // Something like ROM.readLine() so it can get the next instruction from the ROM
    }

    protected fun decodeBytes(){

    }
    protected abstract fun performAction() //TODO: perform the action to be performed

    protected fun hook(): Boolean{
        return false
    } //TODO: Increment the counter
}