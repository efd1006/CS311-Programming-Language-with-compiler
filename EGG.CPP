#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

void main(){

int eggs = 0;
char salt;
printf("How many eggs: \n");
scanf("%i",&eggs);
printf("Crack the eggs \n");
printf("Put the eggs on the pan \n");

printf("Add some salt? Y/N");
scanf("%c",salt);

if(salt == 'y'){
printf("Serve");

}else{
printf("wait");
}
 getch();
 clrscr();
}