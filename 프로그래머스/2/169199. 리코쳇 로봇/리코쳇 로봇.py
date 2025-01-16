from collections import deque

def solution(board):
    answer = -1
    row = len(board)
    col = len(board[0])
    way = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    
    for y in range(0, row):
        for x in range(0, col):
            if board[y][x] == "R":
                Ry, Rx = y, x
            if board[y][x] == "G":
                Gy, Gx = y, x
    visit = [[False for i in range(0, col)] for j in range(0, row)]
    q = deque()
    q.append((Ry, Rx, 0))
    visit[Ry][Rx] = True
    
    while q:
        y, x, time = q.popleft()
        if Gy == y and Gx == x:
            answer = time
            break
            
        for wayY, wayX in way:
            newY, newX = y, x
            while 1:
                newY += wayY
                newX += wayX
                if newX<0 or newX>=col or newY<0 or newY>=row or board[newY][newX] == "D":
                    if visit[newY-wayY][newX-wayX] == False:
                        visit[newY-wayY][newX-wayX] = True
                        q.append((newY-wayY, newX-wayX, time+1))
                    break
    return answer