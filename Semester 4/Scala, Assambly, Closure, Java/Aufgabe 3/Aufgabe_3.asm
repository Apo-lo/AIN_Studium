%include "io.inc"

section .data
    number dd 6
    result dd 0
    
section .text
    global CMAIN
    
CMAIN:
    mov ebp, esp            ; for correct debugging
    cmp [number], dword 0   ; check if number==0
    jz ISZERO               ; if number==0 goto ISZERO
    mov eax, 3              ; eax=3
    mov ebx, 3              ; ebx=3
    mov ecx, [number]       ; ecx=number
    dec ecx                 ; ecx=ecx-1
    
HOCH3:
    mul ebx                 ; eax=eax*3
    dec ecx                 ; ecx=ecx-1
    jnz HOCH3               ; if ecx!=0 goto POT
    mov [result], eax       ; result=eax
    jmp END                 ;goto END
    
ISZERO:
    mov result, 1           ;If number == 0 3^number = 1
    
END:
    ret