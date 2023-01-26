package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� �����̵� ������

����
���� ǳ�� ������ ������ �մϴ�.
������ �� �ִ� �ǻ�ü���� ������ ǥ���Ͽ����ϴ�.
image.png

������� ��� �ǻ�ü���� ��� ������, ������ �ȿ� ���� �� �ִ� ���� �����Ǿ� �ֽ��ϴ�.

������� �� �׸��� �ǻ�ü�� �� ������ 2 5 2 6 5 -3 9 4 2 -7 �̸�, �����Ⱑ ���� �� �ִ� ���� 5ĭ�� ��� �Դϴ�.
���� 0 �� �ε������� 4 ���ε������� �Կ� ��, ���� �� �ִ� ���� ������ 2 + 5 + 2 + 6 + 5 = 20 �Դϴ�.
���� 1 �� �ε������� 5 �� �ε������� �Կ� ��, ���� �� �ִ� ���� ������ 5 + 2 + 6 + 5 + -3 = 15 �Դϴ�.

�̷��� ���� 5�� ��� �� ǳ�濡�� ���� �� �ִ� ���� ���� ������ 6 + 5 + -3 + 9 + 4 = 21 �Դϴ�.

�ǻ�ü���� ������ �Է¹ް�, ���� ���� ������ ���� ������ ��� ���ؼ� ��� �ε������� ��� �ε������� �Կ��� �ؾߵǴ����� ������ּ���

�Է�
ù ��° �ٿ��� �׽�Ʈ���̽��� ��(T)�� �Էµ˴ϴ�. (1 <= T <= 50)
�� ��° �ٺ��� �� �׽�Ʈ���̽�����,
ù��° �ٿ����ǻ�ü�� ����(N), �������� ��(W) �� �Է¹ް�
�� ���� �ٿ��� �ǻ�ü�� ����ŭ ������ �Է¹޽��ϴ�.
(1 <= W < N <= 100,000)

���
�� �׽�Ʈ���̽� ����
�ִ뿹�� ������ ������ ���� ���� �ε���, �� �ε���, �ִ� ���������� ����մϴ�.
�ε��� ��ȣ�� 0�� �ε������� �����մϴ�.
����, �ִ� ���� ������ ������ ������ ���� ���� ��� ���� ���� ���ʿ� �ִ� ������ ����մϴ�.

�Է� ���� 1 

2
10 5
2 5 2 6 5 -3 9 4 2 -7 
5 2
-1 -2 -3 -4 -5

��� ���� 1

#1 3 7 21
#2 0 1 -3
 
*/

public class Main10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int now_sum = 0; // ������ ��
		for (int i = 0; i < W - 1; i++) // W-1���� '���� ����'�� �غ�
			now_sum += arr[i];

		int ans_sum = Integer.MIN_VALUE; // �ִ� ���� ������ ��
		int ans_s = 0; // �ִ� ���� ���� ������ ������
		int ans_e = 0; // �ִ� ���� ���� ������ ����

		int s = 0; // ���� ������ ������
		int e = W - 1; // ���� ������ ����
		for (int i = 0; i <= N - W; i++) {
			now_sum += arr[e]; // W���� '���� ����'�� ���� ����

			// ���� ������ ���� ������ '�ϰ� ���� ó��'
			if (ans_sum < now_sum) {
				ans_sum = now_sum;
				ans_s = s;
				ans_e = e;
			}

			now_sum -= arr[s]; // ���籸���� '�� ��'data�� ����(���� ���� �غ�)
			s++; // ������������ ���� �̵�
			e++;
		}
		System.out.println("#" + tc + " " + ans_s + " " + ans_e + " " + ans_sum);
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}