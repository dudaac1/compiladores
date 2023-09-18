#include <stdio.h>
#include <stdlib.h>


int fibonacci(int num) {
if (num < 2) {
return num;
}
return fibonacci(num - 1) + fibonacci(num - 2);
}

int main () {
int n;
n = 9;
if (n > 0) {
printf("%d", fibonacci(n));
}
return 0;
}