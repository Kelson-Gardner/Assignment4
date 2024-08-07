import kotlin.test.Test
import kotlin.test.assertEquals

class SetTTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val setT = SetT("ff")
        setT.execute()
        assertEquals(cpu.timer.getTime(), "ff")
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val setT = SetT("ff")
        setT.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val setT = SetT("4a")
        setT.execute()
        assertEquals(cpu.timer.getTime(), "4a")
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}