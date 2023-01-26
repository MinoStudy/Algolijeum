package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
■ 친구 만나러 가는길

설명

2.png

(0, 0)에 서있는 쥐는치즈를 먼저 먹고,친구를 만나러 가려고 합니다.

쥐는 회색으로 색칠된 벽을 통과할 수 없고,↑ ↓  ←  →방향으로만 이동 할 수 있습니다.

치즈를 먹고, 친구를 만나러 가는데 몇 회 이동해야하는지 출력하세요.

(위 예시에서는 9회 이동해야합니다.)


입력
치즈 위치 (Y, X) 와 친구 좌표 (N, M) 을 입력 받으세요.


출력
친구를 만나기까지의 최단 거리를 출력 해주세요.

한 칸을 이동했을때가 1입니다.


입력 예시 1 

2 0
0 3
출력 예시 1

9
힌트
위 예제에서는9회이동으로 치즈를 먹고 친구를 만날 수 있습니다.

친구 만나러 가는길 MAP 하드코딩

int MAP[][] = {
            {0,0,0,0,1},
            {1,0,1,0,0},
            {0,0,0,0,1}
    };
*/
public class Main26 {

	static class Node {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static char MAP[][];
	static int Width = 7;
	static int Height = 8;

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ch_row = Integer.parseInt(st.nextToken());
		int ch_col = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int fr_row = Integer.parseInt(st.nextToken());
		int fr_col = Integer.parseInt(st.nextToken());

		System.out.println(bfs(new Node(0, 0), new Node(ch_row, ch_col))
				+ bfs(new Node(ch_row, ch_col), new Node(fr_row, fr_col)));

	}

	static int bfs(Node start, Node dest)
	// start -> dest 사이의 거리
	{
		int MAP[][] = { { 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 } };
		int visited[][] = new int[3][5];
		// 1. 그래프 구성

		Queue<Node> q = new LinkedList<>();
		// 2. queue생성

		q.add(start);
		visited[start.row][start.col] = 1;
		// 0이라는 값은 '기록이 되지 않았다'
		// 만약 0으로 시작하면 이 0이라는 값이 '기록이 X', '거리가 0'인지 구별이 X
		// 3. 시작점 세팅

		// 7. 4~6단계 반복
		while (!q.isEmpty()) {
			// 4. now꺼내기
			Node now = q.poll();

			// 5.now->next찾기
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				if (n_row < 0 || n_row >= 3 || n_col < 0 || n_col >= 5)
					continue; // 맵을 벗어나면 무시
				if (visited[n_row][n_col] != 0)
					continue; // 기록이 존재하면 무시
				if (MAP[n_row][n_col] == 1)
					continue; // 찾은 좌표가 벽인 경우 무시

				// 6.next를 queue에 추가
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
			}
		}
		return visited[dest.row][dest.col] - 1;
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}
/*
 * 1. 그래프 구성(연결 정보) 2. Queue생성 3. 시작점 세팅 - Queue에 삽입 4. Queue의 맨 앞의 점(now)을 꺼냄
 * 5. now에서 갈 수 있는 점(next)을 전부 찾기 6. next를 queue에 삽입 7. 4~6번 단계 반복(Queue가 비워질
 * 때까지)
 */