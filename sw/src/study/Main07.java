package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
�� ���ݷ� ����

����
���ĺ� ����� ���ݷ����� �����޾ҽ��ϴ�.
� ���ĺ����� �����ϴ��� ������� �����ϰ��� �մϴ�.

ccu.png

�빮�ڷ� ������ �幮�� �� ���ڿ��� �Է¹޽��ϴ�.
�� ���ڿ����� �ߺ� ���ĺ��� ��� ������ �ּ���.
�� ��, ���ĺ� ������� �����Ͽ� ����� �ּ���.

�Է�
�� ���ڿ��� �Էµ˴ϴ�.
���ڿ� ���̴� �ִ� 100,000 �Դϴ�.

���
�����ϴ� ���ĺ� ������� ����� �ּ���.

�Է� ���� 1 

FDAAAAFDA

��� ���� 1

ADF

�Է� ���� 2 

BBQCOOKIE

��� ���� 2

BCEIKOQ
 * */

public class Main07 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // �׻� �� �ִ� ����
    static int DAT[] = new int[256];
    // index : ����
    // value : �ش� ���ڰ� '�־��°�'?
    //        - �ش� ���ڰ� '�� �� �־��°�?'
    // 256 : ��� char�� ǥ�� ������ ������ ��
    public static void main(String[] args) throws IOException{
        String temp = br.readLine();
        for(int i = 0; i < temp.length(); i++)
            DAT[temp.charAt(i)]++; // �� ���ڰ� �� �� �ִ°��� counting
        for(char ch = 'A'; ch <= 'Z'; ch++)
            if(DAT[ch] >= 1) // 1�� �̻��� ���ڰ� �ִ°�?
                System.out.print(ch);
    }

}
