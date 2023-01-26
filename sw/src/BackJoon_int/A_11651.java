package BackJoon_int;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;



class Point2 implements Comparable<Point>{
	int x, y;
	Point2(int x, int y){
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

public class A_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point2[] a = new Point2[n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			a[i] = new Point2(x, y);
		}
		
		// Comparable compareTo를 구현 natural순서 정의
		// Comparator 다른순서 정렬하고 싶을때
		Arrays.sort(a, new Comparator<Point2>() {
			public int compare(Point2 p1, Point2 p2) {
				if(p1.y < p2.y) {
					return -1;
				}else if(p1.y == p2.y) {
					if(p1.x < p2.x) {
						return -1;
					} else if(p1.x == p2.x) {
						return 0;
					}else  {
						return 1;
					}
				}else {
					return 1;
				}
			}
		});
		
		StringBuilder sb= new StringBuilder();
		for(Point2 p:a) {
			sb.append(p.x + " " + p.y + "\n");
		}
		System.out.print(sb);
	}
	
	 
}
