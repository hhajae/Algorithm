import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int week = 6;
		for (int i = 11; i <= N; i++) {
			week = week * i;
		}
		sb.append(week);

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
