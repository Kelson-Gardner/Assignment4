class CPU private constructor(){
    private val registers = UByteArray(8)
    var programCounter: Int = 0 // 16 bit register, stores address of current instruction. SHOULD ALWAYS INCREMENT BY 2!!
    var timer: Int = 0 // 8 bit register for storing the timer value
    // While the t value is above 0, the program decrements the value by 1 at 60hz (every 16ms
    var address: Int = 0 // 16 bit register for storing an address
    var memoryFlag: Boolean = false // 0 = RAM 1 = ROM

    companion object {
        @Volatile
        private var instance: CPU? = null

        fun getInstance(): CPU{
            return instance ?: synchronized(this) {
                instance ?: CPU().also {instance = it}
            }
        }
    }
}
