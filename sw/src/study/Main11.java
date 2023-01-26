package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 예식장 서빙

설명
민희는 VIP 손님들을 대접하는 예식장의 서빙 아르바이트를 합니다.
이 예식장에는 원형탁자에 앉은 N명의 손님들에게, N개의 맛있는 요리를 제공합니다.

N개의 요리 이름은 숫자로 되어있으며,
같은 숫자는 같은 음식을 뜻합니다.

t1.png

아래 예시는 7명이 원형 탁자에 앉아있고,
고객이 서빙 받은 음식들의 이름이 적혀있습니다.
(12시 방향부터 순서대로 65 - 65 - 81 - 86 - 65 - 71 - 69)

image.png
자리에 앉아있는 사람들은 쉐프의 음식을 종류별로 음식을 먹어보고 싶어합니다.
앉아있는 사람은 거리 R 만큼 떨어진 곳에 있는 음식을 섭취할 수 있습니다.
예를들어 R = 2 일때, 86 음식이 있는 곳에 앉아있는 사람은 71 65 86 81 65 음식을 맛볼 수 있습니다.
이 경우, 중복된 음식이 없기에 서빙에 성공한 것입니다.

image.png

위와 같은 예시에서는
R = 2 일때, 66 자리에서 먹을 수 있는 음식은 65 65 66 81 65 입니다.
중복된 음식은 2개 까지는 손님들의 불만이 없지만, 3개가 있다면 불만을 토로합니다.
따라서 서빙에 성공하지 못한 케이스입니다.

테이블에 앉은 모든 사람들 기준으로
앉아서 먹을 수 있는 음식들이 2개 까지만 중복되게끔 서빙 되있더다면 YES 를,
그렇지 않다면 NO 를 출력 해 주세요.

입력
첫 번째 줄에 테스트 케이스의 수 T 가 주어집니다. (1 <= T <= 100)
각 테스트 케이스의 첫 번째 줄에는 두 정수 N, R 이 주어집니다. (1 <= N <= 1,000,000)
(1 <= R <= 50,000)
각 테스트 케이스의 두 번째 줄에는 N 개의 음식이 숫자로 띄어쓰기로 구분되어 주어집니다. (숫자의 범위는 0 ~ 200 입니다)

출력
각 테스트 케이스마다 만족스러운 세팅이면 YES,
불만족스러운 세팅이면 NO 를 출력합니다.

입력 예시 1 

2
7 2
65 66 81 86 65 71 82
8 2
65 65 81 66 65 65 69 69

출력 예시 1

#1 YES
#2 NO
 * */
public class Main11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int arr[] = new int[2 * N]; // 뒤에 복사본을 이어 붙일것이므로 N + N
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[N + i] = arr[i]; // 복사본 생성
		} // 입력 및 rotation 형태 처리 준비

		int DAT[] = new int[201];
		// index : 음식 번호 0 ~ 200
		// value : 해당 음식이 몇 개 있는가?

		// 확인해야할 구간의 크기 : 2 * R + 1, 공통 구간의 크기 : 2 * R
		for (int i = 0; i < 2 * R; i++) {
			DAT[arr[i]]++; // i번째 음식이 1개 추가됐다.
			// 구간내 음식들이 '몇 개씩 있는가'

			if (DAT[arr[i]] >= 3) {
				// 잘못됐다.
				System.out.println("#" + tc + " NO");
				return;
			}
		} // 공통 구간 세팅 : 2 * R개의 data

		// 실제 구간을 만들어가며 이동
		int s = 0; // 구간의 시작점
		int e = 2 * R; // 구간의 끝점
		for (int i = 0; i < N; i++) // 총 N개의 모든 기준점에 대하여
		{
			// 2* R + 1개의 '완벽한 구간'을 만듦 <- 맨 뒤의 data를 추가
			DAT[arr[e]]++;

			if (DAT[arr[e]] >= 3) {
				// 잘못됐다.
				System.out.println("#" + tc + " NO");
				return;
			}

			// 다음 구간 준비
			DAT[arr[s]]--;
			e++;// 구간을 옮김
			s++;// 구간을 옮김
		}
		// 모든 구간을 확인했지만 잘못됐다고 출력이 X 무사히 for문을 탈출
		System.out.println("#" + tc + " YES");

	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}