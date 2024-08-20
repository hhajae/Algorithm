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
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int ind = 0;
		int res = 0;
		outer: for (int i = 1; i < Integer.MAX_VALUE; i++) {
			sb.append(i);
			String tmpStr = sb.toString();
			for (int j = 0; j < tmpStr.length(); j++) {
				if(s.charAt(ind) == tmpStr.charAt(j)) {
					ind++;
					if(ind == s.length()) {
						res = i;
						break outer;
					}
					continue;
				}
			}
			sb = new StringBuilder();
		}
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
