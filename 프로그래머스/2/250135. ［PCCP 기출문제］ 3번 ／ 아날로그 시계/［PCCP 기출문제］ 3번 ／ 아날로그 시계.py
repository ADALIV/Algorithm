def count_alarms_from_zero(h, m, s):
    total_seconds = h * 3600 + m * 60 + s
    sec_minute_alarms = (total_seconds * 59) // 3600
    sec_hour_alarms = (total_seconds * 719) // 43200
    common_alarms = total_seconds // 43200

    return sec_minute_alarms + sec_hour_alarms - common_alarms


def solution(h1, m1, s1, h2, m2, s2):
    start_count = count_alarms_from_zero(h1, m1, s1)
    end_count = count_alarms_from_zero(h2, m2, s2)
    start_total_seconds = h1 * 3600 + m1 * 60 + s1
    total_alarms = end_count - start_count

    if (start_total_seconds * 59) % 3600 == 0 or (start_total_seconds * 719) % 43200 == 0:
        total_alarms += 1

    return total_alarms
