class Timer {
    private var time = "0".toUByte(16)
    fun setTimer(startTime: String){
        time = startTime.toUByte(16)
    }

    fun getTime(): String{
        return time.toString(16)
    }

    fun startTimer(){
        //TODO: Find a way to start the timer
    }

    fun stopTimer(){
        //TODO: Stop the timer
    }
}