class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index_dict = dict()
        for index, num in enumerate(nums):
            check = target - num
            if check in index_dict:
                return [index, index_dict[check]]
            else:
                index_dict[num] = index