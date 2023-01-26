package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
■ Bloom

설명
2차원 배열 형태의 화단이 있습니다. 그리고 상,하,좌,우로 퍼지는 씨앗이 있습니다.
씨앗을 어느 한 지점에 심게 되면, 그 다음날 꽃이 피고 씨앗이 퍼지게 됩니다.

씨앗이 퍼지는 방식은 씨앗이 심어진 지점에서 상,하,좌,우로 퍼지게 되며
이미 꽃이 핀 지점이나, 씨앗이 심어진 지점에는 씨앗이 심어지지 못합니다.

image.png
위 그림과 같이 어느 한 지점에 씨앗이 심어지면, 그 다음날에는 꽃이 피고 씨앗이 상,하,좌,우 방향으로 심어지게 됩니다.

처음에는 두 개의 씨앗이 심어집니다.
총 몇일이 지나야 화단에 꽃이 전부 피는지 구해주는 프로그램을 만들어 주세요.

(처음 심어진 두 개의 씨앗이 꽃을 피울 때가 1 일이고, 꽃을 피우자 마자 씨앗을 퍼뜨립니다.)

입력
첫 번째 줄에는 화단의 크기 height, width 가 입력됩니다. ( 1 <= height, width <= 100)
두 번째 줄에는 씨앗 한 개의 좌표가 y,x 형태로 입력됩니다. ( 0 <= y <  height )
세 번째 줄에는 씨앗 한 개의 좌표가 y,x 형태로 입력됩니다. ( 0 <= x < width )

출력
총 몇 일만에 화단에 꽃이 가득 차게되는지 출력해주세요.

입력 예시 1 

2 3
0 0 
1 2

출력 예시 1

2

힌트
마지막 씨앗들이 심어지고 그 다음날 꽃이 핀 날을 출력합니다.
만약, 1 x 1 배열에 0,0 위치에 씨앗이 심어지면 총 1일 만에 꽃으로 가득 찹니다.

 * */
public class Main24 {

	static class Node {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int Height, Width;

	// 2. Queue생성
	static Queue<Node> q = new LinkedList<>();
	static int visited[][];

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Height = Integer.parseInt(st.nextToken());
		Width = Integer.parseInt(st.nextToken());

		visited = new int[Height][Width];
		// 찾았던 점인가?

		// 3. 시작점 세팅
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		q.add(new Node(row, col));
		visited[row][col] = 1; // 시작점도 찾았다라고 기록

		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		q.add(new Node(row, col));
		visited[row][col] = 1; // 시작점도 찾았다라고 기록
	}

	static void bfs() {
		// 1. 그래프 구성(연결 정보)
		int ans = 0;
		// 7. 4~6단계 반복
		while (!q.isEmpty()) {
			// 4. Queue의 맨 앞의 점(now)을 꺼냄
			Node now = q.poll();

			// 제일 먼 점 : 제일 마지막에 꺼내지는 점
			ans = visited[now.row][now.col];
			// 반복이 끝났을 때 남은 값 : '마지막으로 꺼낸 점'의 정보

			// 5. now -> next 찾기
			// 상 하 좌 우
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				if (n_row < 0 || n_row >= Height || n_col < 0 || n_col >= Width)
					// 맵을 벗어나는 좌표
					continue;
				if (visited[n_row][n_col] != 0)
					// 기록이 없지 않으면, 어떠한 기록이 있으면
					continue; // 찾았던 점이기에 무시

				// 6. next를 queue에 추가
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
				// visited 찾았다라고 기록 -> '몇 번'만에 찾았는가? 기록
			}
		}
		/*
		 * int de = 1; int ans = 0; for(int i = 0; i < Height; i++) for(int j = 0; j <
		 * Width; j++) ans = Math.max(ans, visited[i][j]);
		 */
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		input();
		bfs();
	}
}
/*
 * 1. 그래프 구성(연결 정보) 2. Queue생성 3. 시작점 세팅 - Queue에 삽입 4. Queue의 맨 앞의 점(now)을 꺼냄
 * 5. now에서 갈 수 있는 점(next)을 전부 찾기 6. next를 queue에 삽입 7. 4~6번 단계 반복(Queue가 비워질
 * 때까지)
 */