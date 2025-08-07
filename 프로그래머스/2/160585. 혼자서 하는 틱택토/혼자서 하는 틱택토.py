def solution(board):
    # O와 X의 개수 세기
    num_o = 0
    num_x = 0
    
    for line in board:
        for i in range(3):
            if line[i] == 'O':
                num_o += 1
            elif line[i] == 'X':
                num_x += 1
    
    # O의 개수가 X의 개수보다 적으면 안됨
    if num_o < num_x:
        return 0
    
    # 빙고 체크
    def check_bingo(player):
        # 플레이어가 승리한 상태를 체크
        for i in range(3):
            # 가로, 세로 체크
            if all(board[i][j] == player for j in range(3)) or all(board[j][i] == player for j in range(3)):
                return True
        # 대각선 체크
        if board[0][0] == player and board[1][1] == player and board[2][2] == player:
            return True
        if board[0][2] == player and board[1][1] == player and board[2][0] == player:
            return True
        return False

    # O와 X의 승리 여부 체크
    o_bingo = check_bingo('O')
    x_bingo = check_bingo('X')

    # O와 X가 동시에 승리할 수 없음
    if o_bingo and x_bingo:
        return 0

    # O가 승리했으면 O의 개수가 X보다 하나 더 많아야 함
    if o_bingo and num_o != num_x + 1:
        return 0

    # X가 승리했으면 X의 개수가 O와 같아야 함
    if x_bingo and num_o != num_x:
        return 0
    
    if num_o - num_x > 1:
        return 0

    # 이상이 없다면 정상적인 게임 진행
    return 1
