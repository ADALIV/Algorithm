#include <stdio.h>
#define LEN_INPUT 10

int main(void) {
    char s1[LEN_INPUT];
    scanf("%s", s1);

    int i = 0;
    while (s1[i] != 0) {
        if (s1[i] < 'a') printf("%c", s1[i] + 32);
        else printf("%c", s1[i] - 32);
        i++;
    }
    return 0;
}
