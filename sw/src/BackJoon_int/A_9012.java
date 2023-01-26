package BackJoon_int;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class A_9012 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			boolean succ = true;
			String s = st.nextToken();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				
				if(c == '(') {
					stack.push(c);	
				}else {
					if(stack.empty()) {
						succ = false;
						break;
					}
					stack.pop();
				} 
			}
			
			if(succ && stack.empty()) {
				bw.append("YES\n");
			}else {
				bw.append("NO\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
