package BackJoon_int;

import java.util.Scanner;

public class A_10951 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Scanner ��ü�� �Է°��� int���� ���� true�� ��ȯ
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}

	}

}
