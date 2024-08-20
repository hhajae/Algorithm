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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		
		String L = st.nextToken();
		String R = st.nextToken();
		int resCnt = 0;
		for (int i = 0; i < L.length(); i++) {
			int c1 = L.charAt(i) - '0';
			int c2 = R.charAt(i) - '0';
			if(c1 != c2) break;
			if(c1 == 8 && c2 == 8 && L.length() == R.length()) resCnt++;
		}
		sb.append(resCnt);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
