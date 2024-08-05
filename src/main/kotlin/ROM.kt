class ROM private constructor() {
    private val memory = UByteArray(4096)
    companion object{
        @Volatile
        private var instance: ROM? = null

        fun getInstance(): ROM{
            return instance ?: synchronized(this){
                instance ?: ROM().also { instance = it }
            }
        }
    }
    fun read(address: Int): UByte {
        return memory[address]
    }

    fun loadProgram(program: UByteArray) {
        program.copyInto(memory)
    }
}