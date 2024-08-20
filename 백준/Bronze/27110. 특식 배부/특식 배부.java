import java.io.*;
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
		int cnt = 0;
		int a = Integer.parseInt(st.nextToken());
		if (a <= N) cnt += a;
		else cnt += N;
		int b = Integer.parseInt(st.nextToken());
		if (b <= N) cnt += b;
		else cnt += N;
		int c = Integer.parseInt(st.nextToken());
		if (c <= N) cnt += c;
		else cnt += N;
		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
