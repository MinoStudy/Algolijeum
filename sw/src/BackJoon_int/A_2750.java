package BackJoon_int;

import java.util.Arrays;
import java.util.Scanner;

public class A_2750 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/* Collections »ç¿ë */
		/*
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int temp = sc.nextInt();
			a.add(temp);
		}
		Collections.sort(a);
		for(int x : a) {
			System.out.println(x);
		}
		*/
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for(int x : a) {
			System.out.println(x);
		}
	}
}
