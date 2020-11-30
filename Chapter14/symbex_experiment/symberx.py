#!/usr/bin/python3
from miasm.analysis.binary import Container
from miasm.analysis.machine import Machine
from miasm.core.locationdb import LocationDB
from miasm.ir.symbexec import SymbolicExecutionEngine

start_addr = 0x402300
loc_db = LocationDB()
target_file = open("hello_world.exe", 'rb')
container = Container.from_stream(target_file, loc_db)

machine = Machine(container.arch)
mdis = machine.dis_engine(container.bin_stream, 
                          loc_db=loc_db)
ira = machine.ira(mdis.loc_db)
asm_cfg = mdis.dis_multiblock(start_addr)
ira_cfg = ira.new_ircfg_from_asmcfg(asm_cfg)
symbex = SymbolicExecutionEngine(ira)
symbex_state = symbex.run_block_at(ira_cfg, start_addr)
print (symbex_state)