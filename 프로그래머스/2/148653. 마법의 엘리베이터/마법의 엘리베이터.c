#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int storey) {
    int answer = 0;
    int num;
    while (storey) {
        num = storey%10;
        if (num == 5) {
            if ((storey/10)%10 > 4) {
                answer += 10-num;
                storey += 10;
            }
            else answer += num;
        }
        else if (num > 5) {
            answer += 10-num;
            storey += 10;
        }
        else if (num < 5) {
            answer += num;
        }
        storey /= 10;
    }
    return answer;
}