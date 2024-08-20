import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int find_candy(char[][] candy) {
		int max_candy = 0;
		int len_candy = candy.length;
		int cnt = 1;
		
		/// row ///
		for (int i = 0; i < len_candy; i++) {
			cnt = 1;
			for (int j = 0; j < len_candy-1; j++) {
				if (candy[i][j] == candy[i][j+1]) {
					cnt++;
					if (cnt > max_candy)
						max_candy = cnt;
				}
				else {
					cnt = 1;
				}
			}
		}
		
		/// column ///
		for (int i = 0; i < len_candy; i++) {
			cnt = 1;
			for (int j = 0; j < len_candy-1; j++) {
				if (candy[j][i] == candy[j+1][i]) {
					cnt++;
					if (cnt > max_candy)
						max_candy = cnt;
				}
				else {
					cnt = 1;
				}
			}
		}
		
		return max_candy;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int max = -1, n = 1;
		char[][] candy = new char[N][N];
		char tmp;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				candy[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				/// north ///
				if ((i - 1 >= 0) && (candy[i][j] != candy[i-1][j])) {
					tmp = candy[i][j];
					candy[i][j] = candy[i-1][j];
					candy[i-1][j] = tmp;
					n = find_candy(candy);
					tmp = candy[i][j];
					candy[i][j] = candy[i-1][j];
					candy[i-1][j] = tmp;
				}
				if (n > max)
					max = n;
					
				/// south ///
				if ((i + 1 < N) && (candy[i][j] != candy[i+1][j])) { // 
					tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
					n = find_candy(candy);
					tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
				}
				if (n > max)
					max = n;
				
				/// east ///
				if ((j + 1 < N) && (candy[i][j] != candy[i][j+1])) { // 
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
					n = find_candy(candy);
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
				}
				if (n > max)
					max = n;
				
				/// west ///
				if ((j - 1 >= 0) && (candy[i][j] != candy[i][j-1])) { // 
					tmp = candy[i][j];
					candy[i][j] = candy[i][j-1];
					candy[i][j-1] = tmp;
					n = find_candy(candy);
					tmp = candy[i][j];
					candy[i][j] = candy[i][j-1];
					candy[i][j-1] = tmp;
				}
				if (n > max)
					max = n;	
			}
		}
		bw.write(max + "\n");
			
		bw.flush();
		bw.close();
		br.close();
	}
}
