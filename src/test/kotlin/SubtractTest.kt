import kotlin.test.Test
import kotlin.test.assertEquals

class SubtractTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val sub = Subtract('1', '1', '0')
        sub.execute()
        assertEquals(cpu.getRegisterValue(0), "0".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val sub = Subtract('F', 'A', '6')
        sub.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val sub = Subtract('C', '8', '2')
        sub.execute()
        assertEquals(cpu.getRegisterValue(2), "4".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}