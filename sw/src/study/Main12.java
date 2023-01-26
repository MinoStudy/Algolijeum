package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
�� ��Ȯ�� ��ȣ

����
image.png

"M1nCod1n9"
357.482 KHz�� ��ȣ�� ������ ��ȣ�� �������ϴ�.

���ĺ� ��ҹ��ڿ� 0 ~ 9 ������ ���ڷ� �̷��� �ִ� ��ȣ�Դϴ�.
�� ������ ��ȣ�� ũ�Ⱑ M �� ���������� �ߺ��� ���ڰ� �������� �ʴ´ٴ� ���� �˾Ƴ½��ϴ�.

������Ʈ �˷���� �ڻ�� �� �ܰ� ��ȣ�� �м��Ͽ���, �ٽ� �۽��� �� �޽����� ����� �½��ϴ�.
�ڻ簡 ���� �޽������� ũ�Ⱑ M�� ������ �ߺ��� ���ڰ� �ִ��� üũ���ִ� ���α׷��� ����� �ּ���.

�Է�
ù�ٿ� �׽�Ʈ���̽��� ��(T)�� �Էµ˴ϴ�.
�� �����ٺ��� �� �׽�Ʈ ���̽� ����,
���� M�� �ԷµǸ�
�����ٿ��� �ڻ簡 ���� �޽����� �Էµ˴ϴ�.
�޽����� �ִ���̴� 10���̸� , M�� �޽����� ���̺��� �� �������� �Էµ˴ϴ�.

���
�� �׽�Ʈ���̽� ���� ��ȿ�� �˻� ����� PASS , FAIL �� ������ּ���.

�Է� ���� 1 

3
4
1bacDBTAab12D
3
734734734
2
10101010111

��� ���� 1

#1 PASS
#2 PASS
#3 FAIL
*/
public class Main12 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol(int tc) throws NumberFormatException, IOException {
		int M = Integer.parseInt(br.readLine());
		String message = br.readLine();

		int DAT[] = new int[256];
		// index : ����
		// value : ���ڰ� �ִ°�?

		// 1. ���� ���� ����(M-1 ��)
		for (int i = 0; i < M - 1; i++) {
			if (DAT[message.charAt(i)] == 1)
			// ����� �ϱ⵵ ���� �ش� ���ڿ� ���� ����� �ִ�. <- �ߺ��� ����
			{
				System.out.println("#" + tc + " FAIL");
				return;
			}
			DAT[message.charAt(i)] = 1;
		}

		int s = 0; // ���� ������ ������
		int e = M - 1; // ���� ������ ����
		for (int i = 0; i <= message.length() - M; i++) {
			if (DAT[message.charAt(e)] == 1)
			// �տ��� �̹� ���� ���ڰ� ���Ծ���. <- ����� �̹� �����Ѵ�.
			{
				System.out.println("#" + tc + " FAIL");
				return;
			} // ������ '������'data�� ���Ͽ�

			DAT[message.charAt(e)] = 1;
			// �� ������ �߰��Ͽ� 'W���� ����'�� �ϼ�

			DAT[message.charAt(s)] = 0;
			// �� ���� ����� �����Ͽ� 'W-1���� ���뱸��' ����
			s++; // ���� �̵�
			e++; // ���� �̵�
		}

		// ��� ������ �������� ��Ȳ

		System.out.println("#" + tc + " PASS");

	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol(tc);
		}
	}
}