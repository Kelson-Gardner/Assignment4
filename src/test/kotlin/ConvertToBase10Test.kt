import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToBase10Test {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        cpu.assignRegisterValue(1, "A")
        val convertToBase10 = ConvertToBase10('1')
        convertToBase10.execute()
        assertEquals(cpu.getAddress(), "0A")
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
        cpu.assignRegisterValue(0, "4")
        val previousProgramCounter = cpu.programCounter
        val convertToBase10 = ConvertToBase10('0')
        convertToBase10.execute()
        assertEquals(cpu.getAddress(), "04")
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}