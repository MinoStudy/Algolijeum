package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
■ 좀비 바이러스

설명
좀비 바이러스가 창궐하여, 시민들에게 백신을 투여하고자 합니다.
백신을 투여하면 3초 후 완치됩니다.
그리고 백신은 1초 마다상하좌우에 이웃한 좀비에게 퍼집니다.

예를들어 아래 이미지에서

X, Y 기준으로 (3, 5) 좌표에 있는 좀비에게 백신을 투여하면,

총 9초 후 모든 좀비들이 치유가 됩니다.

zombie.png



오른쪽 이미지에 적힌 숫자들은, 치유가 완료될 때 까지 걸리는 시간입니다.

만약 백신을 지닌 좀비와 이웃하고있지 않은 좀비는 치유가 되지 않습니다.



한 명의 좀비에게 백신을 투여할 때,

백신으로 인해 치유가 끝날 때 까지 걸리는 시간과,

치료받지 못한 좀비의 수를 출력해 주세요.


입력
먼저 맵의 크기가 입력됩니다. ( Width x Height, 최대 100칸)

둘째 줄 부터 맵이 입력됩니다.

맵 정보에 적혀있는 숫자 1은 좀비가 있는 곳입니다.

마지막 줄에는 백신을 투여하는 위치가 입력됩니다. (X, Y)


출력
첫 번째 줄에는 백신 치료가 완료될 때까지 걸리는 시간을 출력하세요.

다음 줄에는 백신이 닿지 않는 좀비의 수를 출력해 주세요.


입력 예시 1 

7 8 
0010000 
0011000 
0001100 
1011111 
1111010 
0011110 
0011100 
0001000
3 5

출력 예시 1

9
0
 * */
public class Main25 {

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
		Width = Integer.parseInt(st.nextToken());
		Height = Integer.parseInt(st.nextToken());
		MAP = new char[Height][Width];
		int totalCnt = 0; // 총 좀비 수
		for (int i = 0; i < Height; i++) // 0 ~ Height-1
		{
			String temp = br.readLine(); // "0010000"
			for (int j = 0; j < Width; j++) {
				MAP[i][j] = temp.charAt(j);
				if (MAP[i][j] == '1')
					totalCnt++;
			}
		}
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		bfs(new Node(row - 1, col - 1), totalCnt);
	}

	static void bfs(Node start, int totalCnt) {
		// 1. 그래프 구성
		int visited[][] = new int[Height][Width];
		// 2. Queue 생성
		Queue<Node> q = new LinkedList<>();

		// 3. 시작점 세팅
		q.add(start);
		visited[start.row][start.col] = 3;
		int ans_time = 0;
		// 7. 4~6단계 반복
		while (!q.isEmpty()) {
			// 4. now꺼내기
			Node now = q.poll();
			ans_time = visited[now.row][now.col];
			totalCnt--; // now라는 좀비가 치료 된 것을 확인될때 마다 좀비 수 감소

			// 5. now->next찾기
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				// -------
				if (n_row < 0 || n_row >= Height || n_col < 0 || n_col >= Width)
					continue; // 맵을 벗어가는 좌표 무시
				if (visited[n_row][n_col] != 0)
					continue; // 기록이 있으면 무시(찾았던 점)
				if (MAP[n_row][n_col] == '0')
					continue; // 좀비가 아닌 위치면 무시
				// -------

				// 6. next를 queue에 추가
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
			}
		}
		int de = 1;
		System.out.println(ans_time);
		System.out.println(totalCnt);

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