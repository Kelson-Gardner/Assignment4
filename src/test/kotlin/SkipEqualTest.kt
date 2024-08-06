import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val oldProgramCounter = cpu.programCounter
        cpu.assignRegisterValue(1, "5")
        cpu.assignRegisterValue(0, "F")
        val skipEqual = SkipEqual('1', '0')
        skipEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val oldProgramCounter = cpu.programCounter
        cpu.assignRegisterValue(3, "6")
        cpu.assignRegisterValue(1, "5")
        val skipEqual = SkipEqual('3', '1')
        skipEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 2)
    }

    @Test
    fun testSkip(){
        val oldProgramCounter = cpu.programCounter
        val skipEqual = SkipEqual('1', '1')
        skipEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 4)
    }
}