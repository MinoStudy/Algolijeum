package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
�� �Է°� ���

����
Build Test �� ����� ������ ���� �����Դϴ�.

C++�� ���� ������� ���� scanf / printf �� ����ϰ�,
Java�� ���� ������� ���� BufferedReader / BufferedWriter ����� ���մϴ�.

Type�� �Է¹ް�,
Type�� �´� �Է°� ����� ���ּ���.

�Է�
ù �ٿ��� Type�� �Է¹޽��ϴ�.
�� Type�� �´� ����� ó���� ���ֽø� �˴ϴ�.

[Type 1]
�� n�� �Է� �޽��ϴ�. (1 <= n <= 10)
���� �ٿ��� n���� ���� �Է¹޽��ϴ�. (-9 <= �� <= 9)
��°������ü �հ� ��ü ���Դϴ�.

[Type 2]
���� n�� �Է� �ް�, n���� ��� �ٸ� ������ ���ڿ��� �Է¹޽��ϴ�.(1 <= n <= 100)
����� ���ڿ���, ���� ���̰�ª�� ���ڿ��� ����մϴ�.

[Type 3]
Y, X �� ���� �Է� �޽��ϴ�.(1 <= Y, X <= 100)
���� �� ���ʹ� (Y * X) ���� 2���� �迭�� �Է� �޽��ϴ�.(0 <= �迭 �� <= 100)
2���� �迭�������� ���� ���� ã�� ����մϴ�.
���� �ٿ��°��� ���� ���� ������ ����մϴ�.

���
Type 1, 2, 3 �� ���� ����� ����ϼ���.

�Է� ���� 1 

1
5
1 2 3 4 5

��� ���� 1

15 120
�Է� ���� 2 

2
4
FIGHT
show
OPERATION
DISONW

��� ���� 2

OPERATION
show
�Է� ���� 3 

3
3 4
0 4 2 5
7 5 0 3
2 4 2 0

��� ���� 3

0
3��

��Ʈ

1. Java ����� ���� ��ũ
2. ������ ���� 21���� ���� ���� �ֽ��ϴ�.
*/
public class Main02 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �׻� �� �ִ� ����

	static void sol1() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		// int : 21�� ���� �Ѵ� ������ ���尡��
		long mul = 1;
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			mul *= temp;
		}
		System.out.print(sum + " " + mul);
	}

	static void sol2() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int minLen = Integer.MAX_VALUE;
		String minStr = "";
		int maxLen = 0;
		String maxStr = "";
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			if (minLen > temp.length()) {
				minLen = temp.length();
				minStr = temp;
			}
			if (maxLen < temp.length()) {
				maxLen = temp.length();
				maxStr = temp;
			}
		}
		System.out.println(maxStr);
		System.out.println(minStr);
	}

	static void sol3() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		int minValue = Integer.MAX_VALUE;
		int minCnt = 0;
		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colSize; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (minValue > temp) {
					minValue = temp;
					minCnt = 1;
				} else if (minValue == temp)
					minCnt++;
			}
		}
		System.out.println(minValue);
		System.out.println(minCnt + "��");
	}

	public static void main(String[] args) throws IOException {
		int type = Integer.parseInt(br.readLine());
		if (type == 1)
			sol1();
		else if (type == 2)
			sol2();
		else if (type == 3)
			sol3();
	}
}
