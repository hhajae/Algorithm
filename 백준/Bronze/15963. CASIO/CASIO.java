import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		st = new StringTokenizer(s);
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		if(s1.equals(s2)) {
			sb.append("1");
		} else {
			sb.append("0");
		}

        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
