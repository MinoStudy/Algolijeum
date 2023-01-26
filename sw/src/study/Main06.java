package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���Ҿƹ����� ����

����
dd1.png
������ ���� �Ϸ��ħ�� ���� �ް� �Ǿ����ϴ�.
�Ҿƹ����� ������Width x Height�������� �ε��� ���� ������ �˰� �ֽ��ϴ�.

�Ҿƹ��� ���������簢�� ������� ���� �����ϸ�,�ڽ��� ���� �˴ϴ�.
�Ʒ��� 4 x 8 �������϶� ���� �̹��� �Դϴ�.

���� 0�� ���ִ� ���� ������ �� ���� �׸���Ʈ �Դϴ�.
���� 0�� ���ִ°��� �����ϸ� �ȵ˴ϴ�.
dd2.png

�� ���ÿ��� ������ ���� ��ġ�� (5+1+4+2+6+9+8+1) + (6+5+1+3+2+6+3+2) = 64 �Դϴ�.
�Ҿƹ����� ���� ������ �־�����,
������ ���� �� �ִ� �ִ� ���� ��ġ�� ���ΰ���?

�Է�
ù ��° �ٿ��� Heigth x Width (3 <= H, W <= 20) �� �Է� �޽��ϴ�.
���� ��ġ�� 1 ~ 9 �� �򰡵˴ϴ�.
�� ��° �� ���ʹ� ���� ������ �Էµ˴ϴ�.

���
������ ������ �� �ִ� ������ �ִ� ��ġ�� ����� �ּ���.

�Է� ���� 1 

4 8
0 0 3 3 0 0 0 0
5 1 4 2 6 9 8 1
6 5 1 3 2 6 3 2
0 0 0 0 9 9 4 0

��� ���� 1

64
 * */
public class Main06 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �׻� �� �ִ� ����

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Height = Integer.parseInt(st.nextToken());
		int Width = Integer.parseInt(st.nextToken());
		int MAP[][] = new int[Height][Width];
		for (int i = 0; i < Height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Width; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �ڽ�ũ��
		// �ڽ� ��ġ
		// �ش� �ڽ� ���� ������ Ȯ��
		int ans = 0;
		for (int row_size = 1; row_size <= Height; row_size++)
			for (int col_size = 1; col_size <= Width; col_size++)
				// �ڽ� ũ��
				for (int row = 0; row <= Height - row_size; row++)
					for (int col = 0; col <= Width - col_size; col++)
					// �ڽ� ��������ǥ ��ġ
					{
						int sum = 0;
						int flag = 0; // �ڽ� ���ο� 0�� �ִ��� Ȯ��
						for (int i = row; i < row + row_size; i++)
							for (int j = col; j < col + col_size; j++)
							// �ڽ� ������ ��ǥ
							{
								sum += MAP[i][j];
								if (MAP[i][j] == 0)
									flag = 1; // �ڽ� ���ο� 0�� �ִ�.
							}
						if (flag == 0) // ���ο� 0�� �ִٴ� ����� ���� ��
							ans = Math.max(ans, sum); // sum�� �ִ� ����
					}
		System.out.println(ans);
	}
}