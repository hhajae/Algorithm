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
        int[] Tshirts = new int[6];
        for (int i = 0; i < 6; i++) {
			Tshirts[i] = Integer.parseInt(st.nextToken());
		}
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans1 = 0;
        int ans2 = N % P;
        for (int i = 0; i < 6; i++) {
			if(Tshirts[i] % T == 0) {
				ans1 += Tshirts[i] / T;
			}
			else {
				ans1 += Tshirts[i] / T + 1;
			}
		}
        sb.append(ans1).append("\n");
        sb.append(N/P).append(" ").append(ans2);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
