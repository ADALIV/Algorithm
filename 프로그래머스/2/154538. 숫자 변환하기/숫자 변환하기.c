#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int x, int y, int n) {
    int answer = 0;
    int* arr = (int*)malloc(sizeof(int) * (y+1));
    arr[x] = 0;
    for (int i=x; i<y+1; i++) {
        if (arr[i] == NULL && i != x) {
            arr[i] = -1;
            continue;
        }
        if (i*2 <= y) {
            if (arr[i*2] == NULL) arr[i*2] = arr[i]+1;
            else arr[i*2] = (arr[i*2] < arr[i]+1) ? arr[i*2] : arr[i]+1;
        }
        if (i*3 <= y) {
            if (arr[i*3] == NULL) arr[i*3] = arr[i]+1;
            else arr[i*3] = (arr[i*3] < arr[i]+1) ? arr[i*3] : arr[i]+1;
        }
        if (i+n <= y) {
            if (arr[i+n] == NULL) arr[i+n] = arr[i]+1;
            else arr[i+n] = (arr[i+n] < arr[i]+1) ? arr[i+n] : arr[i]+1;
        }
    }
    answer = arr[y];
    return answer;
}