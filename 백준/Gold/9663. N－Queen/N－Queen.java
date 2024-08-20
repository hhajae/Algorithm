import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int resCnt = 0;
	static boolean isvisited1[];
	static boolean isvisited2[];
	static boolean isvisited3[];
	private static void batch(int cnt) {
		if (cnt == N) { // row 끝까지 다다랐으면
			resCnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isvisited1[i] || isvisited2[cnt+i] || isvisited3[cnt-i+N-1]) continue;
			isvisited1[i] = true;
			isvisited2[cnt+i] = true;
			isvisited3[cnt-i+N-1] = true;
			batch(cnt+1);
			isvisited1[i] = false;
			isvisited2[cnt+i] = false;
			isvisited3[cnt-i+N-1] = false;
		}
	}
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		isvisited1 = new boolean[N];
		isvisited2 = new boolean[2*N-1];
		isvisited3 = new boolean[2*N-1];
		batch(0);
		bw.write(resCnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}