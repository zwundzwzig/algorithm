import heapq

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # 우선순위 큐로 최대 힙을 구현
        max_heap = [-num for num in nums]
        heapq.heapify(max_heap)

        # 최댓값 두 개를 추출하여 최댓값 계산
        largest1 = -heapq.heappop(max_heap)
        largest2 = -heapq.heappop(max_heap)

        return (largest1 - 1) * (largest2 - 1)
