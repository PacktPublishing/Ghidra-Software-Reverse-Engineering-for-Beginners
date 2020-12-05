#This simple script allows you to patch bytes with NOP opcode
#@author Packt
#@category Memory
#@keybinding ctrl alt shift n
#@menupath Tools.Packt.Nop
#@toolbar 

currentAddr = currentLocation.getByteAddress()
nop = 0x90
instructionSize = getInstructionAt(currentAddr).getDefaultFallThroughOffset()
removeInstructionAt(currentAddr)
for i in range(instructionSize):
    setByte(currentAddr.addWrap(i), nop)
disassemble(currentAddr)