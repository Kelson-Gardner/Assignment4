import kotlin.test.Test
import kotlin.test.assertEquals

class SwitchMemoryTest {
    private val cpu = CPU.getInstance()

    @Test
    fun testPerformAction(){
        val switchMemory = SwitchMemory()
        switchMemory.execute()
        assertEquals(cpu.getMemoryFlag(), false)
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val switchMemory = SwitchMemory()
        switchMemory.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val switchMemory = SwitchMemory()
        switchMemory.execute()
        assertEquals(cpu.getMemoryFlag(), true)
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}