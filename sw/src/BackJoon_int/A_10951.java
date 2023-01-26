package BackJoon_int;

import java.util.Scanner;

public class A_10951 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Scanner °´Ã¼¿¡ ÀÔ·Â°©½Ì int°ªÀÏ ¶§¸¸ true¸¦ ¹ÝÈ¯
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}

	}

}
