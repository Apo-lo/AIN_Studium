%include "io.inc"

section .data
    result dd 0
    
section .text
global CMAIN

CMAIN:
    mov ebp, esp            ; for correct debugging
    mov eax, 495            ; eax=Zahl
    jz END                  ; if eax == 0 goto END
    mov ecx, eax            ; ecx=eax
    mov ebx, 0              ; Teilersumme=0
    dec ecx                 ; ecx--
    jz END                  ; if ecx==0 goto END
    
DIVISION:
    push eax                ; push eax aud Stack
    mov edx, 0              ; edx=0
    div ecx                 ; eax=eax/ecx Rest:edx=edx%ecx
    cmp edx, 0              ; edx==0 ?
    jnz IFMODNOT0           ; if edx!=0 goto IFMODNOT0
    add ebx, ecx            ; ebx=ebc+ecx
    
IFMODNOT0:
    pop eax                 ; Pop eax vom Stack
    dec ecx                 ; ecx--
    jnz DIVISION            ; if ecx!=0 goto DIVISION
    cmp eax, ebx            ; eax==ebx
    jnz END                 ; if eax!=ebx goto END
    mov [result], ebx       ; setze result auf true
    
END:
    ret