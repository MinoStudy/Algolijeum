package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
�� 2���� �� BFS JAVA
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
		int visited[][] = new int[10][10]; // �ش� ��ǥ�� ã������ �ִ°�?
		// 1. 1. �׷��� ����(���� ����)

		// 2.Queue����
		Queue<Node> q = new LinkedList<>();

		// 3. ������ ����(�������� ��쵵 ����, ������ �������� queue�� �־��ֽø� �˴ϴ�.)
		q.add(new Node(5, 5)); // 5,5���� �����ϰڴ�.
		visited[5][5] = 1;

		// 7. 4~6�� �ܰ� �ݺ�(Queue�� ����� ������)
		while (!q.isEmpty()) {
			// 4. Queue�� �� ���� ��(now)�� ����
			Node now = q.poll();

			// 5. now���� �� �� �ִ� ��(next)�� ���� ã��
			// �� �� �� ��
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			for (int i = 0; i < 4; i++) {
				int n_row = now.row + dr[i];
				int n_col = now.col + dc[i];

				// ------------------ �ش� ���� ����ص� ��������?

				if (n_row < 0 || n_row >= 10 || n_col < 0 || n_col >= 10)
					continue; // ���� ����� ��ǥ�� ����� '�Ұ����� ��ǥ' ����

				if (visited[n_row][n_col] != 0)
					continue; // n_row,n_col�� ã�Ҵ� ����� �ִ�.

				// ------------------ �ش� ���� ����ص� ��������?

				// 6. next�� queue�� ����
				q.add(new Node(n_row, n_col));
				visited[n_row][n_col] = visited[now.row][now.col] + 1;
				// n_row,n_col�� ã�Ҵٶ�� ���
				// now�� ���� ã�Ҵ�. -> next�� now���� 1�� �� ���� ã�Ҵ�.
			}
		}
		// 5,5���� 7,6���� �� ������ �� �� �ִ°�?
		// visited[7][6]
	}
}
/*
 * 1. �׷��� ����(���� ����) 2. Queue���� 3. ������ ���� - Queue�� ���� 4. Queue�� �� ���� ��(now)�� ����
 * 5. now���� �� �� �ִ� ��(next)�� ���� ã�� 6. next�� queue�� ���� 7. 4~6�� �ܰ� �ݺ�(Queue�� �����
 * ������)
 */