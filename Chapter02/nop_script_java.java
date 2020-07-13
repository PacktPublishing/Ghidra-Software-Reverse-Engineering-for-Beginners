//This simple script allows you to patch bytes with NOP opcode
//@author Packt
//@category Memory
//@keybinding ctrl alt shift n 
//@menupath Tools.Packt.nop
//@toolbar 
import ghidra.app.script.GhidraScript;
import ghidra.program.model.util.*;
import ghidra.program.model.reloc.*;
import ghidra.program.model.data.*;
import ghidra.program.model.block.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.scalar.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.lang.*;
import ghidra.program.model.pcode.*;
import ghidra.program.model.address.*;

public class NopScript extends GhidraScript {

    public void run() throws Exception {
		Address startAddr = currentLocation.getByteAddress();
		byte nop = (byte)0x90;
		try {
			setByte(startAddr, nop);
		}
		catch (MemoryAccessException e) {
			popup("Unable to nop this byte");
			return;
		}
    }
}