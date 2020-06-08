%include "io.inc"

section .data
    number dw 5
    result dw 0
    
section .text
    global CMAIN
    
CMAIN:
    mov ebp, esp        ; for correct debugging
    mov ecx, [number]   ; ecx=number
    
SUM:
    add [result], ecx   ; result=result+ecx
    dec ecx             ; ecx=ecx-1
    jnz SUM             ; if ecx!=0 goto SUM
    ret