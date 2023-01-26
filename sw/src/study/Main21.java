package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 사랑의 스튜디오

설명
이성끼리 마음에 드는 사람을 지목하는 프로그램이 있습니다.
소스 이미지 보기
하지만, 이 프로그램은 항상 이성을 선택해야하며 동성을 선택할 수는 없었습니다.
이성이 아닌 모든 사람을 여러명 선택할 수 있도록 허용하였고, 그 결과를 취합했습니다.

예를들어, 0 번은 1번, 2번을 선택하였고
1 번은 2 번과 3 번을 선택하였습니다.
2 번은 아무도 선택하지 않았습니다.
3 번은 2번을 선택하였습니다.

이를 인접행렬로 나타내면 다음과 같습니다.
0 1 1 0 
0 0 1 1
0 0 0 0
0 0 1 0

여기서 가장 인기 있는 사람은 2 번이며, 0 번은 아무런 표를 받지 못했습니다.
가장 인기있는 사람의 번호와 가장 인기가 없는 사람의 번호를 찾아서 출력해 주세요.

입력
첫번째 줄에 사람의 수 N이 입력됩니다. (2 <= N <= 100)
그 다음줄 부터 N x N 의 인접행렬이 입력됩니다.

출력
가장 인기 있는 번호와 인기 없는 번호를 출력해주세요
(인기가 많은 사람과, 없는 사람이 단 한명씩만 존재하는 입력만 주어집니다.)

입력 예시 1 

4
0 1 1 0 
0 0 1 1
0 0 0 0
0 0 1 0

출력 예시 1

2 0
*/
public class Main21 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int MAP[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// MAP[from][to] = 0
		int max_cnt = 0; // 가장 많이 받은 표수
		int max_to = -1; // 가장 많이 받은 사람의 번호
		int min_cnt = Integer.MAX_VALUE;
		int min_to = -1;
		for (int to = 0; to < N; to++) {
			int cnt = 0;
			for (int from = 0; from < N; from++) {
				cnt += MAP[from][to];
			}
			if (max_cnt < cnt) {
				max_cnt = cnt;
				max_to = to;
			}
			if (min_cnt > cnt) {
				min_cnt = cnt;
				min_to = to;
			}
		}
		System.out.println(max_to + " " + min_to);
	}
}