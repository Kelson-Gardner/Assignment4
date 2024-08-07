import kotlin.test.Test
import kotlin.test.assertEquals

class DrawTest {
    private val cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val draw = Draw('6', '0', '0')
        draw.execute()
        assertEquals(cpu.asciiDisplay.getDisplayValue(0,0), "0")
    }
}