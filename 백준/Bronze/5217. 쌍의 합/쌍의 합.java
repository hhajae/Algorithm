import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("Pairs for ").append(N).append(": ");
			boolean firstSwc = true;
			for (int i = 1; i < N - 1; i++) {
				for (int j = i+1; j < N; j++) {
					if(i + j == N) {
						if(firstSwc) {
							sb.append(i).append(" ").append(j);
							firstSwc = false;
						} else {
							sb.append(", ").append(i).append(" ").append(j);
						}

					}
				}
			}
			sb.append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
