format MZ

mov ah, 9h
mov dx, hello
int 21h

mov ax, 4c00h
int 21h

hello db 'Hello, world!', 13, 10, '$'
