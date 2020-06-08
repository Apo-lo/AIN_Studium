%include "io.inc"

section .text
    global CMAIN
    
CMAIN:
    mov ebp, esp    ; for correct debugging
    mov ecx, 5      ; ecx=5
    mov eax, 0      ; eax=0
    
SUM:
    add eax, ecx    ; eax=eax+ecx
    dec ecx         ; ecx=ecx-1
    jnz SUM         ; if ecx!=0 goto SUM
    ret