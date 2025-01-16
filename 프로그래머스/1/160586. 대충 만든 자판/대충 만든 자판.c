#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int find(char* keymap[], char ch, size_t keymap_len) {
    int cnt = 101;
    for (int i=0; i<keymap_len; i++) {
        for (int j=0; j<strlen(keymap[i]); j++) {
            if (keymap[i][j] == ch && cnt > j+1) {
                cnt = j + 1;
            }
        }
    }
    if (cnt == 101) return -1;
    return cnt;
}
int* solution(const char* keymap[], size_t keymap_len, const char* targets[], size_t targets_len) {
    int* answer = (int*)malloc(sizeof(int) * targets_len);
    int temp;
    
    for (int i=0; i<targets_len; i++) {
        answer[i] = 0;
        for (int j=0; j<strlen(targets[i]); j++) {
            temp = find(keymap, targets[i][j], keymap_len);
            if (temp == -1) {
                answer[i] = temp;
                break;
            }
            else answer[i] += temp;
        }
    }
    return answer;
}