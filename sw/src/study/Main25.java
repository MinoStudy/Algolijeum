package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�� ���� ���̷���

����
���� ���̷����� â���Ͽ�, �ùε鿡�� ����� �����ϰ��� �մϴ�.
����� �����ϸ� 3�� �� ��ġ�˴ϴ�.
�׸��� ����� 1�� ���ٻ����¿쿡 �̿��� ���񿡰� �����ϴ�.

������� �Ʒ� �̹�������

X, Y �������� (3, 5) ��ǥ�� �ִ� ���񿡰� ����� �����ϸ�,

�� 9�� �� ��� ������� ġ���� �˴ϴ�.

zombie.png



������ �̹����� ���� ���ڵ���, ġ���� �Ϸ�� �� ���� �ɸ��� �ð��Դϴ�.

���� ����� ���� ����� �̿��ϰ����� ���� ����� ġ���� ���� �ʽ��ϴ�.



�� ���� ���񿡰� ����� ������ ��,

������� ���� ġ���� ���� �� ���� �ɸ��� �ð���,

ġ����� ���� ������ ���� ����� �ּ���.


�Է�
���� ���� ũ�Ⱑ �Էµ˴ϴ�. ( Width x Height, �ִ� 100ĭ)

��° �� ���� ���� �Էµ˴ϴ�.

�� ������ �����ִ� ���� 1�� ���� �ִ� ���Դϴ�.

������ �ٿ��� ����� �����ϴ� ��ġ�� �Էµ˴ϴ�. (X, Y)


���
ù ��° �ٿ��� ��� ġ�ᰡ �Ϸ�� ������ �ɸ��� �ð��� ����ϼ���.

���� �ٿ��� ����� ���� �ʴ� ������ ���� ����� �ּ���.


�Է� ���� 1 

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

��� ���� 1

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
		int totalCnt = 0; // �� ���� ��
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
		// 1. �׷��� ����
		int visited[][] = new int[Height][Width];
		// 2. Queue ����
		Queue<Node> q = new LinkedList<>();

		// 3. ������ ����
		q.add(start);
		visited[start.row][start.col] = 3;
		int ans_time = 0;
		// 7. 4~6�ܰ� �ݺ�
		while (!q.isEmpty()) {
			// 4. now������
			Node now = q.poll();
			ans_time = visited[now.row][now.col];
			totalCnt--; // now��� ���� ġ�� �� ���� Ȯ�εɶ� ���� ���� �� ����

			// 5. now->nextã��
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				// -------
				if (n_row < 0 || n_row >= Height || n_col < 0 || n_col >= Width)
					continue; // ���� ����� ��ǥ ����
				if (visited[n_row][n_col] != 0)
					continue; // ����� ������ ����(ã�Ҵ� ��)
				if (MAP[n_row][n_col] == '0')
					continue; // ���� �ƴ� ��ġ�� ����
				// -------

				// 6. next�� queue�� �߰�
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
 * 1. �׷��� ����(���� ����) 2. Queue���� 3. ������ ���� - Queue�� ���� 4. Queue�� �� ���� ��(now)�� ����
 * 5. now���� �� �� �ִ� ��(next)�� ���� ã�� 6. next�� queue�� ���� 7. 4~6�� �ܰ� �ݺ�(Queue�� �����
 * ������)
 */