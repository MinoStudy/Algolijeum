package BackJoon_int;

import java.math.BigDecimal;
import java.util.Scanner;

public class A_10827 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BigDecimal a = scan.nextBigDecimal();
		int b = scan.nextInt();
		
		BigDecimal c = a.pow(b);
		System.out.println(c.toPlainString());
	}

}
