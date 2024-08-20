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
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (M > N) {
				int[] arr = new int[N];
				int start = x;
				arr[0] = x;
				for (int j = 1; j < N; j++) {
					start += M;
					arr[j] = start;
				}
				boolean swc = false;
				for (int j = 0; j < N; j++) {
					int tmp = arr[j] % N;
					if(tmp == 0) tmp = N;
					if(tmp == y) {
						sb.append(arr[j]).append("\n");
						swc = true;
						break;
					}
				}
				if(!swc) sb.append("-1\n");
			}
			else {
				int[] arr = new int[M];
				int start = y;
				arr[0] = y;
				for (int j = 1; j < M; j++) {
					start += N;
					arr[j] = start;
				}
				boolean swc = false;
				for (int j = 0; j < M; j++) {
					int tmp = arr[j] % M;
					if(tmp == 0) tmp = M;
					if(tmp == x) {
						sb.append(arr[j]).append("\n");
						swc = true;
						break;
					}
				}
				if(!swc) sb.append("-1\n");
			}
		}
        bw.write(sb.toString());
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}