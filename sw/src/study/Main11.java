package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� ������ ����

����
����� VIP �մԵ��� �����ϴ� �������� ���� �Ƹ�����Ʈ�� �մϴ�.
�� �����忡�� ����Ź�ڿ� ���� N���� �մԵ鿡��, N���� ���ִ� �丮�� �����մϴ�.

N���� �丮 �̸��� ���ڷ� �Ǿ�������,
���� ���ڴ� ���� ������ ���մϴ�.

t1.png

�Ʒ� ���ô� 7���� ���� Ź�ڿ� �ɾ��ְ�,
���� ���� ���� ���ĵ��� �̸��� �����ֽ��ϴ�.
(12�� ������� ������� 65 - 65 - 81 - 86 - 65 - 71 - 69)

image.png
�ڸ��� �ɾ��ִ� ������� ������ ������ �������� ������ �Ծ�� �;��մϴ�.
�ɾ��ִ� ����� �Ÿ� R ��ŭ ������ ���� �ִ� ������ ������ �� �ֽ��ϴ�.
������� R = 2 �϶�, 86 ������ �ִ� ���� �ɾ��ִ� ����� 71 65 86 81 65 ������ ���� �� �ֽ��ϴ�.
�� ���, �ߺ��� ������ ���⿡ ������ ������ ���Դϴ�.

image.png

���� ���� ���ÿ�����
R = 2 �϶�, 66 �ڸ����� ���� �� �ִ� ������ 65 65 66 81 65 �Դϴ�.
�ߺ��� ������ 2�� ������ �մԵ��� �Ҹ��� ������, 3���� �ִٸ� �Ҹ��� ����մϴ�.
���� ������ �������� ���� ���̽��Դϴ�.

���̺� ���� ��� ����� ��������
�ɾƼ� ���� �� �ִ� ���ĵ��� 2�� ������ �ߺ��ǰԲ� ���� ���ִ��ٸ� YES ��,
�׷��� �ʴٸ� NO �� ��� �� �ּ���.

�Է�
ù ��° �ٿ� �׽�Ʈ ���̽��� �� T �� �־����ϴ�. (1 <= T <= 100)
�� �׽�Ʈ ���̽��� ù ��° �ٿ��� �� ���� N, R �� �־����ϴ�. (1 <= N <= 1,000,000)
(1 <= R <= 50,000)
�� �׽�Ʈ ���̽��� �� ��° �ٿ��� N ���� ������ ���ڷ� ����� ���еǾ� �־����ϴ�. (������ ������ 0 ~ 200 �Դϴ�)

���
�� �׽�Ʈ ���̽����� ���������� �����̸� YES,
�Ҹ��������� �����̸� NO �� ����մϴ�.

�Է� ���� 1 

2
7 2
65 66 81 86 65 71 82
8 2
65 65 81 66 65 65 69 69

��� ���� 1

#1 YES
#2 NO
 * */
public class Main11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int arr[] = new int[2 * N]; // �ڿ� ���纻�� �̾� ���ϰ��̹Ƿ� N + N
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[N + i] = arr[i]; // ���纻 ����
		} // �Է� �� rotation ���� ó�� �غ�

		int DAT[] = new int[201];
		// index : ���� ��ȣ 0 ~ 200
		// value : �ش� ������ �� �� �ִ°�?

		// Ȯ���ؾ��� ������ ũ�� : 2 * R + 1, ���� ������ ũ�� : 2 * R
		for (int i = 0; i < 2 * R; i++) {
			DAT[arr[i]]++; // i��° ������ 1�� �߰��ƴ�.
			// ������ ���ĵ��� '�� ���� �ִ°�'

			if (DAT[arr[i]] >= 3) {
				// �߸��ƴ�.
				System.out.println("#" + tc + " NO");
				return;
			}
		} // ���� ���� ���� : 2 * R���� data

		// ���� ������ ������ �̵�
		int s = 0; // ������ ������
		int e = 2 * R; // ������ ����
		for (int i = 0; i < N; i++) // �� N���� ��� �������� ���Ͽ�
		{
			// 2* R + 1���� '�Ϻ��� ����'�� ���� <- �� ���� data�� �߰�
			DAT[arr[e]]++;

			if (DAT[arr[e]] >= 3) {
				// �߸��ƴ�.
				System.out.println("#" + tc + " NO");
				return;
			}

			// ���� ���� �غ�
			DAT[arr[s]]--;
			e++;// ������ �ű�
			s++;// ������ �ű�
		}
		// ��� ������ Ȯ�������� �߸��ƴٰ� ����� X ������ for���� Ż��
		System.out.println("#" + tc + " YES");

	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}