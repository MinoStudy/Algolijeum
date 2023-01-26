package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� ��� �𳻱�

����
�𳻱� ö�� ����
����� ��������, �˱����� �� '���� Ʒ�� ��'�� ���� �ɰ� �߽��ϴ�.
�� ���� ���� �� ����� ������ ���ϰ�, �Ϸķ� �� �ɽ��ϴ�.

����, �𳻱�, õ����, ������

���� ������ �ƴ� ����� ��������,
�� �ɾ�� �� ��ġ�� �Ǽ��� �Ѿ�� ��찡 �����ϴ�.

�� ���� ������ 1,�� ���� ���� ������ 0 ���� ǥ��˴ϴ�.
cc1.png

����� �������� �� ���� ���� ����� �Է� �޽��ϴ�.
�� ���κ� �� ���� �� �������� �ɾ����� Counting�Ͽ� ����� �ּ���.

�Է�
input �Լ�(�޼���) �� �����,input �Լ����� ��� �Է��� ó���� �ּ���.
ù �ٿ��� Height�� Width�� �Էµ˴ϴ�. (1 <= Height, Width <= 1,000)
���� �ٿ��� Height x Width �������� �� ���� �� ����� �Է� �޽��ϴ�.

���
output �Լ�(�޼���)�� �����, ����� ��� �� �ּ���.
�� ���δ� ���� ���� ������ ����� �ּ���.


�Է� ���� 1 

5 6
100111
111101
011110
110001
011100

��� ���� 1

4
5
4
3
3
 * */

public class Main03 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �׻� �� �ִ� ����
	static int Height, Width;

	static String str[];

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Height = Integer.parseInt(st.nextToken());
		Width = Integer.parseInt(st.nextToken());
		str = new String[Height];
		for (int i = 0; i < Height; i++) {
			str[i] = br.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < Height; i++) {
			int cnt = 0;
			for (int j = 0; j < Width; j++)
				if (str[i].charAt(j) == '1')
					cnt++;
			System.out.println(cnt);
		}
	}
}
