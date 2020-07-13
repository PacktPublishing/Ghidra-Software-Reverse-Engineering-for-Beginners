//Prompts the user for a search string and searches the 
//program listing for the first occurrence of that string.
//@category Search

import ghidra.app.script.GhidraScript;
import ghidra.app.util.headless.HeadlessScript;
import ghidra.program.model.address.Address;

public class HeadlessFindTextScript extends GhidraScript {

    /**
     * @see ghidra.app.script.GhidraScript#run()
     */
    @Override
    public void run() throws Exception {
        if (currentAddress == null) {
            println("NO CURRENT ADDRESS");
            return;
        }
        if (currentProgram == null) {
            println("NO CURRENT PROGRAM");
            return;
        }
        String search = askString("Text Search", "Enter search string: ");
        Address addr = find(search);
        if (addr != null) {
            String str = getDataAt(addr).getDefaultValueRepresentation();
            println("0x" + addr + ": " + str);
            goTo(addr);
        }
        else {
            println("No search matched found.");
        }
    }

}
