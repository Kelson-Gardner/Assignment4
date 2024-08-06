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
        val switchMemory = SwitchMemory()
        switchMemory.execute()
        assertEquals(cpu.programCounter, 6)
    }

    @Test
    fun testExecute(){
        val switchMemory = SwitchMemory()
        switchMemory.execute()
        assertEquals(cpu.getMemoryFlag(), true)
    }
}