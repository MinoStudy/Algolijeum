package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
��ī��߱ޱ�

����
ī�� �߱ޱ�� N ���� �л��鿡��1 ~ N �� ���� ī�带 �߱��� �ִ� ��ġ�Դϴ�.

�� ī�� �߱ޱ⿡�� ��Ģ�� �ֽ��ϴ�.
ī�� ��ȣ�� ����� ��, �л��� Ű�� �������� �߱��մϴ�.
Ű�� ���� �л����Դ� ���� ��ȣ�� ����ϰ� Ű�� ���ų� ū �л����Դ� �� ���� ��ȣ�� �߱��մϴ�.
��, n�� ī�带 ����ִ� �л��� n + 1�� ī�带 ����ִ� ������� Ű�� ���ų� Ů�ϴ�.

��1.png

���� ���, N = 5 �̰� �ټ����� �л����� Ű�� �Ʒ��� ���� �Է� �޽��ϴ�.
ù��°�� �Էµ� �л��� Ű�� 202 cm �Դϴ�.
�ι�°�� �Էµ� �л��� Ű�� 195 cm �Դϴ�.
����°�� �Էµ� �л��� Ű�� 191 cm �Դϴ�.
�׹�°�� �Էµ� �л��� Ű�� 195 cm �Դϴ�.
������ �ټ���°�� �Էµ� �л��� Ű�� 232 cm �Դϴ�.

�л����� Ű�� �Է� ���� ��, �߱��� �Ϸ�� ī�� ��ȣ�� �Է� �޽��ϴ�.
�߱� ���� ī�� ��ȣ�� ������ �ùٸ��ٸ� 'YES'��, �ƴ϶�� 'NO'�� ����� �ּ���.

�Է�
�׽�Ʈ ���̽��� �� T�� ù �ٿ� �Է� �˴ϴ�. (1 <= T <= 100)
���� �ٿ��� �л� �� N�� �Է� �˴ϴ�. (1 <= N <= 1,000,000)
���� �ٿ��� N���� Ű�� �Էµ˴ϴ�.
���� �ٿ��� N���� �л����� ����� ī�� ��ȣ�� ������� �Է� �˴ϴ�.

���
�� �׽�Ʈ ���̽��� ���� ������ ���� ��� ���ּ���.
ī�� ��ȣ�� �ùٸ��ٸ� 'YES',
�ùٸ��� �ʴٸ� 'NO' �� ��� ���ּ���.

�Է� ���� 1 

2
5
202 195 191 195 232
2 3 5 1 4
5
202 195 191 195 232
2 3 5 4 1

��� ���� 1

NO
YES
 * */
public class Main09 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int Height[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			Height[i] = Integer.parseInt(st.nextToken());
		}

		int DAT[] = new int[n + 1];
		// index : ī�� ��ȣ 1 ~ n
		// value : �ش� ī�� ��ȣ�� ���� ����� Ű
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			DAT[card] = Height[i]; // DAT����
		}
		for (int i = 1; i < n; i++)
		// i : ī�� ��ȣ
		{
			if (DAT[i] < DAT[i + 1]) {
				System.out.println("NO");
				return;
			}
		}
		// return�� �ɸ��� �ʰ�, �� ����ߴ�. �������� ���´�.
		System.out.println("YES");
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol();
		}
	}
}