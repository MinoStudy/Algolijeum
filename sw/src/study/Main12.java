package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
■ 미확인 신호

설명
image.png

"M1nCod1n9"
357.482 KHz의 신호로 미지의 신호가 잡혔습니다.

알파벳 대소문자와 0 ~ 9 까지의 숫자로 이뤄져 있는 신호입니다.
이 미지의 신호는 크기가 M 인 구간에서는 중복된 문자가 존재하지 않는다는 것을 알아냈습니다.

슈베르트 알렉산더 박사는 이 외계 신호를 분석하였고, 다시 송신을 할 메시지를 만들어 냈습니다.
박사가 만든 메시지에서 크기가 M인 구간에 중복된 문자가 있는지 체크해주는 프로그램을 만들어 주세요.

입력
첫줄에 테스트케이스의 수(T)가 입력됩니다.
그 다음줄부터 각 테스트 케이스 별로,
구간 M이 입력되며
다음줄에는 박사가 만든 메시지가 입력됩니다.
메시지의 최대길이는 10만이며 , M은 메시지의 길이보다 더 작은값이 입력됩니다.

출력
각 테스트케이스 별로 유효성 검사 결과를 PASS , FAIL 로 출력해주세요.

입력 예시 1 

3
4
1bacDBTAab12D
3
734734734
2
10101010111

출력 예시 1

#1 PASS
#2 PASS
#3 FAIL
*/
public class Main12 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		int M = Integer.parseInt(br.readLine());
		String message = br.readLine();

		int DAT[] = new int[256];
		// index : 문자
		// value : 문자가 있는가?

		// 1. 공통 구간 세팅(M-1 개)
		for (int i = 0; i < M - 1; i++) {
			if (DAT[message.charAt(i)] == 1)
			// 기록을 하기도 전에 해당 문자에 대한 기록이 있다. <- 중복된 문자
			{
				System.out.println("#" + tc + " FAIL");
				return;
			}
			DAT[message.charAt(i)] = 1;
		}

		int s = 0; // 현재 구간의 시작점
		int e = M - 1; // 현재 구간의 끝점
		for (int i = 0; i <= message.length() - M; i++) {
			if (DAT[message.charAt(e)] == 1)
			// 앞에서 이미 같은 문자가 나왔었다. <- 기록이 이미 존재한다.
			{
				System.out.println("#" + tc + " FAIL");
				return;
			} // 구간의 '마지막'data에 대하여

			DAT[message.charAt(e)] = 1;
			// 맨 끝점을 추가하여 'W개의 구간'을 완성

			DAT[message.charAt(s)] = 0;
			// 맨 앞의 기록을 삭제하여 'W-1개의 공통구간' 생성
			s++; // 구간 이동
			e++; // 구간 이동
		}

		// 모든 구간이 정상적인 상황

		System.out.println("#" + tc + " PASS");

	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}