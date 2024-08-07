import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTClass {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val readT = ReadT('0')
        readT.execute()
        assertEquals(cpu.getRegisterValue(0), "0".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val readT = ReadT('2')
        readT.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val readT = ReadT('0')
        readT.execute()
        assertEquals(cpu.getRegisterValue(0), "0".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}