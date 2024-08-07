import kotlin.test.Test
import kotlin.test.assertEquals

class SetATest {
    private val cpu = CPU.getInstance()

    @Test
    fun testPerformAction(){
        val setA = SetA("010")
        setA.execute()
        assertEquals(cpu.getAddress(), "0A")
    }
    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val setA = SetA("010")
        setA.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val setA = SetA("255")
        setA.execute()
        assertEquals(cpu.getAddress(), "FF")
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}