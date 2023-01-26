package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ JAVA 입력
 * */
public class Main01 {
	// Scanner <- 시간 초과 O 
    // BufferedReader <- 시간 초과 X 
    // 입력 data size <-

    // System.out.println
    // BufferedWriter<-

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 항상 꼭 있는 구문

    public static void main(String[] args) throws IOException{

        //System.out.print(br.readLine()); // <- string으로 '한 줄'씩 값을 가져오는 역할

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 공백 단위로 쪼개진 data를 준비

        //st.nextToken(); // <- 공백단위로 쪼개놓은 data를 하나씩 호출
        //1 2 3 4 5

        int arr[] = new int[5];
        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 5;i++)
            System.out.println(arr[i]);

        /*
        String a;
        a.length(); <- 문자열 길이 호출        
        */
    }

}
