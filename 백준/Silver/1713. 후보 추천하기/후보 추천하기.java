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
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    int total = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int[] recommend = new int[total];
	    for (int i = 0; i < total; i++) {
			recommend[i] = Integer.parseInt(st.nextToken());
	    }
	    /// input end ///
	    int[][] photos = new int[N][3];
	    int photoSize = 0;
	    outer : for (int i = 0; i < total; i++) {
			int cur = recommend[i];
			// 일단 있는지부터 확인하자
			for (int j = 0; j < N; j++) {
				if(photos[j][0] == cur) {
					photos[j][1]++;
					continue outer;
				}
			}
			// 사진에 없고 사진틀이 비었으면
			if(photoSize < N) {
				for (int j = 0; j < N; j++) {
					if(photos[j][0] != 0) continue;
					photos[j][0] = cur;
					photos[j][1]++;
					photos[j][2] = i;
					photoSize++;
					continue outer;
				}
			}
			// 비어있는 사진틀이 없는경우
			int minRec = Integer.MAX_VALUE;
			int minRecInd = Integer.MAX_VALUE;
			int maxRemain = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if(photos[j][1] == minRec) {
					if(photos[j][2] < maxRemain) {
						minRec = photos[j][1];
						minRecInd = j;
						maxRemain = photos[j][2];
						continue;
					}
				}
				if(photos[j][1] < minRec) {
					minRec = photos[j][1];
					minRecInd = j;
					maxRemain = photos[j][2];
				}
			}
			photos[minRecInd][0] = cur;
			photos[minRecInd][1] = 1;
			photos[minRecInd][2] = i;
		}
	    Arrays.sort(photos, (o1, o2) -> {
	    	return o1[0] - o2[0];
	    });
	    for (int i = 0; i < N; i++) {
			if(photos[i][0] != 0) sb.append(photos[i][0]).append(" ");
		}
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
