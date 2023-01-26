package BackJoon_int;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;



class Point implements Comparable<Point>{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(Point that) {
		if(this.x < that.x) {
			return -1;
		}else if(this.x == that.x) {
			if(this.y < that.y) {
				return -1;
			}else if(this.y == that.y) {
				return 0;
			}else{
				return 1;
			}
		}else {
			return 1;
		}
	}
	
}

public class A_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] a = new Point[n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			a[i] = new Point(x, y);
		}
		
		Arrays.sort(a, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.compareTo(p2);
			}
		});
		
		StringBuilder sb= new StringBuilder();
		for(Point p:a) {
			sb.append(p.x + " " + p.y + "\n");
		}
		System.out.print(sb);
	}
	
	 
}
