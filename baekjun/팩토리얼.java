// 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        System.out.println(factorial(N));
        
		in.close();
    }
    
    static int factorial(int num) {
        
        if (num == 0) return 1;
        
        return num * factorial(num - 1);
        
    }
    
}