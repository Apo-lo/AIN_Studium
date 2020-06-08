%include "io.inc"

section .data
    result dd 0
    number dd 5
    
section .text
global CMAIN

CMAIN:
    mov ebp, esp; for correct debugging
    mov eax, 5
SUM:
    push eax
    cmp eax, 0
    jz END
    dec eax
    call SUM
    pop eax
    add [result], eax
    ret
END:
    pop eax
    ret