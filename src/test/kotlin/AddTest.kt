import kotlin.test.Test
import kotlin.test.assertEquals

class AddTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        cpu.assignRegisterValue(1, "1")
        val add = Add('1', '1', '0')
        add.execute()
        assertEquals(cpu.getRegisterValue(0), "2".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val add = Add('2', '6', '6')
        add.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        cpu.assignRegisterValue(2, "F")
        cpu.assignRegisterValue(6, "3")
        val previousProgramCounter = cpu.programCounter
        val add = Add('2', '6', '2')
        add.execute()
        assertEquals(cpu.getRegisterValue(2), "18".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}