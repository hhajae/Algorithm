import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int tc = 0;
        while(true) {
        	tc++;
        	String s = br.readLine();
        	if(s.charAt(0) == '-') break;
        	Stack<Character> stk = new Stack<>();
        	int resCnt = 0;
        	for (int i = 0; i < s.length(); i++) {
				if(stk.isEmpty()) {
					if(s.charAt(i) == '{') stk.add('{');
					else {
						resCnt++;
						stk.add('{');
					}
					continue;
				}
				if(s.charAt(i) == '{') {
					stk.add('{');
					continue;
				}
				if(s.charAt(i) == '}') {
					if(stk.peek() == '{') {
						stk.pop();
						continue;
					}
					stk.add('}');
				}
			}
        	if(stk.isEmpty()) {
        		sb.append(tc).append(". ").append(resCnt).append("\n");
        		continue;
        	}
        	while(!stk.isEmpty())  {
        		char back = stk.pop();
        		char front = stk.pop();
        		if(front == '{' && back == '{') {
        			resCnt++;
        			continue;
        		}
        		if(front == '}' && back == '{') {
        			resCnt += 2;
        			continue;
        		}
        	}
        	
        	sb.append(tc).append(". ").append(resCnt).append("\n");
        }
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
