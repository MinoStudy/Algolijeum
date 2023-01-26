package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
■ 초콜렛 선물

설명
알파벳 모양의 초콜렛들을 선물받았습니다.
어떤 알파벳들이 존재하는지 순서대로 나열하고자 합니다.

ccu.png

대문자로 구성된 장문의 한 문자열을 입력받습니다.
이 문자열에서 중복 알파벳을 모두 제거해 주세요.
그 뒤, 알파벳 순서대로 정렬하여 출력해 주세요.

입력
긴 문자열이 입력됩니다.
문자열 길이는 최대 100,000 입니다.

출력
존재하는 알파벳 순서대로 출력해 주세요.

입력 예시 1 

FDAAAAFDA

출력 예시 1

ADF

입력 예시 2 

BBQCOOKIE

출력 예시 2

BCEIKOQ
 * */

public class Main07 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 항상 꼭 있는 구문
    static int DAT[] = new int[256];
    // index : 문자
    // value : 해당 문자가 '있었는가'?
    //        - 해당 문자가 '몇 개 있었는가?'
    // 256 : 모든 char로 표현 가능한 종류의 수
    public static void main(String[] args) throws IOException{
        String temp = br.readLine();
        for(int i = 0; i < temp.length(); i++)
            DAT[temp.charAt(i)]++; // 각 문자가 몇 개 있는가를 counting
        for(char ch = 'A'; ch <= 'Z'; ch++)
            if(DAT[ch] >= 1) // 1개 이상의 문자가 있는가?
                System.out.print(ch);
    }

}
