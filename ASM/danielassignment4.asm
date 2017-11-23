; Daniel Assignment 4
; Programmer: Jennifer Daniel
; Program: Assignment 4
; Program purpose: User should enter 5 lowercase letters. If they do, the letters
; will be shifted 5 characters forward.
; Program date: 21 November 2017

					; CONSTANTS
SYS_EXIT  equ 1		                    ; system call for exit
SYS_READ  equ 3                             ; system call for read
SYS_WRITE equ 4                             ; system call for write
STDIN     equ 0                             ; standard in
STDOUT    equ 1                             ; standard out

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

segment .data 		                    ; DECLARE AND INITIALIZE DATA

                                            ; OUTPUT FOR INPUT PROMPT
   msg1 db "Enter 5 characters: ", 0xA, 0 	    ; adds a newline at the end of the string, is also zero delimated
   len1 equ $- msg1 	                        ; gets the length by subtracing the current location from the location of msg

                                            ; NEWLINE SEQUENCE
   newline db 0xA, 0	                    
   len2 equ $- newline

   msg2 db "Shifted input: ", 0xA, 0        ; OUTPUT FOR SHIFTED INPUT
   len3 equ $- msg2

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

segment .bss                            ; DECLARE VARIABLES

   input resd 5 		            ; to hold characters entered by the user
   res resd 1
   temp resd 1

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

section	.text
   global _start                        ; must be declared for using gcc

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

_start:                         ; START PROGRAM
   mov eax, SYS_WRITE                   ; do prompt : ask for input of 5 characters   
   mov ebx, STDOUT         
   mov ecx, msg1         
   mov edx, len1 
   int 0x80                

   mov eax, SYS_READ 	                ; get input of 5 lowercase characters
   mov ebx, STDIN  
   mov ecx, input 
   mov edx, 5
   int 0x80

   mov eax, SYS_WRITE                   ; label new output   
   mov ebx, STDOUT         
   mov ecx, msg2         
   mov edx, len3 
   int 0x80            

   mov ecx, input			; increment each character of the entered text
top: 				; START LOOP
   mov al, [ecx]			; loop through each character of the input
   inc ecx

   cmp al, 0			; if pointing at null, escape the loop
   jz done

   cmp al, 'z'			; if letter entered not between a and z, don't shift
   jg skip

   cmp al, 'a'				
   jl skip

   sub al, '0'				; shift the letter 5 characters
   adc al, 5
   add al, '0'

   cmp al, 'z'				; if shift went past z, roll over to beginning of alphabet
   jl skip

   sub al, '0'
   sub al, 26
   add al, '0'

skip:
   
   mov [res], al

   mov [temp], ecx			; save ecx temporarily
 
   mov eax, SYS_WRITE			; print shifted character or entered character
   mov ebx, STDOUT
   mov ecx, res
   mov edx, 1
   int 0x80

   mov ecx, [temp]

   jmp top 			; REENTER LOOP

done: 				; END LOOP 			

   mov eax, SYS_WRITE                   ; print a new line       
   mov ebx, STDOUT
   mov ecx, newline         
   mov edx, len2        
   int 0x80

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

exit:    		; properly exit the program
   
   mov eax, SYS_EXIT   
   xor ebx, ebx 
   int 0x80