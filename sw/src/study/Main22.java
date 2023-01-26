package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
�� SPY�� ������

����

�׷����� �� ���� Type���� ǥ���� �� �ֽ��ϴ�.

�������
��������Ʈ
1���� �迭 (2��Ʈ�� ����)

���ڵ� Company�� �Ʒ��� ���� ����Ʈ�� ���·� �������� ���� �Ǿ� �ְ�, �׻� ���� ������ �θ��Դϴ�.
SPY�� �˾Ƴ� ������ ������ �ϵ��ڵ� ���ּ���.
�� ���� Type ��, ���ο��� ���� �ͼ����� ���� ������� �ϵ��ڵ��� �ϸ� �˴ϴ�.
�׸�6.png

���� �����ȣ �Է� �޽��ϴ�.
�ش� �����ȣ������ ��� /���� /���� ���ϵ��� �������� ����� �ּ���.

�Է�
�� �ڸ� ��� ��ȣ�� �Էµ˴ϴ�.
�������� �ʴ� ��� ��ȣ�� �Էµɼ��� �ֽ��ϴ�.

���
ù �ٿ����Է� ���� ����� ���� ��� ����� ����մϴ�.
���� ���� ��簡 ���ٸ� "no boss"�� ����մϴ�.

�ι�° �ٿ��� ������ ����� ����մϴ�.
���� ���ᰡ ���ٸ� "no company"�� ����մϴ�.

�� ��° �ٿ��� ���� ���ϵ��� ����� ����մϴ�.
���� ���� ���ϰ� ���ٸ� "no junior"�� ����մϴ�.

���� �������� �ʴ� ����� �Է¹޾Ҵٸ�, "no person" �� ����մϴ�.

�Է� ���� 1 

1680

��� ���� 1

1004
9941
3367 3261

�Է� ���� 2 

1004

��� ���� 2

no boss
no company
1680 9941

�Է� ���� 3 

9999
��� ���� 3

no person
*/
public class Main22 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int DAT[] = { 0, 1004, 1680, 9941, 3367, 3261, 2976, 4889, 1234, 6461, 7329, 5518 };
		ArrayList<Integer> al[] = new ArrayList[12];
		for (int i = 0; i < 12; i++)
			al[i] = new ArrayList<>();
		// ������ ArrayList�����

		al[1].add(2);
		al[1].add(3);
		al[2].add(4);
		al[2].add(5);
		al[3].add(6);
		al[3].add(7);
		al[5].add(8);
		al[5].add(9);
		al[6].add(10);
		al[6].add(11);

		int id = Integer.parseInt(br.readLine());
		int node = -1;
		for (int i = 1; i <= 11; i++)
			if (id == DAT[i])
				node = i;
		// ��� -> node��ȣ �˻�

		if (node == -1) {
			System.out.println("no person");
			return;
		}

		int boss = -1;
		for (int from = 1; from <= 11; from++) {
			for (int i = 0; i < al[from].size(); i++) {
				int to = al[from].get(i);
				if (to == node)
					// �Է¹޾Ҵ� ����� ������������ �߰��ߴ�.
					boss = from;
			}
		}
		if (boss == -1) {
			System.out.println("no boss");
			System.out.println("no company");
		} else {
			System.out.println(DAT[boss]);

			int company = -1;
			for (int i = 0; i < al[boss].size(); i++) {
				int to = al[boss].get(i);
				if (to != node)
					// �� boss�� �������� �� ���� �ƴ� �ٸ� ����� �����̴�.
					company = to;
			}
			if (company == -1)
				System.out.println("no company");
			else
				System.out.println(DAT[company]);
		}

		if (al[node].size() == 0)
			System.out.println("no junior");
		else {
			for (int i = 0; i < al[node].size(); i++) {
				int to = al[node].get(i);
				System.out.print(DAT[to] + " ");
			}
		}
	}
}