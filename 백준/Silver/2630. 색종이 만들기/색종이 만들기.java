import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int whites = 0, blues = 0;
	private static void cutPapers(int N, int[][] cuts) {
		int check = cuts[0][0];
		boolean swc = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check != cuts[i][j]) {
					swc = true;
					break;
				}
				if (swc) break;
			}
		}
		if(swc && N == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (cuts[i][j] == 0) whites++;
					else blues++;
				}
			}
		}
		
		else if (swc) {
			int[][] tmpCuts = new int[N/2][N/2];
			int dx[] = {0, 0, N/2, N/2};
			int dy[] = {0, N/2, 0, N/2};
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N/2; j++) {
					for (int k = 0; k < N/2; k++) {
						tmpCuts[j][k] = cuts[j + dx[i]][k + dy[i]];
					}
				}
				cutPapers(N/2, tmpCuts);
			}
		}
		else {
			if (cuts[0][0] == 0) whites++;
			else blues++;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] papers = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		cutPapers(N, papers);
		bw.write(whites + "\n");
		bw.write(blues + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}