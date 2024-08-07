class Emulator {

    fun loadAndRunProgram() {
        val cpu = CPU.getInstance()
        val file = cpu.runProgram()
        cpu.loadProgramInROM(file)
        cpu.execute()
    }

    fun stopProgram() {
        //TODO: implement the stopping of the program
    }
}