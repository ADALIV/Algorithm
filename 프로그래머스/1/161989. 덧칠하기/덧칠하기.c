#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// section_len은 배열 section의 길이입니다.
int solution(int n, int m, int section[], size_t section_len) {
    int answer = 0;
    int paint;
    for (int i=section_len-1; i>0; i--) {
        paint = section[i] - m;
        if (paint <= 0) break;
        answer++;
        while (section[i-1] > paint) {
            i--;
        }
    }
    answer++;
    return answer;
}