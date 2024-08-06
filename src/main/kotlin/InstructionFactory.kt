class InstructionFactory {
    fun createInstruction(opcode: Int, operands: String): InstructionStrategy {
        println("This is the opcode $opcode")
        println("This is the operand $operands")
        return when (opcode) {
            0 -> Store(operands[0], operands[1].toString() + operands[2].toString())
            1 -> Add(operands[0], operands[1], operands[2])
            2 -> Subtract(operands[0], operands[1], operands[2])
            3 -> Read(operands[0])
            4 -> Write(operands[0])
            5 -> Jump(operands[0].toString() + operands[1].toString() + operands[2].toString())
            6 -> ReadKeyboard(operands[0])
            7 -> SwitchMemory()
            8 -> SkipEqual(operands[0], operands[1])
            9 -> SkipNotEqual(operands[0], operands[1])
            10 -> SetA(operands[0].toString() + operands[1].toString() + operands[2].toString())
            11-> SetT(operands[0])
            12-> ReadT(operands[0])
            13 -> ConvertToBase10(operands[0])
            14 -> ConvertByteToAscii(operands[0], operands[1])
            15 -> Draw(operands[0], operands[1], operands[2])
            else -> throw IllegalArgumentException("Invalid opcode: $opcode")
        }
    }
}