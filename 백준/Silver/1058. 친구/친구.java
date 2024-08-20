import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		char[][] friends = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				friends[i][j] = s.charAt(j);
			}
		}
		/// input end ///
		int[] twoFriends = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(friends[i][j] == 'Y') {
					twoFriends[i]++;
					continue;
				}
				/// 아래부터 N ///
				for (int k = 0; k < N; k++) {
					if(k == i || k == j) continue;
					if(friends[k][i] == 'Y' && friends[k][j] == 'Y') {
						twoFriends[i]++;
						break;
					}
				}
			}
		}
		Arrays.sort(twoFriends);
		bw.write(twoFriends[N-1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}