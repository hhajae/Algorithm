import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[]	numbers;
	public static int team[][];
	public static int ind_cnt;
	public static void comb(int cnt, int start) {
		if (cnt == N/2) {
			for (int i = 0; i < N/2; i++) {
				team[ind_cnt][i] = numbers[i];
			}
			ind_cnt++;
			return;
		}
		for (int i = start; i < N + 1; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	public static int comb_s(int n, int r) {
		if (r == 1) return n;
		if ((n - r) == 1) return n;
		return comb_s(n-1, r-1) + comb_s(n-1, r);
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        int[][] field = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
        	String s = br.readLine();
        	st = new StringTokenizer(s, " ");
        	for (int j = 1; j < N+1; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        numbers = new int[N/2];
        int iter_range = comb_s(N, N/2);
        team = new int[iter_range][N/2];
        ind_cnt = 0;
        comb(0, 1);
        int min_balance = Integer.MAX_VALUE;
        for (int i = 0; i < iter_range / 2; i++) {
        	int tmp_teamstart = 0;
        	int tmp_teamlink = 0;
        	for (int j = 0; j < N/2; j++) {
				for (int k = 0; k < N/2; k++) {
					if (j == k) continue;
					tmp_teamstart += field[team[i][j]][team[i][k]];
					tmp_teamlink += field[team[iter_range-i-1][j]][team[iter_range-i-1][k]];
				}
			}
			if (Math.abs(tmp_teamlink - tmp_teamstart) < min_balance)
				min_balance = Math.abs(tmp_teamlink - tmp_teamstart); 
		}
        bw.write(min_balance + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}