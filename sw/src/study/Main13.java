package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� �ݰ�
 
����
��ö�̴� �̹��� �ζ� 1� ��÷������ ������ �ٷ� ��÷���� ã�ư��� ���ϰ� �ִ�.
�ζǸ� ��� ��� �ֱ⿣ �Ҿ��� ���� �ִ� �ݰ� �ζǸ� �����Ϸ��Ѵ�.

�� �ݰ�� �Ϲ����� �ݰ�� �ٸ��� �� Ư���� ������� �۵��Ѵ�.
�ݰ���M���� ������ ������ ���̾��N���� ��ư���� �̷���� �ִ�.
���̾��� ���ݿ��� 0 ~ M-1�� ������ �ð�������� ������ ���������ʿ��� 0�� ����Ű�� �ִ�.
��ư���������� ������ �������� ���� ��ư�� ���� �����ٹ�ư�� ������ �� ��ŭ ���̾��� �ð� ����(���) Ȥ�� �ݽð� ����(����)���� ȸ���Ѵ�.
�ݰ� ���� ���ؼ� ��ư����Ȯ�� 4�� ���� ���̾��� K�� ����Ű�� ������ �Ѵ�.

image.png

���� ���, 0 ~ 3�� ������ ������ ���̾� (4, 7, -2, -8, 3)�� 5�� ��ư�� ���� �ݰ� �ִٰ� ����.
���� ó�� 7 ��ư�� �����ٸ� ���̾��� �ð� �������� 7��ŭ ȸ���Ͽ� 3�� ����Ű�� �ȴ�.
�� ���� -2 ��ư�� �����ٸ� ���̾��� �ݽð� �������� 2��ŭ ȸ���Ͽ� 1�� ����Ű�� �ȴ�.

�� �ݰ�¿��� ����� �������� ������ �� �ִ�.

���� ���, ���� �ݰ��� (N, M, K)�� ���� (5, 12, 11)�̰� �� ��ư�� ���ڰ� (4, 7, -2, -8, 3)�� ��, ������ ����
(-2, 3, 3, 7), (-2, 3, 7, 3), (-2, 7, 3, 3), (3, -2, 3, 7), (3, -2, 7, 3), (3, 3, -2, 7)
(3, 3, 7, -2), (3, 7, -2, 3), (3, 7, 3, -2), (7, -2, 3, 3), (7, 3, -2, 3), (7, 3, 3, -2)
�� 12������ ������ �� �ִ�.

��ö�̴� �ζǸ� �����ϰ� ��Ű�� ���� �ݰ� ���� ����� ����� ���� ����ϰ��� �Ѵ�.
N, M, K�� �� ��ư�� ���ڰ� �־��� ��,�ݰ� ���� ����� ����� ���� �����ִ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.(1 �� T �� 100)
�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�.
�� �׽�Ʈ ���̽��� ù ��° �ٿ��� N, M, K�� ������� �־�����.(1 �� N �� 1,000 , 2 �� M �� 400,000 , 0 �� K �� M-1)
�� �׽�Ʈ ���̽��� �� ��° �ٿ��� N���� ��ư�� ������ �������� �������� �����Ͽ� �־������ߺ��� ������ �������� �ʴ´�. (-1,000,000,000 �� ��ư�� ������ ���� �� 1,000,000,000)

���
�׽�Ʈ ���̽� �ϳ��� �� �ٿ� ����Ѵ�.
�� �׽�Ʈ ���̽��� ���Ͽ� #x (x�� �׽�Ʈ���̽��� ��ȣ�� 1���� ����)�� ����ϰ�, �ݰ� ���� ����� ����� ���� ����Ѵ�.


�Է� ���� 1 

4
5 12 11
4 7 -2 -8 3
6 6 5
1 -5 -11 7 0 13
6 6 4
1 -5 -11 7 0 13
6 13 10
-1000000000 -999999999 -1 1 999999999 1000000000

��� ���� 1

#1 12
#2 0
#3 625
#4 120
*/
public class Main13 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int num[] = new int[400001];
			int index = 0;
			long cnt[] = new long[400001];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken()) % m;
				if (temp < 0)
					temp += m;

				if (cnt[temp] == 0)
					num[index++] = temp;
				cnt[temp]++;
			}

			int hap_num[] = new int[800002];
			int hap_index = 0;
			long hap_cnt[] = new long[400001];
			for (int i = 0; i < index; i++) {
				for (int j = i; j < index; j++) {
					int temp = (num[i] + num[j]);
					if (temp >= m)
						temp -= m;

					if (hap_cnt[temp] == 0)
						hap_num[hap_index++] = temp;

					if (i == j)
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]];
					else
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]] * 2;
				}
			}

			int de = 1;
			long ans = 0;

			for (int i = 0; i < hap_index; i++) {
				int temp = k - hap_num[i];
				if (temp < 0)
					temp += m;
				if (hap_cnt[temp] != 0)
					ans += hap_cnt[temp] * hap_cnt[hap_num[i]];
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}