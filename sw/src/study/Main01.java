package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�� JAVA �Է�
 * */
public class Main01 {
	// Scanner <- �ð� �ʰ� O 
    // BufferedReader <- �ð� �ʰ� X 
    // �Է� data size <-

    // System.out.println
    // BufferedWriter<-

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // �׻� �� �ִ� ����

    public static void main(String[] args) throws IOException{

        //System.out.print(br.readLine()); // <- string���� '�� ��'�� ���� �������� ����

        StringTokenizer st = new StringTokenizer(br.readLine());
        // ���� ������ �ɰ��� data�� �غ�

        //st.nextToken(); // <- ��������� �ɰ����� data�� �ϳ��� ȣ��
        //1 2 3 4 5

        int arr[] = new int[5];
        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 5;i++)
            System.out.println(arr[i]);

        /*
        String a;
        a.length(); <- ���ڿ� ���� ȣ��        
        */
    }

}
