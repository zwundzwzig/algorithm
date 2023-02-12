// 문제
// 2차원 평면 위의 점 N개가 주어진다.
// 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

// 출력
// 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		StringTokenizer st;
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[0] == e2[0]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
		});
		
		StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
			sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
		}
        
		System.out.println(sb);
	}
} 