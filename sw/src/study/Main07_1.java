package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	DAT �� Ascii code JAVA
*/

public class Main07_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // �׻� �� �ִ� ����
    static int DAT[] = new int[256];
    // index : ����
    // value : �ش� ���ڰ� '�־��°�'?
    //        - �ش� ���ڰ� '�� �� �־��°�?'
    // 256 : ��� char�� ǥ�� ������ ������ ��
    public static void main(String[] args) throws IOException{

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++)
        {
            char now = str.charAt(i);
            DAT[now]++;
            /*
            DAT[index] -> index : 0�̻��� ����
            char : 0~127������ ����(���� => ��) => Ascii code
            */
        }
        if(DAT['A'] == 1)
            System.out.println("A�� �ִ�.");
        /*
        char temp = br.readLine().charAt(0);
        // �빮�� -> �ҹ���
        System.out.println((char)(temp + 32));
        */
    }
}