class Solution:
    def longestConsecutive(self, nums):
        # 집합으로 변환하여 중복 제거
        num_set = set(nums)
        max_len = 0
        
        for num in num_set:
            # 연속된 숫자들의 시작 숫자인지 확인
            if num - 1 not in num_set:
                current_num = num
                current_len = 1
                
                # 연속된 숫자들이 있는지 확인하며 길이를 구함
                while current_num + 1 in num_set:
                    current_num += 1
                    current_len += 1
                
                max_len = max(max_len, current_len)
        
        return max_len
