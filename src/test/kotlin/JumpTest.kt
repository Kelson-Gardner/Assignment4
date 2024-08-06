import kotlin.test.Test
import kotlin.test.assertEquals

class JumpTest {
    private val cpu = CPU.getInstance()

    @Test
    fun testPerformAction(){
        val jump = Jump("1F2")
        jump.execute()
        assertEquals(cpu.programCounter, "1F2".toInt(16))
    }

    @Test
    fun testExecute(){
        val jump = Jump("FFF")
        jump.execute()
        assertEquals(cpu.programCounter, "FFF".toInt(16))
    }
}