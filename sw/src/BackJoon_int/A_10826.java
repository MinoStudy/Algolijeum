package BackJoon_int;

import java.math.BigInteger;
import java.util.Scanner;

public class A_10826 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		BigInteger[] d = new BigInteger[Math.max(n+1, 2)];
		d[0] = BigInteger.ZERO;
		d[1] = BigInteger.ONE;
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1].add(d[i-2]);
					
		}
		System.out.println(d[n]);

	}

}
