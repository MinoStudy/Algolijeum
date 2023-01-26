package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� ����� ��Ʃ���

����
�̼����� ������ ��� ����� �����ϴ� ���α׷��� �ֽ��ϴ�.
�ҽ� �̹��� ����
������, �� ���α׷��� �׻� �̼��� �����ؾ��ϸ� ������ ������ ���� �������ϴ�.
�̼��� �ƴ� ��� ����� ������ ������ �� �ֵ��� ����Ͽ���, �� ����� �����߽��ϴ�.

�������, 0 ���� 1��, 2���� �����Ͽ���
1 ���� 2 ���� 3 ���� �����Ͽ����ϴ�.
2 ���� �ƹ��� �������� �ʾҽ��ϴ�.
3 ���� 2���� �����Ͽ����ϴ�.

�̸� ������ķ� ��Ÿ���� ������ �����ϴ�.
0 1 1 0 
0 0 1 1
0 0 0 0
0 0 1 0

���⼭ ���� �α� �ִ� ����� 2 ���̸�, 0 ���� �ƹ��� ǥ�� ���� ���߽��ϴ�.
���� �α��ִ� ����� ��ȣ�� ���� �αⰡ ���� ����� ��ȣ�� ã�Ƽ� ����� �ּ���.

�Է�
ù��° �ٿ� ����� �� N�� �Էµ˴ϴ�. (2 <= N <= 100)
�� ������ ���� N x N �� ��������� �Էµ˴ϴ�.

���
���� �α� �ִ� ��ȣ�� �α� ���� ��ȣ�� ������ּ���
(�αⰡ ���� �����, ���� ����� �� �Ѹ��� �����ϴ� �Է¸� �־����ϴ�.)

�Է� ���� 1 

4
0 1 1 0 
0 0 1 1
0 0 0 0
0 0 1 0

��� ���� 1

2 0
*/
public class Main21 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int MAP[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// MAP[from][to] = 0
		int max_cnt = 0; // ���� ���� ���� ǥ��
		int max_to = -1; // ���� ���� ���� ����� ��ȣ
		int min_cnt = Integer.MAX_VALUE;
		int min_to = -1;
		for (int to = 0; to < N; to++) {
			int cnt = 0;
			for (int from = 0; from < N; from++) {
				cnt += MAP[from][to];
			}
			if (max_cnt < cnt) {
				max_cnt = cnt;
				max_to = to;
			}
			if (min_cnt > cnt) {
				min_cnt = cnt;
				min_to = to;
			}
		}
		System.out.println(max_to + " " + min_to);
	}
}