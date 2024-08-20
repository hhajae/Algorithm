import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Long> stk;
	private static boolean INV() {
		if(stk.isEmpty()) return false;
		long n = stk.pop();
		stk.add(n*(-1));
		return true;
	}
	private static boolean DUP() {
		if(stk.isEmpty()) return false;
		long n = stk.peek();
		stk.add(n);
		return true;
	}
	private static boolean SWP() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		long n2 = stk.pop();
		stk.add(n1); stk.add(n2);
		return true;
	}
	private static boolean ADD() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		long n2 = stk.pop();
		long sum = n1 + n2;
		if(Math.abs(sum) > 1_000_000_000) return false;
		stk.add(sum);
		return true;
	}
	private static boolean SUB() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		long n2 = stk.pop();
		long sub = n2 - n1;
		if(Math.abs(sub) > 1_000_000_000) return false;
		stk.add(sub);
		return true;
	}
	private static boolean MUL() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		long n2 = stk.pop();
		long mul = n1 * n2;
		if(Math.abs(mul) > 1_000_000_000) return false;
		stk.add(mul);
		return true;
	}
	private static boolean DIV() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		if(n1 == 0) return false;
		long n2 = stk.pop();
		long div = n2 / n1;
		if(Math.abs(div) > 1_000_000_000) return false;
		stk.add(div);
		return true;
	}
	private static boolean MOD() {
		if(stk.size() < 2) return false;
		long n1 = stk.pop();
		if(n1 == 0) return false;
		long n2 = stk.pop();
		long mod = n2 % n1;
		if(Math.abs(mod) > 1_000_000_000) return false;
		stk.add(mod);
		return true;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    outer_program: while(true) {
	    	List<String> baseCommand = new ArrayList<>();
	    	while(true) {
	    		String s = br.readLine();
	    		if(s.equals("END")) break;
	    		if(s.equals("QUIT")) break outer_program;
	    		baseCommand.add(s);
	    	}
	    	int N = Integer.parseInt(br.readLine());
	    	outer_desc: for (int i = 0; i < N; i++) {
	    		stk = new Stack<>();
				int n = Integer.parseInt(br.readLine());
				stk.add((long)n);
				for (int j = 0; j < baseCommand.size(); j++) {
					String command = baseCommand.get(j);
					if(command.length() > 3) { // NUM X
						st = new StringTokenizer(command, " "); String tmp = st.nextToken();
						int X = Integer.parseInt(st.nextToken());
						stk.add((long)X);
						continue;
					}
					else if(command.equals("POP")) { // POP
						if(stk.isEmpty()) {
							sb.append("ERROR\n");
							continue outer_desc;
						}
						stk.pop();
						continue;
					}
					
					else if(command.equals("INV")) {
						if(!INV()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("DUP")) {
						if(!DUP()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("SWP")) {
						if(!SWP()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("ADD")) {
						if(!ADD()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("SUB")) {
						if(!SUB()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("MUL")) {
						if(!MUL()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("DIV")) {
						if(!DIV()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
					else if(command.equals("MOD")) {
						if(!MOD()) {
							sb.append("ERROR\n");
							continue outer_desc;
						} 
					}
				}
				if(stk.size() > 1 || stk.isEmpty()) {
					sb.append("ERROR\n");
				}
				else {
					sb.append(stk.pop()).append("\n");
				}
				
			}
	    	String emptyLine = br.readLine();
	    	sb.append("\n");
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
