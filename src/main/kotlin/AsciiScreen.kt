class AsciiScreen {
    private val displayScreen = Array(8) { Array(8) { "*" } }

    fun assignDisplayValue(value: String, row: Int, column: Int){
        displayScreen[row][column] = value
    }

    fun getDisplayValue(row: Int, column: Int): String{
        return displayScreen[row][column]
    }

    fun displayScreen(){
        for (row in displayScreen) {
            for (element in row) {
                print("$element ")
            }
            println()
        }
        println("================")
    }
}