#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// score_len은 배열 score의 길이입니다.
int solution(int k, int m, int score[], size_t score_len) {
    int answer = 0;
    int* arr = (int*)malloc(sizeof(int) * k);
    for (int i=0; i<k; i++) {
        arr[i] = 0;
    }
    for (int i=0; i<score_len; i++) {
        int num = score[i];
        arr[num-1]++;
    }
    
    for (int i=k-1; i>0; i--) {
        answer += (i+1) * (arr[i]/m);
        arr[i-1] += arr[i]%m;
    }
    if ((arr[0]/m) > 0) {
        answer += arr[0]/m;
    }
    return answer*m;
}