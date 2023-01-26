package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
■ 입력과 출력

설명
Build Test 및 입출력 연습을 위한 문제입니다.

C++은 빠른 입출력을 위해 scanf / printf 를 사용하고,
Java는 빠른 입출력을 위해 BufferedReader / BufferedWriter 사용을 권합니다.

Type을 입력받고,
Type에 맞는 입력과 출력을 해주세요.

입력
첫 줄에는 Type을 입력받습니다.
각 Type에 맞는 입출력 처리를 해주시면 됩니다.

[Type 1]
수 n을 입력 받습니다. (1 <= n <= 10)
다음 줄에는 n개의 수를 입력받습니다. (-9 <= 수 <= 9)
출력결과는전체 합과 전체 곱입니다.

[Type 2]
숫자 n을 입력 받고, n개의 모두 다른 길이의 문자열을 입력받습니다.(1 <= n <= 100)
가장긴 문자열과, 가장 길이가짧은 문자열을 출력합니다.

[Type 3]
Y, X 두 수를 입력 받습니다.(1 <= Y, X <= 100)
다음 줄 부터는 (Y * X) 개의 2차원 배열을 입력 받습니다.(0 <= 배열 값 <= 100)
2차원 배열에서가장 작은 값을 찾아 출력합니다.
다음 줄에는가장 작은 수의 개수를 출력합니다.

출력
Type 1, 2, 3 에 대한 결과를 출력하세요.

입력 예시 1 

1
5
1 2 3 4 5

출력 예시 1

15 120
입력 예시 2 

2
4
FIGHT
show
OPERATION
DISONW

출력 예시 2

OPERATION
show
입력 예시 3 

3
3 4
0 4 2 5
7 5 0 3
2 4 2 0

출력 예시 3

0
3개

힌트

1. Java 입출력 설명 링크
2. 숫자의 곱은 21억이 넘을 수도 있습니다.
*/
public class Main02 {

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
