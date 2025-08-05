class Server:
    def __init__(self, start_time, k):
        self.start_time = start_time
        self.end_time = start_time + k  # 서버가 끝나는 시간

def solution(players, m, k):
    active_servers = []  # 현재 운영 중인 서버들의 리스트
    expansions = 0       # 증설 횟수
    total_servers = 0    # 현재 서버의 총 수 (반납된 서버 제외)

    for current_time in range(24):
        # 종료된 서버들 제거
        active_servers = [server for server in active_servers if server.end_time > current_time]
        total_servers = len(active_servers)

        # 현재 시간에 필요한 서버 수 계산
        required_servers = players[current_time]//m

        if required_servers > total_servers:
            for i in range(required_servers - total_servers):
                active_servers.append(Server(current_time, k))
                expansions += 1
    return expansions