#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

long long solution(int k, int d) {
    long long answer = 0;
    long D = (long)d*d;
    for (int a=0; a<=d; a+=k) {
        int b = (int)sqrt(D-(long)a*a);
        answer += b/k + 1;
    }
    return answer;
}