class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        result = 0
        
        for s in stones:
            for j in jewels:
                if s == j:
                    result += 1
        
        return result