import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToBase10Test {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val convertToBase10 = ConvertToBase10('1')
        convertToBase10.execute()
        assertEquals(cpu.getAddress(), "00")
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val convertToBase10 = ConvertToBase10('2')
        convertToBase10.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val convertToBase10 = ConvertToBase10('4')
        convertToBase10.execute()
        assertEquals(cpu.getAddress(), "00")
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}