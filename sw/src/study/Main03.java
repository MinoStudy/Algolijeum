package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 어설픈 모내기

설명
모내기 철이 오면
현모네 가족들은, 옹기종기 모여 '싹을 틔운 모'를 논이 심곤 했습니다.
모를 심을 때면 한 사람씩 라인을 정하고, 일렬로 모를 심습니다.

전라도, 모내기, 천수답, 지리산

전문 농사꾼이 아닌 현모네 가족들은,
모를 심어야 할 위치를 실수로 넘어가는 경우가 많습니다.

모를 심은 지역은 1,모를 심지 않은 지역은 0 으로 표기됩니다.
cc1.png

현모네 가족들이 모를 심은 후의 모습을 입력 받습니다.
각 라인별 몇 개의 모를 성공리에 심었는지 Counting하여 출력해 주세요.

입력
input 함수(메서드) 를 만들고,input 함수에서 모든 입력을 처리해 주세요.
첫 줄에는 Height와 Width가 입력됩니다. (1 <= Height, Width <= 1,000)
다음 줄에는 Height x Width 사이즈의 모를 심은 후 모습을 입력 받습니다.

출력
output 함수(메서드)를 만들고, 결과를 출력 해 주세요.
각 라인당 심은 모의 개수를 출력해 주세요.


입력 예시 1 

5 6
100111
111101
011110
110001
011100

출력 예시 1

4
5
4
3
3
 * */

public class Main03 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문
	static int Height, Width;

	static String str[];

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Height = Integer.parseInt(st.nextToken());
		Width = Integer.parseInt(st.nextToken());
		str = new String[Height];
		for (int i = 0; i < Height; i++) {
			str[i] = br.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < Height; i++) {
			int cnt = 0;
			for (int j = 0; j < Width; j++)
				if (str[i].charAt(j) == '1')
					cnt++;
			System.out.println(cnt);
		}
	}
}
