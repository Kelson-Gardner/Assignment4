class Emulator {

    fun loadAndRunProgram() {
        val cpu = CPU.getInstance()
        val file = cpu.runProgram()
        cpu.loadProgramInROM(file)
        cpu.execute()
    }

    fun printToScreen(){
        //TODO: implement
    }

    fun stopProgram() {
        //TODO: implement the stopping of the program
    }
}