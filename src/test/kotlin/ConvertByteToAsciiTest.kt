import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertByteToAsciiTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        cpu.assignRegisterValue(0, "4")
        val convertByteToAscii = ConvertByteToAscii('0', '1')
        convertByteToAscii.execute()
        assertEquals(cpu.getRegisterValue(1), "04".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val convertByteToAscii = ConvertByteToAscii('2', '4')
        convertByteToAscii.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        cpu.assignRegisterValue(5, "F")
        val previousProgramCounter = cpu.programCounter
        val convertByteToAscii = ConvertByteToAscii('5', '6')
        convertByteToAscii.execute()
        assertEquals(cpu.getRegisterValue(6), "F".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}