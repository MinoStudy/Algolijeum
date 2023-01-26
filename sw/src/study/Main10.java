package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 슬라이딩 윈도우

설명
멋진 풍경 사진을 찍으려 합니다.
일직선 상에 있는 피사체들을 점수로 표현하였습니다.
image.png

사진기로 모든 피사체들을 찍고 싶지만, 사진기 안에 담을 수 있는 폭은 한정되어 있습니다.

예를들어 위 그림은 피사체의 각 점수가 2 5 2 6 5 -3 9 4 2 -7 이며, 사진기가 찍을 수 있는 폭이 5칸인 경우 입니다.
만약 0 번 인덱스에서 4 번인덱스까지 촬영 시, 얻을 수 있는 예술 점수는 2 + 5 + 2 + 6 + 5 = 20 입니다.
만약 1 번 인덱스에서 5 번 인덱스까지 촬영 시, 얻을 수 있는 예술 점수는 5 + 2 + 6 + 5 + -3 = 15 입니다.

이렇게 폭이 5인 경우 위 풍경에서 얻을 수 있는 가장 높은 점수는 6 + 5 + -3 + 9 + 4 = 21 입니다.

피사체들의 정보를 입력받고, 가장 예술 점수가 높은 사진을 찍기 위해서 몇번 인덱스부터 몇번 인덱스까지 촬영을 해야되는지를 출력해주세요

입력
첫 번째 줄에는 테스트케이스의 수(T)가 입력됩니다. (1 <= T <= 50)
두 번째 줄부터 각 테스트케이스별로,
첫번째 줄에는피사체의 갯수(N), 사진기의 폭(W) 을 입력받고
그 다음 줄에는 피사체의 수만큼 점수를 입력받습니다.
(1 <= W < N <= 100,000)

출력
각 테스트케이스 별로
최대예술 점수가 나오는 곳의 시작 인덱스, 끝 인덱스, 최대 예술점수를 출력합니다.
인덱스 번호는 0번 인덱스부터 시작합니다.
만약, 최대 예술 점수가 나오는 구간이 여러 곳인 경우 그중 가장 왼쪽에 있는 곳으로 출력합니다.

입력 예시 1 

2
10 5
2 5 2 6 5 -3 9 4 2 -7 
5 2
-1 -2 -3 -4 -5

출력 예시 1

#1 3 7 21
#2 0 1 -3
 
*/

public class Main10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int now_sum = 0; // 구간의 합
		for (int i = 0; i < W - 1; i++) // W-1개의 '공통 구간'을 준비
			now_sum += arr[i];

		int ans_sum = Integer.MIN_VALUE; // 최대 값을 구간의 합
		int ans_s = 0; // 최대 값을 갖는 구간의 시작점
		int ans_e = 0; // 최대 값을 갖는 구간의 끝점

		int s = 0; // 현재 구간의 시작점
		int e = W - 1; // 현재 구간의 끝점
		for (int i = 0; i <= N - W; i++) {
			now_sum += arr[e]; // W개의 '현재 구간'에 대한 정보

			// 현재 구간에 대한 정보로 '하고 싶은 처리'
			if (ans_sum < now_sum) {
				ans_sum = now_sum;
				ans_s = s;
				ans_e = e;
			}

			now_sum -= arr[s]; // 현재구간의 '맨 앞'data를 삭제(다음 구간 준비)
			s++; // 다음구간으로 범위 이동
			e++;
		}
		System.out.println("#" + tc + " " + ans_s + " " + ans_e + " " + ans_sum);
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}