package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
■ 2차원 맵 BFS JAVA
 * */
public class Main23_1 {

	static class Node {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int MAP[][] = new int[10][10];
		int visited[][] = new int[10][10]; // 해당 좌표를 찾은적이 있는가?
		// 1. 1. 그래프 구성(연결 정보)

		// 2.Queue생성
		Queue<Node> q = new LinkedList<>();

		// 3. 시작점 세팅(여러개인 경우도 있음, 시작점 여러개를 queue에 넣어주시면 됩니다.)
		q.add(new Node(5, 5)); // 5,5에서 시작하겠다.
		visited[5][5] = 1;

		// 7. 4~6번 단계 반복(Queue가 비워질 때까지)
		while (!q.isEmpty()) {
			// 4. Queue의 맨 앞의 점(now)을 꺼냄
			Node now = q.poll();

			// 5. now에서 갈 수 있는 점(next)을 전부 찾기
			// 상 하 좌 우
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				// ------------------ 해당 점을 사용해도 괜찮은가?

				if (n_row < 0 || n_row >= 10 || n_col < 0 || n_col >= 10)
					continue; // 맵을 벗어나는 좌표면 사용이 '불가능한 좌표' 무시

				if (visited[n_row][n_col] != 0)
					continue; // n_row,n_col에 찾았던 기록이 있다.

				// ------------------ 해당 점을 사용해도 괜찮은가?

				// 6. next를 queue에 삽입
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
				// n_row,n_col을 찾았다라고 기록
				// now로 부터 찾았다. -> next는 now보다 1번 더 가서 찾았다.
			}
		}
		// 5,5에서 7,6까지 몇 번만에 갈 수 있는가?
		// visited[7][6]
	}
}
/*
 * 1. 그래프 구성(연결 정보) 2. Queue생성 3. 시작점 세팅 - Queue에 삽입 4. Queue의 맨 앞의 점(now)을 꺼냄
 * 5. now에서 갈 수 있는 점(next)을 전부 찾기 6. next를 queue에 삽입 7. 4~6번 단계 반복(Queue가 비워질
 * 때까지)
 */