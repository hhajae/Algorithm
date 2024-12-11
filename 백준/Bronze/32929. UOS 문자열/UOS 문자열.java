import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		if(N % 3 == 2) {
			sb.append("O");
		} else if (N % 3 == 0) {
			sb.append("S");
		} else if (N % 3 == 1) {
			sb.append("U");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
