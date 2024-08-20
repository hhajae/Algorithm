import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb.append(arr[1]);

        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
