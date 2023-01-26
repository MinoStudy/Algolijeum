package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�� ģ�� ������ ���±�

����

2.png

(0, 0)�� ���ִ� ���ġ� ���� �԰�,ģ���� ������ ������ �մϴ�.

��� ȸ������ ��ĥ�� ���� ����� �� ����,�� ��  ��  ��������θ� �̵� �� �� �ֽ��ϴ�.

ġ� �԰�, ģ���� ������ ���µ� �� ȸ �̵��ؾ��ϴ��� ����ϼ���.

(�� ���ÿ����� 9ȸ �̵��ؾ��մϴ�.)


�Է�
ġ�� ��ġ (Y, X) �� ģ�� ��ǥ (N, M) �� �Է� ��������.


���
ģ���� ����������� �ִ� �Ÿ��� ��� ���ּ���.

�� ĭ�� �̵��������� 1�Դϴ�.


�Է� ���� 1 

2 0
0 3
��� ���� 1

9
��Ʈ
�� ����������9ȸ�̵����� ġ� �԰� ģ���� ���� �� �ֽ��ϴ�.

ģ�� ������ ���±� MAP �ϵ��ڵ�

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
	// start -> dest ������ �Ÿ�
	{
		int MAP[][] = { { 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 } };
		int visited[][] = new int[3][5];
		// 1. �׷��� ����

		Queue<Node> q = new LinkedList<>();
		// 2. queue����

		q.add(start);
		visited[start.row][start.col] = 1;
		// 0�̶�� ���� '����� ���� �ʾҴ�'
		// ���� 0���� �����ϸ� �� 0�̶�� ���� '����� X', '�Ÿ��� 0'���� ������ X
		// 3. ������ ����

		// 7. 4~6�ܰ� �ݺ�
		while (!q.isEmpty()) {
			// 4. now������
			Node now = q.poll();

			// 5.now->nextã��
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				if (n_row < 0 || n_row >= 3 || n_col < 0 || n_col >= 5)
					continue; // ���� ����� ����
				if (visited[n_row][n_col] != 0)
					continue; // ����� �����ϸ� ����
				if (MAP[n_row][n_col] == 1)
					continue; // ã�� ��ǥ�� ���� ��� ����

				// 6.next�� queue�� �߰�
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
 * 1. �׷��� ����(���� ����) 2. Queue���� 3. ������ ���� - Queue�� ���� 4. Queue�� �� ���� ��(now)�� ����
 * 5. now���� �� �� �ִ� ��(next)�� ���� ã�� 6. next�� queue�� ���� 7. 4~6�� �ܰ� �ݺ�(Queue�� �����
 * ������)
 */