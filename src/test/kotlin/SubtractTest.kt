import kotlin.test.Test
import kotlin.test.assertEquals

class SubtractTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        cpu.assignRegisterValue(1, "38")
        val sub = Subtract('1', '1', '0')
        sub.execute()
        assertEquals(cpu.getRegisterValue(0), "0".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val sub = Subtract('3', '2', '6')
        sub.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        cpu.assignRegisterValue(3, "29")
        cpu.assignRegisterValue(2, "20")
        val previousProgramCounter = cpu.programCounter
        val sub = Subtract('3', '2', '2')
        sub.execute()
        assertEquals(cpu.getRegisterValue(2), "9".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}