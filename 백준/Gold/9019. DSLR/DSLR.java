import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class DSLR {
	int n;
	StringBuilder sb;
	public DSLR(int n, StringBuilder sb) {
		super();
		this.n = n;
		this.sb = sb;
	}
}
public class Main {
	private static int rotateLeft(int n) {
		StringBuilder prev = new StringBuilder();
		while(prev.toString().length() + Integer.toString(n).length() != 4) {
			prev.append("0");
		}
		prev.append(n);
		String prevs = prev.toString();
		StringBuilder next = new StringBuilder();
		next.append(prevs.charAt(1)).append(prevs.charAt(2)).append(prevs.charAt(3)).append(prevs.charAt(0));
		return Integer.parseInt(next.toString());
	}
	private static int rotateRight(int n) {
		StringBuilder prev = new StringBuilder();
		while(prev.toString().length() + Integer.toString(n).length() != 4) {
			prev.append("0");
		}
		prev.append(n);
		StringBuilder next = new StringBuilder();
		String prevs = prev.toString();
		next.append(prevs.charAt(3)).append(prevs.charAt(0)).append(prevs.charAt(1)).append(prevs.charAt(2));
		return Integer.parseInt(next.toString());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        outer: for (int i = 0; i < T; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
//			int[] dist = new int[10000];
			boolean[] isvisited = new boolean[10000];
//			Arrays.fill(dist, -1);
			Queue<DSLR> que = new ArrayDeque<>();
			que.offer(new DSLR(A, new StringBuilder()));
//			dist[A] = 0;
			isvisited[A] = true;
			while(!que.isEmpty()) {
				DSLR cur = que.poll();
				int caseD = cur.n * 2 % 10000;
//				System.out.println("cur = " + cur.n);
//				System.out.println("caseD = " + caseD);
				if(caseD == B) {
					sb.append(cur.sb.toString()).append("D").append("\n");
					continue outer;
				}
//				if(dist[caseD] == -1) {
				if(!isvisited[caseD]) {
					StringBuilder tmpSb = new StringBuilder();
					tmpSb.append(cur.sb.toString()).append("D");
					que.offer(new DSLR(caseD, tmpSb));
//					dist[caseD] = cur.sb.toString().length();
					isvisited[caseD] = true;
				}
				
				int caseL = rotateLeft(cur.n);
//				System.out.println("caseL = " + caseL);
				if(caseL == B) {
					sb.append(cur.sb.toString()).append("L").append("\n");
					continue outer;
				}
//				if(dist[caseL] == -1) {
				if(!isvisited[caseL]) {
					StringBuilder tmpSb = new StringBuilder();
					tmpSb.append(cur.sb.toString()).append("L");
					que.offer(new DSLR(caseL, tmpSb));
//					dist[caseL] = cur.sb.toString().length();
					isvisited[caseL] = true;
				}

				int caseR = rotateRight(cur.n);
//				System.out.println("caseR = " + caseR);
				if(caseR == B) {
					sb.append(cur.sb.toString()).append("R").append("\n");
					continue outer;
				}
//				if(dist[caseR] == -1) {
				if(!isvisited[caseR]) {
					StringBuilder tmpSb = new StringBuilder();
					tmpSb.append(cur.sb.toString()).append("R");
					que.offer(new DSLR(caseR, tmpSb));
//					dist[caseR] = cur.sb.toString().length();
					isvisited[caseR] = true;
				}
				
				int caseS = cur.n - 1;
				if(caseS == -1) caseS = 9999;
//				System.out.println("caseS = " + caseS);
				if(caseS == B) {
					sb.append(cur.sb.toString()).append("S").append("\n");
					continue outer;
				}
//				if(dist[caseS] == -1) {
				if(!isvisited[caseS]) {
					StringBuilder tmpSb = new StringBuilder();
					tmpSb.append(cur.sb.toString()).append("S");
					que.offer(new DSLR(caseS, tmpSb));
//					dist[caseR] = cur.sb.toString().length();
					isvisited[caseS] = true;
				}
			}
		}
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
