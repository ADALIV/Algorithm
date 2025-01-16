#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

void goN(char* park[], size_t park_len, int num) {
    int row, col, check = 0;
    for (int i=0; i<park_len; i++) {
        for (int j=0; j<strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                row = i;
                col = j;
                break;
            }
        }
    }
    if (row - num >= 0) {
        for  (int i=row; i>=row-num; i--) {
            if (park[i][col] == 'X') {
                check = 1;
                break;
            }
        }
    }
    if (check == 0 && row - num >= 0) {
        park[row][col] = 'O';
        park[row-num][col] = 'S';
    }
}
void goS(char* park[], size_t park_len, int num) {
    int row, col, check = 0;
    for (int i=0; i<park_len; i++) {
        for (int j=0; j<strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                row = i;
                col = j;
                break;
            }
        }
    }
    if (row + num < park_len) {
        for  (int i=row; i<=row+num; i++) {
            if (park[i][col] == 'X') {
                check = 1;
                break;
            }
        }
    }
    if (check == 0 && row + num < park_len) {
        park[row][col] = 'O';
        park[row+num][col] = 'S';
    }
}
void goW(char* park[], size_t park_len, int num) {
    int row, col, check = 0;
    for (int i=0; i<park_len; i++) {
        for (int j=0; j<strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                row = i;
                col = j;
                break;
            }
        }
    }
    if (col - num >= 0) {
        for  (int i=col; i>=col-num; i--) {
            if (park[row][i] == 'X') {
                check = 1;
                break;
            }
        }
    }
    if (check == 0 && col - num >= 0) {
        park[row][col] = 'O';
        park[row][col-num] = 'S';
    }
}
void goE(char* park[], size_t park_len, int num) {
    int row, col, check = 0;
    for (int i=0; i<park_len; i++) {
        for (int j=0; j<strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                row = i;
                col = j;
                break;
            }
        }
    }
    if (col + num < strlen(park[row])) {
        for  (int i=col; i<=col+num; i++) {
            if (park[row][i] == 'X') {
                check = 1;
                break;
            }
        }
    }
    if (check == 0 && col + num < strlen(park[row])) {
        park[row][col] = 'O';
        park[row][col+num] = 'S';
    }
}
int* solution(const char* p[], size_t park_len, const char* routes[], size_t routes_len) {
    char** park = p;
    int* answer = (int*)malloc(sizeof(int) * 2);
    for (int i=0; i<routes_len; i++) {
        switch  (routes[i][0]) {
            case 'N':
                goN(park, park_len, routes[i][2]-'0');
                break;
            case 'S':
                goS(park, park_len, routes[i][2]-'0');
                break;
            case 'W':
                goW(park, park_len, routes[i][2]-'0');
                break;
            case 'E':
                goE(park, park_len, routes[i][2]-'0');
                break;
        }
    }
    for (int i=0; i<park_len; i++) {
        for (int j=0; j<strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                answer[0] = i;
                answer[1] = j;
            }
        }
    }
    return answer;
}