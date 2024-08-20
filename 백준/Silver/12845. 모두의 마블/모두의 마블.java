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
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int[] cards = new int[N];
	    int maxCard = 0;
	    int maxCardInd = 0;
	    for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			if(maxCard < cards[i]) {
				maxCard = cards[i];
				maxCardInd = i;
			}
		}
	    /// input end ///
	    int sum = 0;
	    for (int i = maxCardInd - 1; i >= 0; i--) {
	    	sum += maxCard + cards[i];
	    			
	    }
	    for(int i = maxCardInd + 1; i < N; i++) {
	    	sum += maxCard + cards[i];
	    }
	    sb.append(sum);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
