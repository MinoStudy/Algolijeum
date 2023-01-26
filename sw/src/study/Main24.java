package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�� Bloom

����
2���� �迭 ������ ȭ���� �ֽ��ϴ�. �׸��� ��,��,��,��� ������ ������ �ֽ��ϴ�.
������ ��� �� ������ �ɰ� �Ǹ�, �� ������ ���� �ǰ� ������ ������ �˴ϴ�.

������ ������ ����� ������ �ɾ��� �������� ��,��,��,��� ������ �Ǹ�
�̹� ���� �� �����̳�, ������ �ɾ��� �������� ������ �ɾ����� ���մϴ�.

image.png
�� �׸��� ���� ��� �� ������ ������ �ɾ�����, �� ���������� ���� �ǰ� ������ ��,��,��,�� �������� �ɾ����� �˴ϴ�.

ó������ �� ���� ������ �ɾ����ϴ�.
�� ������ ������ ȭ�ܿ� ���� ���� �Ǵ��� �����ִ� ���α׷��� ����� �ּ���.

(ó�� �ɾ��� �� ���� ������ ���� �ǿ� ���� 1 ���̰�, ���� �ǿ��� ���� ������ �۶߸��ϴ�.)

�Է�
ù ��° �ٿ��� ȭ���� ũ�� height, width �� �Էµ˴ϴ�. ( 1 <= height, width <= 100)
�� ��° �ٿ��� ���� �� ���� ��ǥ�� y,x ���·� �Էµ˴ϴ�. ( 0 <= y <  height )
�� ��° �ٿ��� ���� �� ���� ��ǥ�� y,x ���·� �Էµ˴ϴ�. ( 0 <= x < width )

���
�� �� �ϸ��� ȭ�ܿ� ���� ���� ���ԵǴ��� ������ּ���.

�Է� ���� 1 

2 3
0 0 
1 2

��� ���� 1

2

��Ʈ
������ ���ѵ��� �ɾ����� �� ������ ���� �� ���� ����մϴ�.
����, 1 x 1 �迭�� 0,0 ��ġ�� ������ �ɾ����� �� 1�� ���� ������ ���� ���ϴ�.

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

	// 2. Queue����
	static Queue<Node> q = new LinkedList<>();
	static int visited[][];

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Height = Integer.parseInt(st.nextToken());
		Width = Integer.parseInt(st.nextToken());

		visited = new int[Height][Width];
		// ã�Ҵ� ���ΰ�?

		// 3. ������ ����
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		q.add(new Node(row, col));
		visited[row][col] = 1; // �������� ã�Ҵٶ�� ���

		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		q.add(new Node(row, col));
		visited[row][col] = 1; // �������� ã�Ҵٶ�� ���
	}

	static void bfs() {
		// 1. �׷��� ����(���� ����)
		int ans = 0;
		// 7. 4~6�ܰ� �ݺ�
		while (!q.isEmpty()) {
			// 4. Queue�� �� ���� ��(now)�� ����
			Node now = q.poll();

			// ���� �� �� : ���� �������� �������� ��
			ans = visited[now.row][now.col];
			// �ݺ��� ������ �� ���� �� : '���������� ���� ��'�� ����

			// 5. now -> next ã��
			// �� �� �� ��
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				if (n_row < 0 || n_row >= Height || n_col < 0 || n_col >= Width)
					// ���� ����� ��ǥ
					continue;
				if (visited[n_row][n_col] != 0)
					// ����� ���� ������, ��� ����� ������
					continue; // ã�Ҵ� ���̱⿡ ����

				// 6. next�� queue�� �߰�
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
				// visited ã�Ҵٶ�� ��� -> '�� ��'���� ã�Ҵ°�? ���
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
 * 1. �׷��� ����(���� ����) 2. Queue���� 3. ������ ���� - Queue�� ���� 4. Queue�� �� ���� ��(now)�� ����
 * 5. now���� �� �� �ִ� ��(next)�� ���� ã�� 6. next�� queue�� ���� 7. 4~6�� �ܰ� �ݺ�(Queue�� �����
 * ������)
 */