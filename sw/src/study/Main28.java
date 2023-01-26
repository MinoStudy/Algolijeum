package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�� �ȳ��Ϳ���M

����

���Ͽձ��� ����� �ȳ��� ���� ������� ���� �Ҿ����ϴ�.

���� �Ӹ��츦 �ϰ� �ִ� �ȳ��� ���縦 ã�� ����,

�հ� ���� �ִ� ����� �ȳ��� ã�� ����,

���� 1�� ���� �� ĭ�����ÿ� �̵��ϸ缭�θ� ã���ϴ�.

anna.png

[����� �ȳ��� ������]

����� �ȳ��� 1 �ʿ� �� ĭ�� ��, ��, ��, ��� ������ �� �ֽ��ϴ�.

�׸��� �� �ڸ��� ���߾� �޽��� ���ϴ� �͵� �����մϴ�.

��, ���ϴ� �������� ���մϴ�.

������ �Է� �ް�, ���ϸ� ���� ����� �ȳ��� ���� ������ ���� �� �ִ� �̵��ð��� ����� �ּ���.

[���ǻ���]

�ȳ��� ���簡 ���ÿ� ������ ������ ���� �ֽ��ϴ�.
�ݵ�� ���� �� �ִ� ���� �ִ� �Է� ���� �־����ϴ�.

�Է�
ù �ٿ� ���� ũ�⸦ ��Ÿ���� �� N �� �Է� �޾��ּ���. (1 <= N <= 5)

���� �ٺ��� N x N �� ������ �Է� �޽��ϴ�.

��ĭ�� '_' (�����) �̸�, ���ϴ� '#' ���� ǥ��˴ϴ�.



�� �����ٿ��¿����� ��ġ (y, x) �� �ȳ��� ��ġ (y, x) �� �Է� �˴ϴ�.


���
�� ����� ���� ��ǥ���� ������ �Ǵ�, �ּ� �ð��� ����� �ּ���.


�Է� ���� 1 

5
___#_
___#_
##___
__#__
_____
0 0 4 0
��� ���� 1

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
		// BFSŽ���� Ž���� �� ��ǥ���� �ƴ��� ����ϴ� ����
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

		// 3. ������ ����
		q.add(new Node(s_r, s_c));
		check[s_r][s_c] = 1; // ������ �Ÿ��� 1�̶�� ����
		// 7. 4~6�� �ݺ�
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
					continue; // ���� ����� ����
				if (check[next_row][next_col] >= 1)
					continue; // ã�Ҵ� ���̸� ����
				if (M[next_row][next_col] == 1)
					continue; // ���ϰ� �ִ� ��ǥ�� ����
				// 6. next�� queue�� �߰�
				q.add(new Node(next_row, next_col));
				check[next_row][next_col] = check[now.row][now.col] + 1;
			}
		}

		System.out.println(check[d_r][d_c] / 2);
		// s -> d������ �ִ� ��θ� ������ ĳ���Ͱ� 1�ʿ� 2�� �Ÿ��� �ٿ�������
		// �ִܰ��(�Ÿ�) / 2�� �ð��ȴ�.
	}
}