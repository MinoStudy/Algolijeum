package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� ������Ʈ

����
��ö�̴� ����Ʈ�� �̻縦 ���� �մϴ�.
������ ���� ������ ����Ʈ�� ���ٺ��� ������Ʈ���� �ִ� ����Ʈ�� �̻縦 �� �� �ۿ� ���� �Ǿ����ϴ�.

������, �� ���� ������Ʈ�� ���� ���̸� �Լ��Ͽ� �̻簥 ����Ʈ�� �����غ��� �մϴ�.
������Ʈ ������ ������ ����Ʈ�� �Ϲ� �ù��� ����̰� ������Ʈ�� ������� ������ּ���.

black.png

�Է�
����Ʈ ������ �Էµ˴ϴ�.
���� ����Ʈ�� height(����) �� width(����) �� �Էµ˴ϴ�. (1 <= height, width <= 1000)
�׸��� ����Ʈ ������ 2���� �迭 ���·� �Էµ˴ϴ�. ����Ʈ �ֹ� �̸� ������ ���ڷ� ǥ��˴ϴ�.
�ߺ��� ���� ������ �� �ֽ��ϴ�.

���� �ٿ��� ������Ʈ ������ ��Ÿ���� 2���� �迭�� ����, ���� ����� �Էµ˴ϴ�.
�׸��� ������Ʈ ������ 2���� �迭 ���·� �Էµ˴ϴ�. ������Ʈ�� �̸� ������ ���ڷ� ǥ��˴ϴ�.
�ߺ��� ���� ������ �� �ֽ��ϴ�.

����Ʈ �ֹ��� ��ȣ�� ������Ʈ�� ��ȣ�� 0 ~ 100000 ������ ��ȣ�Դϴ�.

���
ù ��° �ٿ��� ������Ʈ�� ��� �ִ��� ����մϴ�.
�� ��° �ٿ��� �Ϲ� �ù��� ��� �ִ��� ����մϴ�.

�Է� ���� 1 
3 4
15 42 65 60
15 30 15 17
5 5 3 15
2 3
15 5 4
17 6 2

��� ���� 1

7
5
*/
public class Main08 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int apartHeight = Integer.parseInt(st.nextToken());
		int apartWidth = Integer.parseInt(st.nextToken());
		int apart[][] = new int[apartHeight][apartWidth];
		for (int i = 0; i < apartHeight; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < apartWidth; j++)
				apart[i][j] = Integer.parseInt(st.nextToken());
		}

		int DAT[] = new int[100001];
		// index : ��� ��ȣ 0 ~ 100000
		// value : �ش� ����� '������Ʈ�ΰ�?'

		st = new StringTokenizer(br.readLine());
		int blackHeight = Integer.parseInt(st.nextToken());
		int blackWidth = Integer.parseInt(st.nextToken());
		for (int i = 0; i < blackHeight; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < blackWidth; j++) {
				int black = Integer.parseInt(st.nextToken());
				DAT[black] = 1;
			}
		}
		int black_cnt = 0; // ������Ʈ�� ��
		for (int i = 0; i < apartHeight; i++)
			for (int j = 0; j < apartWidth; j++)
				if (DAT[apart[i][j]] == 1)
					// i,j��ġ�� ����� ������Ʈ�ΰ�?
					black_cnt++; // ������Ʈ�� �� counting
		System.out.println(black_cnt);
		System.out.println(apartHeight * apartWidth - black_cnt);
	}
}