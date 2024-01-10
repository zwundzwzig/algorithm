import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // 최소 힙을 사용하여 행의 강도를 저장
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) 
                return Integer.compare(a[1], b[1]); // 병사 수를 기준으로 정렬
            else 
                return Integer.compare(a[0], b[0]); // 행 번호를 기준으로 정렬
        });

        // 행의 강도를 최소 힙에 저장
        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            minHeap.offer(new int[]{i, soldiers});
        }

        // 결과 배열에 최소 힙에서 k개의 가장 취약한 행의 인덱스 저장
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }

    // 주어진 행에서 병사의 수를 계산하는 함수
    private int countSoldiers(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num == 1) count++;
            else break; // 0을 만나면 중단 (1은 모두 왼쪽에 위치해 있음)
        }
        return count;
    }
}