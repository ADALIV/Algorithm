#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// bandage_len은 배열 bandage의 길이입니다.
// attacks_rows는 2차원 배열 attacks의 행 길이, attacks_cols는 2차원 배열 attacks의 열 길이입니다.
int solution(int bandage[], size_t bandage_len, int h, int** attacks, size_t attacks_rows, size_t attacks_cols) {
    int answer = 0;
    int health = h;
    int t = bandage[0];
    int x = bandage[1];
    int y = bandage[2];
    int current = 0;
    int sequence = 0;
    
    for (int i=0; i<=attacks[attacks_rows-1][0]; i++) {
        if (i == attacks[current][0]) {
            health -= attacks[current][1];
            sequence = 0;
            current++;
            if (health <= 0) return -1;
        }
        else {
            health += x;
            sequence++;
            if (sequence == t) {
                health += y;
                sequence = 0;
            }
            if (health >= h) health = h;
        }
    }
    answer = health;
    return answer;
}