import kotlin.test.Test
import kotlin.test.assertEquals

class StoreTest {
    var cpu = CPU.getInstance()
    @Test
    fun testPerformAction(){
        val store = Store('0', "10")
        store.execute()
        assertEquals(cpu.getRegisterValue(0), "10".toUByte(16))
    }

    @Test
    fun testIncrementProgramCounter(){
        val previousProgramCounter = cpu.programCounter
        val store = Store('5', "6F")
        store.execute()
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }

    @Test
    fun testExecute(){
        val previousProgramCounter = cpu.programCounter
        val store = Store('2', "FF")
        store.execute()
        assertEquals(cpu.getRegisterValue(2), "FF".toUByte(16))
        assertEquals(cpu.programCounter - previousProgramCounter, 2)
    }
}