import heapq
from sys import stdin

n = int(stdin.readline())
heap = []

for _ in range(n):
    x = int(stdin.readline()) * -1

    if x == 0:
        print(heapq.heappop(heap) * -1 if heap else 0)
    else:
        heapq.heappush(heap, x)