import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		sb.append(3 * (B/A) * C);

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
