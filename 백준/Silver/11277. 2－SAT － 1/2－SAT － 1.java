import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] func;
	static int N, M;
	private static void dfs(int cnt, boolean[] vars) {
		if(cnt == N+1) {
			if(CNF2(vars)) {
				System.out.println("1");
				System.exit(0);
			}
			return;
		}
		vars[cnt] = true;
		dfs(cnt+1, vars);
		vars[cnt] = false;
		dfs(cnt+1, vars);
	}
	private static boolean CNF2(boolean[] vars) {
		for (int i = 0; i < M; i++) {
			int a = Math.abs(func[i][0]);
			int b = Math.abs(func[i][1]);
			boolean x = vars[a];
			boolean y = vars[b];
			a = func[i][0];
			b = func[i][1];
			if(a < 0) x = !x;
			if(b < 0) y = !y;
			if(!(x || y)) return false; 
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		func = new int[M][2];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			func[i][0] = a; func[i][1] = b;
		}
		dfs(1, new boolean[N+1]);
		bw.write("0");
		
		bw.flush();
		bw.close();
		br.close();
	}
}