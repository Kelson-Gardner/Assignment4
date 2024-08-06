import kotlin.test.Test
import kotlin.test.assertEquals

class SetATest {
    private val cpu = CPU.getInstance()

    @Test
    fun testPerformAction(){
        val setA = SetA("FFF")
        setA.execute()
        assertEquals(cpu.getAddress(), "FFF")
    }
    @Test
    fun testIncrementProgramCounter(){
        val setA = SetA("102")
        setA.execute()
        assertEquals(cpu.programCounter, 4)
    }
    @Test
    fun testExecute(){
        val setA = SetA("1F2")
        setA.execute()
        assertEquals(cpu.getAddress(), "1F2")
        assertEquals(cpu.programCounter, 2)
    }
}