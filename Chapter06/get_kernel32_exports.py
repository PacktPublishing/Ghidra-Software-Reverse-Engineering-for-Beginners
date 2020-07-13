import pefile
pe=pefile.PE("c:\\windows\\system32\\kernel32.dll")
exports=set()
for exp in pe.DIRECTORY_ENTRY_EXPORT.symbols:
    exports.add(exp.name.decode('ascii'))
print(exports)