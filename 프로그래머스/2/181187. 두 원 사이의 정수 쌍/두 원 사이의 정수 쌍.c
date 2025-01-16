#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

long long solution(int r1, int r2) {
    long long answer = 0;
    long long R2 = pow(r2, 2);
    long long R1 = pow(r1, 2);
    for (int i=1; i<=r2; i++) {
        long long max = (long long)floor(sqrt(1.0*R2 - 1.0*i*i));
        long long min = (long long)ceil(sqrt(1.0*R1 - 1.0*i*i));
        answer += max - min + 1;
    }
    return answer * 4;
}