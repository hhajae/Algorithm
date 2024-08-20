import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] students;
	static boolean[] isvisited;
	static boolean[] ischecked;
	static int memNum;
	static int resCnt;
	private static void dfs(int cur) {
		if(isvisited[cur]) return;
		
		if(ischecked[cur]) {
			memNum = cur;
			return;
		}
		
		ischecked[cur] = true;
		dfs(students[cur]);
		if(memNum != -1) {
			resCnt++;
			if(memNum == cur) memNum = -1;
		}
		isvisited[cur] = true;
		ischecked[cur] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			students = new int[n+1];
			isvisited = new boolean[n+1];
			ischecked = new boolean[n+1];
			resCnt = 0;
			memNum = -1;
			for (int i = 1; i < n+1; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < n+1; i++) {
				if(isvisited[i]) continue;
				dfs(i);
			}
			sb.append(n - resCnt).append("\n");
		}
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
