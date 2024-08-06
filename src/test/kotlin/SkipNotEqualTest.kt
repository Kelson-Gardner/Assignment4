import kotlin.test.Test
import kotlin.test.assertEquals

class SkipNotEqualTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val oldProgramCounter = cpu.programCounter
        cpu.assignRegisterValue(1, "5")
        cpu.assignRegisterValue(0, "5")
        val skipNotEqual = SkipNotEqual('1', '0')
        skipNotEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val oldProgramCounter = cpu.programCounter
        cpu.assignRegisterValue(3, "6")
        cpu.assignRegisterValue(1, "6")
        val skipNotEqual = SkipNotEqual('3', '1')
        skipNotEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 2)
    }

    @Test
    fun testSkip(){
        val oldProgramCounter = cpu.programCounter
        val skipNotEqual = SkipNotEqual('1', '0')
        skipNotEqual.execute()
        assertEquals(cpu.programCounter - oldProgramCounter, 4)
    }
}