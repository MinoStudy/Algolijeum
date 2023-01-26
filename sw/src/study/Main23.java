package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� ��ź ����

����

20180721224817_78285.jpg

4 x 5 �������� ���ڿ�  �迭�� �غ��մϴ�.
���� '_' ����� ���ڷ� �� ä��ϴ�.

��ź�� ������ ��ǥ �� ���� �Է¹޾��ּ���.

�������,
���� ��ź��(1,1)�� ���ϵǸ� 8�������� ��ź�� �����ϴ�.
20180721225427_50765.jpg

�� ��Ȳ���� (3,3)�� ��ź�� ���ϵǸ� 8�������� ��ź�� �����ϴ�.
20180721225436_32392.jpg

��ź 2���� ���� �Ǿ����� �� ������ ��� ���ּ���.

�Է�
ù �ٿ��� ù��° ��ź�� ���� �� ��ǥ (Y, X) �� �Է¹޽��ϴ�.
�� ��° �ٿ��� �� ��° ��ź�� ���� �� ��ǥ (Y, X)�� �Է� �޽��ϴ�.

���
��ź�� ���ϵ� �� ����� ����մϴ�.

�Է� ���� 1 

1 1
3 3

��� ���� 1

# # # _ _
# _ # _ _
# # # # #
_ _ # _ #
*/
public class Main23 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int Height = 4; // ���� (0~3)
	static int Width = 5; // �ʺ� (0~4)

	static char MAP[][];

	static void sol() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		// ������ 8������ ��ǥ
		int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 }; // row�� ������
		int dc[] = { 0, 0, -1, 1, 1, -1, 1, -1 }; // col�� ������
		// �� �� �� ��,���,�»�,����,����
		for (int i = 0; i < 8; i++) {
			int n_row = row + dr[i];
			int n_col = col + dc[i];

			if (n_row < 0 || n_col < 0 || n_row >= Height || n_col >= Width)
				// ������ ���� �κ�, ���� ����� ��ǥ
				continue;

			// -> �ϰ� ���� ��
			MAP[n_row][n_col] = '#';
		}
	}

	public static void main(String[] args) throws IOException {
		MAP = new char[Height][Width];
		// ���� ��ǥ
		for (int i = 0; i < Height; i++)
			for (int j = 0; j < Width; j++)
				MAP[i][j] = '_';
		sol();
		sol();

		for (int i = 0; i < Height; i++) {
			for (int j = 0; j < Width; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}

	}
}