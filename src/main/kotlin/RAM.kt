class RAM private constructor() {
    // THIS WILL MOSTLY BE USED FOR THE ASCII DISPLAY

    private val memory = UByteArray(4096)
    companion object{
        @Volatile
        private var instance: RAM? = null

        fun getInstance(): RAM{
            return instance ?: synchronized(this){
                instance ?: RAM().also { instance = it }
            }
        }
    }

    fun read(address: Int): UByte {
        return memory[address]
    }

    fun write(address: Int, value: UByte) {
        memory[address] = value
    }
}