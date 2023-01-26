package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 문자열 찾기 sampe code
 * */
public class Main05_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문

	public static void main(String[] args) throws IOException {
		String origin = "13241524";
		String temp = "415";
		for (int i = 0; i <= origin.length() - temp.length(); i++)
		// 원본에서 temp가 있는지 확인할 위치 (origin내 기준)
		{
			int cnt = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (origin.charAt(i + j) == temp.charAt(j)) {
					cnt++;
				}
			}
			if (cnt == temp.length())
				System.out.println(i);
		}

	}
}