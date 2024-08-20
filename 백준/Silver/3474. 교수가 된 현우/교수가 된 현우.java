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
	    
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long cntOf5 = 0; // 5 개수 세는 변수
			long tmp = 5; // N보다 작은 5의 제곱수? 만들기
			while(tmp <= N) {
				cntOf5 += N / tmp; // 5 개수 세기
				tmp *= 5;
			}
			sb.append(cntOf5).append("\n");
		}
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}