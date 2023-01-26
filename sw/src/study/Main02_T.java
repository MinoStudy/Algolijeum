package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02_T {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문

	static void sol1() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		// int : 21억 조금 넘는 값까지 저장가능
		long mul = 1;
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			mul *= temp;
		}
		System.out.print(sum + " " + mul);
	}

	static void sol2() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int minLen = Integer.MAX_VALUE;
		String minStr = "";
		int maxLen = 0;
		String maxStr = "";
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			if (minLen > temp.length()) {
				minLen = temp.length();
				minStr = temp;
			}
			if (maxLen < temp.length()) {
				maxLen = temp.length();
				maxStr = temp;
			}
		}
		System.out.println(maxStr);
		System.out.println(minStr);
	}

	static void sol3() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		int minValue = Integer.MAX_VALUE;
		int minCnt = 0;
		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colSize; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (minValue > temp) {
					minValue = temp;
					minCnt = 1;
				} else if (minValue == temp)
					minCnt++;
			}
		}
		System.out.println(minValue);
		System.out.println(minCnt + "개");
	}

	public static void main(String[] args) throws IOException {
		int type = Integer.parseInt(br.readLine());
		if (type == 1)
			sol1();
		else if (type == 2)
			sol2();
		else if (type == 3)
			sol3();
	}
}
