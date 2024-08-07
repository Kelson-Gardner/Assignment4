import kotlin.test.Test
import kotlin.test.assertEquals

class DrawTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        cpu.assignRegisterValue(6, "32")
        val draw = Draw('6', '0', '0')
        draw.execute()
        assertEquals(cpu.asciiDisplay.getDisplayValue(0,0), "2")
    }
}