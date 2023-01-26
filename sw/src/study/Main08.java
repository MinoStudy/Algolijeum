package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 블랙리스트

설명
민철이는 아파트로 이사를 가려 합니다.
가격이 적게 나가는 아파트를 고르다보니 블랙리스트들이 있는 아파트로 이사를 갈 수 밖에 없게 되었습니다.

하지만, 운 좋게 블랙리스트가 적힌 종이를 입수하여 이사갈 아파트를 조사해보려 합니다.
블랙리스트 정보를 가지고 아파트에 일반 시민은 몇명이고 블랙리스트는 몇명인지 출력해주세요.

black.png

입력
아파트 정보가 입력됩니다.
먼저 아파트의 height(세로) 와 width(가로) 가 입력됩니다. (1 <= height, width <= 1000)
그리고 아파트 정보가 2차원 배열 형태로 입력됩니다. 아파트 주민 이름 정보는 숫자로 표기됩니다.
중복된 값이 존재할 수 있습니다.

다음 줄에는 블랙리스트 정보를 나타내는 2차원 배열의 세로, 가로 사이즈가 입력됩니다.
그리고 블랙리스트 정보가 2차원 배열 형태로 입력됩니다. 블랙리스트의 이름 정보는 숫자로 표기됩니다.
중복된 값이 존재할 수 있습니다.

아파트 주민의 번호와 블랙리스트의 번호는 0 ~ 100000 사이의 번호입니다.

출력
첫 번째 줄에는 블랙리스트가 몇명 있는지 출력합니다.
두 번째 줄에는 일반 시민이 몇명 있는지 출력합니다.

입력 예시 1 
3 4
15 42 65 60
15 30 15 17
5 5 3 15
2 3
15 5 4
17 6 2

출력 예시 1

7
5
*/
public class Main08 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int apartHeight = Integer.parseInt(st.nextToken());
		int apartWidth = Integer.parseInt(st.nextToken());
		int apart[][] = new int[apartHeight][apartWidth];
		for (int i = 0; i < apartHeight; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < apartWidth; j++)
				apart[i][j] = Integer.parseInt(st.nextToken());
		}

		int DAT[] = new int[100001];
		// index : 사람 번호 0 ~ 100000
		// value : 해당 사람이 '블랙리스트인가?'

		st = new StringTokenizer(br.readLine());
		int blackHeight = Integer.parseInt(st.nextToken());
		int blackWidth = Integer.parseInt(st.nextToken());
		for (int i = 0; i < blackHeight; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < blackWidth; j++) {
				int black = Integer.parseInt(st.nextToken());
				DAT[black] = 1;
			}
		}
		int black_cnt = 0; // 블랙리스트의 수
		for (int i = 0; i < apartHeight; i++)
			for (int j = 0; j < apartWidth; j++)
				if (DAT[apart[i][j]] == 1)
					// i,j위치의 사람이 블랙리스트인가?
					black_cnt++; // 블랙리스트의 수 counting
		System.out.println(black_cnt);
		System.out.println(apartHeight * apartWidth - black_cnt);
	}
}