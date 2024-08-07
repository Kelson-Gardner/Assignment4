import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTest {
    private val cpu = CPU.getInstance()

    @Test
    fun testPerformAction(){
        val read = Read('2')
        cpu.assignAddressValue("FF".toUByte(16))
        read.execute()
        assertEquals(cpu.getRegisterValue(2), "FF".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val read = Read('0')
        read.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val read = Read('7')
        cpu.assignAddressValue("F1".toUByte(16))
        read.execute()
        assertEquals(cpu.getRegisterValue(7), "F1".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}