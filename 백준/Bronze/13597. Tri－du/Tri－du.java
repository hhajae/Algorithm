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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		sb.append(Math.max(a, b));
		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
