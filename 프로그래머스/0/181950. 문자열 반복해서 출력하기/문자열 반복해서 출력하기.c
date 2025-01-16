#include <stdio.h>
#define LEN_INPUT 11

int main(void) {
    char s1[LEN_INPUT];
    int a, i = 1;
    scanf("%s %d", s1, &a);
    while (1) {
        printf("%s", s1);
        i++;
        if (i > a) break;
    }
    return 0;
}