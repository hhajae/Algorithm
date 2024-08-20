import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String time = LocalDate.now().toString();
		st = new StringTokenizer(time, "-");
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken()).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
