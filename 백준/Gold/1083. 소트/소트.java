import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    int[] numbers = new int[N];
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	    int S = Integer.parseInt(br.readLine());
	    for (int i = 0; i < N-1; i++) {
			int maxInd = -1;
			int maxNum = numbers[i];
			for (int j = i+1; j < (i+1) + S; j++) {
				if(j >= N) break;
				if(numbers[j] > maxNum) {
					maxNum = numbers[j];
					maxInd = j;
				}
			}
			if(maxNum == numbers[i]) {
				continue;
			}
			S -= maxInd - i;
			for (int j = maxInd; j > i; j--) {
				int tmp = numbers[j];
				numbers[j] = numbers[j-1];
				numbers[j-1] = tmp;
			}
			if(S == 0) break;
		}
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < N; i++) {
			sb.append(numbers[i]).append(" ");
		}
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}