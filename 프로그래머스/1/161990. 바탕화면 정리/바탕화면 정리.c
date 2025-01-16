#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// wallpaper_len은 배열 wallpaper의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* wallpaper[], size_t wallpaper_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * 4);
    int minX = 50, minY = 50, maxX = 0, maxY = 0;
    
    for (int i=0; i<wallpaper_len; i++) {
        for (int j=0; j<strlen(wallpaper[i]); j++) {
            if (wallpaper[i][j] == '#') {
                minX = (minX > j)? j : minX;
                minY = (minY > i)? i : minY;
                maxX = (maxX < j)? j : maxX;
                maxY = (maxY < i)? i : maxY;
            }
        }
    }
    answer[0] = minY;
    answer[1] = minX;
    answer[2] = maxY+1;
    answer[3] = maxX+1;
    return answer;
}