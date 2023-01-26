package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� ���԰��� �ý���

����
������� ���� ���� �ý����� �����ؾ� �մϴ�.
�� �ý����� �� ���� ����� �����մϴ�.

ȸ������
����� �ν��Ͽ� ����ó��
����� �ν��Ͽ� ����ó��
cc5.png

[ȸ������]
�����ȣ�� �̸��� �Է¹ް�, ����ó���� ���ݴϴ�.
������ �Ϸ�Ǹ�"[�����ȣ] OK"���ڿ��� ����մϴ�.
���� �̹� ��ϵ� �����ȣ�� ����"[�����ȣ] ERROR"���ڿ��� ����մϴ�.

[����� �ν��Ͽ� ���� ó��]
��� ������ �ý����������ȣ�� �ν����ڸ���, ���� ó���� �Ϸ�˴ϴ�.
���� ó�� ����� �ν��Ѵٸ�,"[�����ȣ] [�̸�] ENTER" ���ڿ��� ����մϴ�.
���� ���� �� ���¿���, ����� �ѹ� �� �ν��Ѵٸ�, "[�����ȣ] [�̸�] EXIT" ���ڿ��� ����մϴ�.
���� ���� �� ���¿���, ����� �ѹ� �� �ν��Ѵٸ� �ٽ� ����ó���� �մϴ�. (���ڿ� ���)
�׸��� ���� ������� �ν��Ѵٸ� "[�����ȣ] ERROR" ���ڿ��� ����մϴ�.

���� �ӵ��� �����ϴ�
��� ���԰��� ���α׷��� ������ �ּ���.

�Է�
�� n�� �Է� �޽��ϴ�. (1 <= n <= 100,000)
���� �� ���� �� n���� ��ɾ �Էµ˴ϴ�.

ȸ�������� �ϴ� ��ɾ�� "1[���] [�̸�]" ���·� �Է��� �־����ϴ�.(1000 <= ��� <= 9999)
����ó���� �Ǵ� ��ɾ�� "2 [���]" ���·� �Է��� �־����ϴ�.(�̸��� �ִ� ���� : 100����)

���
�Է¹��� ��ɾ�� ���پ�, ó�� ����� ����� �ּ���.

�Է� ���� 1 

14
1 1000 TOM
1 1001 BOB
1 1001 JASON
1 1005 JASON
1 9000 JACKY
1 9001 SONEY
2 9000
2 9000
2 9000
2 5555
2 1001
2 1000
1 1000 SHOW
2 1000
��� ���� 1

1000 OK
1001 OK
1001 ERROR
1005 OK
9000 OK
9001 OK
9000 JACKY ENTER
9000 JACKY EXIT
9000 JACKY ENTER
5555 ERROR
1001 BOB ENTER
1000 TOM ENTER
1000 ERROR
1000 TOM EXIT
 * */
public class Main04 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �׻� �� �ִ� ����

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String NAME[] = new String[10000];
		// value : �̸�
		int check[] = new int[10000];
		// value : ���Ծȵ� - 0, ��ϵ� ����, ����X - 1, ����O - 2
		// index : ���(1000~9999)

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (type == 1) {// ����
				String name = st.nextToken();
				if (check[num] != 0) // ����� ����ϱ⵵ ���� '�̹� ����� ������'
				{
					System.out.println(num + " ERROR");
					continue;
				}
				NAME[num] = name;
				check[num] = 1;
				System.out.println(num + " OK");
			} else if (type == 2) {// ����
				if (check[num] == 1) // ���� ���� X
				{
					System.out.println(num + " " + NAME[num] + " ENTER");
					check[num] = 2;
				} else if (check[num] == 2) // ���� O
				{
					System.out.println(num + " " + NAME[num] + " EXIT");
					check[num] = 1;
				} else if (check[num] == 0) {
					System.out.println(num + " ERROR");
				}
			}
		}

	}
}