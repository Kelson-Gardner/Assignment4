import kotlin.test.Test
import kotlin.test.assertEquals

class AsciiScreenTest {
    private val cpu = CPU.getInstance()

    @Test
    fun testAssignDisplayValue(){
        cpu.asciiDisplay.assignDisplayValue("H", 0, 0)
        cpu.asciiDisplay.getDisplayValue(0, 0)
        assertEquals(cpu.asciiDisplay.getDisplayValue(0, 0), "H")
    }

    @Test
    fun testGetDisplayValue(){
        cpu.asciiDisplay.assignDisplayValue("H", 0, 0)
        assertEquals(cpu.asciiDisplay.getDisplayValue(0, 0), "H")
        assertEquals(cpu.asciiDisplay.getDisplayValue(7, 7), "*")
    }
}