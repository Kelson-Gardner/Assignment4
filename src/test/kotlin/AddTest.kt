import kotlin.test.Test
import kotlin.test.assertEquals

class AddTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val add = Add('1', '1', '0')
        add.execute()
        assertEquals(cpu.getRegisterValue(0), "2".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val add = Add('F', 'A', '6')
        add.execute()
        assertEquals(cpu.programCounter, 6)
    }

    @Test
    fun testExecute(){
        val add = Add('A', 'C', '2')
        add.execute()
        assertEquals(cpu.getRegisterValue(2), "22".toUByte(16))
        assertEquals(cpu.programCounter, 2)
    }
}