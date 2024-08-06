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
        val store = Store('5', "6F")
        store.execute()
        assertEquals(cpu.programCounter, 6)
    }

    @Test
    fun testExecute(){
        val store = Store('2', "FF")
        store.execute()
        assertEquals(cpu.getRegisterValue(2), "FF".toUByte(16))
        assertEquals(cpu.programCounter, 2)
    }
}