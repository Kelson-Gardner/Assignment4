class InstructionFactory {
    fun createInstruction(opcode: Int, operands: List<UByte>): InstructionStrategy {
        return when (opcode) {
            0x0 -> Store(operands[0], operands[1])
            0x1 -> Add(operands[0], operands[1], operands[2])
            0x2 -> Subtract(operands[0], operands[1], operands[2])
            0x3 -> Read(operands[0])
            0x4 -> Write(operands[0])
            0x5 -> Jump(operands[0])
            0x6 -> ReadKeyboard(operands[0])
            0x7 -> SwitchMemory()
            0x8 -> SkipEqual(operands[0], operands[1])
            0x9 -> SkipNotEqual(operands[0], operands[1])
            0xA -> SetA(operands[0])
            0xB -> SetT(operands[0])
            0xC -> ReadT(operands[0])
            0xD -> ConvertToBase10(operands[0])
            0xE -> ConvertByteToAscii(operands[0], operands[1])
            0xF -> Draw(operands[0], operands[1], operands[2])
            else -> throw IllegalArgumentException("Invalid opcode: $opcode")
        }
    }
}