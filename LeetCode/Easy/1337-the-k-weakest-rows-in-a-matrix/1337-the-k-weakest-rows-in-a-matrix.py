import heapq

class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        # 힙에 (병사 수, 행 번호) 쌍을 저장하며 병사 수를 기준으로 정렬
        min_heap = [(sum(row), i) for i, row in enumerate(mat)]
        heapq.heapify(min_heap)

        # 최소 힙에서 k개의 가장 취약한 행의 행 번호를 추출하여 결과 리스트에 저장
        result = [heapq.heappop(min_heap)[1] for _ in range(k)]

        return result