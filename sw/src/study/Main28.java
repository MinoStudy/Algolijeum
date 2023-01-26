package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
■ 안나와엘사M

설명

빙하왕국의 엘사와 안나가 빙하 평원에서 길을 잃었습니다.

리본 머리띠를 하고 있는 안나는 엘사를 찾기 위해,

왕관 쓰고 있는 엘사는 안나를 찾기 위해,

서로 1초 마다 한 칸씩동시에 이동하며서로를 찾습니다.

anna.png

[엘사와 안나의 움직임]

엘사와 안나는 1 초에 한 칸씩 상, 하, 좌, 우로 움직일 수 있습니다.

그리고 제 자리에 멈추어 휴식을 취하는 것도 가능합니다.

단, 빙하는 지나가지 못합니다.

지도를 입력 받고, 빙하를 피해 엘사와 안나가 가장 빠르게 만날 수 있는 이동시간을 계산해 주세요.

[유의사항]

안나와 엘사가 동시에 움직여 엇갈릴 수도 있습니다.
반드시 만날 수 있는 길이 있는 입력 값이 주어집니다.

입력
첫 줄에 맵의 크기를 나타내는 수 N 을 입력 받아주세요. (1 <= N <= 5)

다음 줄부터 N x N 맵 정보를 입력 받습니다.

빈칸은 '_' (언더바) 이며, 빙하는 '#' 으로 표기됩니다.



그 다음줄에는엘사의 위치 (y, x) 와 안나의 위치 (y, x) 가 입력 됩니다.


출력
두 사람이 같은 좌표에서 만나게 되는, 최소 시간을 출력해 주세요.


입력 예시 1 

5
___#_
___#_
##___
__#__
_____
0 0 4 0
출력 예시 1

5
*/
public class Main28 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static class Node {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int M[][] = new int[n][n];
		int check[][] = new int[n][n];
		// BFS탐색시 탐색을 한 좌표인지 아닌지 기록하는 역할
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				if (temp.charAt(j) == '#')
					M[i][j] = 1;
			}
		}
		int s_r, s_c, d_r, d_c;
		StringTokenizer st = new StringTokenizer(br.readLine());
		s_r = Integer.parseInt(st.nextToken());
		s_c = Integer.parseInt(st.nextToken());
		d_r = Integer.parseInt(st.nextToken());
		d_c = Integer.parseInt(st.nextToken());

		// 2. Queue
		Queue<Node> q = new LinkedList<>();

		// 3. 시작점 세팅
		q.add(new Node(s_r, s_c));
		check[s_r][s_c] = 1; // 시작을 거리가 1이라고 생각
		// 7. 4~6번 반복
		while (!q.isEmpty()) {
			// 4. now
			Node now = q.poll();

			// 5. next
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int next_row = now.row + dr[i];
				int next_col = now.col + dc[i];
				if (next_row < 0 || next_col < 0 || next_row >= n || next_col >= n)
					continue; // 맵을 벗어나면 무시
				if (check[next_row][next_col] >= 1)
					continue; // 찾았던 점이면 무시
				if (M[next_row][next_col] == 1)
					continue; // 빙하가 있는 좌표면 무시
				// 6. next를 queue에 추가
				q.add(new Node(next_row, next_col));
				check[next_row][next_col] = check[now.row][now.col] + 1;
			}
		}

		System.out.println(check[d_r][d_c] / 2);
		// s -> d까지의 최단 경로를 양쪽의 캐릭터가 1초에 2씩 거리를 줄여나가니
		// 최단경로(거리) / 2이 시간된다.
	}
}