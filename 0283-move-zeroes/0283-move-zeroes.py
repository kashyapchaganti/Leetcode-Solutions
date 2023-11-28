class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        """
        if len(nums) in [0, 1]:
            return nums

        nonzeroCount = 0

        for element in nums:
            if element != 0:
                nonzeroCount += 1

        insertPtr = 0
        currPtr = 0

        while nonzeroCount > 0 and currPtr < len(nums):
            print("currPtr {} , insertPtr {}, nonzeroCount {}".format(currPtr, insertPtr, nonzeroCount))

            if currPtr != insertPtr and nums[currPtr] != 0:            
                nums[insertPtr] = nums[currPtr]
                nums[currPtr] = 0
                insertPtr += 1
                nonzeroCount -= 1        
                print("Index {}, NewVal {}".format(insertPtr, nums[insertPtr]))

            if currPtr == insertPtr and nums[currPtr] != 0:
                insertPtr += 1

            currPtr += 1
        