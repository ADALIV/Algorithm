import itertools

def solution(users, emoticons):
    # [10, 10, 10 ...]
    # [10, 10, 20 ...]
    values = [10, 20, 30, 40]
    n = len(emoticons)
    combinations = list(itertools.product(values, repeat=n))
    
    max_svc = 0
    max_sle = 0
    for combination in combinations:
        # 정해진 할인율들에 대해 각 가입자를 계산
        svc = 0
        sle = 0
        for user in users:
            dis = user[0]
            mon = user[1]
            total = 0
            for i in range(len(combination)):
                if combination[i] >= dis:
                    total += emoticons[i] * (100 - combination[i]) / 100
            if total >= mon:
                svc += 1
            else:
                sle += total
        if svc > max_svc:
            max_svc = svc
            max_sle = sle
        elif svc == max_svc:
            max_sle = max(max_sle, sle)
            
    return [max_svc, max_sle]