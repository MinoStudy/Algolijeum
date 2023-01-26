package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	DAT 및 Ascii code JAVA
*/

public class Main07_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 항상 꼭 있는 구문
    static int DAT[] = new int[256];
    // index : 문자
    // value : 해당 문자가 '있었는가'?
    //        - 해당 문자가 '몇 개 있었는가?'
    // 256 : 모든 char로 표현 가능한 종류의 수
    public static void main(String[] args) throws IOException{

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++)
        {
            char now = str.charAt(i);
            DAT[now]++;
            /*
            DAT[index] -> index : 0이상의 정수
            char : 0~127사이의 정수(문자 => 수) => Ascii code
            */
        }
        if(DAT['A'] == 1)
            System.out.println("A가 있다.");
        /*
        char temp = br.readLine().charAt(0);
        // 대문자 -> 소문자
        System.out.println((char)(temp + 32));
        */
    }
}