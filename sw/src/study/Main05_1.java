package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 ���ڿ� ã�� sampe code
 * */
public class Main05_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �׻� �� �ִ� ����

	public static void main(String[] args) throws IOException {
		String origin = "13241524";
		String temp = "415";
		for (int i = 0; i <= origin.length() - temp.length(); i++)
		// �������� temp�� �ִ��� Ȯ���� ��ġ (origin�� ����)
		{
			int cnt = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (origin.charAt(i + j) == temp.charAt(j)) {
					cnt++;
				}
			}
			if (cnt == temp.length())
				System.out.println(i);
		}

	}
}