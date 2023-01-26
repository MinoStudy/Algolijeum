package BackJoon_int;

import java.util.Scanner;

public class A_10950 {

	public static void main(String[] args) {
		
		int t;
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			sc = new Scanner(System.in);
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}
