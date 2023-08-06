// 2563
// 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.

// 예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();	//색종이의 수
		int area = 0;
		boolean[][] check = new boolean[101][101];

		for(int tc=0; tc<num; tc++) {
			int x = scanner.nextInt();	// 색종이의 좌측 아래 꼭짓점 좌표
			int y = scanner.nextInt();	// 색종이의 좌측 위 꼭짓점 좌표

			for(int i=x; i<x+10; i++) {	// 색종이의 가로, 세로 크기는 10
				for(int j=y; j<y+10; j++) {
					if(check[i][j] == true) { // 이전에 의해 이미 칠한경우 => 중복되므로 제거
						continue;
					}
					check[i][j] = true;	// 검은색 색종이로 색칠하기
					area ++;
				}
			}

		}

		System.out.println(area);
		scanner.close();
	}

}