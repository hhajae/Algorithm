import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		outer: for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int N = Integer.parseInt(s);
			StringBuilder reverseSb = new StringBuilder();
			reverseSb.append(s);
			String reverse = reverseSb.reverse().toString();
			int M = Integer.parseInt(reverse);
			int sum = N + M;
			String sumStr = Integer.toString(sum);
			for(int j = 0; j < sumStr.length() / 2; j++) {
				if(sumStr.charAt(j) != sumStr.charAt(sumStr.length() - j - 1)) {
					sb.append("NO\n");
					continue outer;
				}
			}
			sb.append("YES\n");
		}	

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
