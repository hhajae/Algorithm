import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] scores = new int[N][2];
	    for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int team = Integer.parseInt(st.nextToken());
			String gainScoreTime = st.nextToken();
			st = new StringTokenizer(gainScoreTime, ":");
			int minute = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			scores[i][0] = team; scores[i][1] = minute * 60 + second;
		}
	    /// input end ///
	    Arrays.sort(scores, (o1, o2) -> {
	    	return o1[1] - o2[1];
	    });
	    int[] teamScores = new int[3];
	    int[] winTime = new int[3];
	    int ind = 0;
	    for (int i = 0; i < 2880; i++) {
			int curTeam = scores[ind][0];
			int time = scores[ind][1];
			if(i == time) {
				teamScores[curTeam]++;
				ind++;
				if(ind == N) {
					ind = 0;
					scores[ind][1] = -1;
				}
			}
			if(teamScores[1] > teamScores[2]) {
				winTime[1]++;
			}
			else if(teamScores[2] > teamScores[1]) {
				winTime[2]++;
			}
		}
	    StringBuilder sb = new StringBuilder();
	    if(winTime[1]/60 < 10) sb.append(0);
	    sb.append(winTime[1]/60).append(":");
	    if(winTime[1]%60 < 10) sb.append(0);
	    sb.append(winTime[1]%60).append("\n");
	    if(winTime[2]/60 < 10) sb.append(0);
	    sb.append(winTime[2]/60).append(":");
	    if(winTime[2]%60 < 10) sb.append(0);
	    sb.append(winTime[2]%60);
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
