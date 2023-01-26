package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
�� �پ��ִ� ���ڿ� ó�� JAVA
 * */
public class Main25_1 {

	   static class Node{
	        int row;
	        int col;
	        Node(int row, int col){
	            this.row = row;
	            this.col = col;
	        }
	    }

	    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    static char MAP[][];
	    static int Width = 7;
	    static int Height = 8 ;

	    static void input() throws IOException
	    {
	        for(int i = 0; i < Height; i++)
	        {
	            String temp = br.readLine(); // "0010000"
	            for(int j = 0; j < Width; j++)
	                MAP[i][j] = temp.charAt(j);
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        input();
	    }
	}