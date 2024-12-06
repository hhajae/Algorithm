import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String s1 = br.readLine();
		String s2 = br.readLine();
		if("S".equals(s)) {
			if(".O".equals(s1) && "P.".equals(s2)) {
				sb.append("T");
			} else if("I.".equals(s1) && ".P".equals(s2)) {
				sb.append("F");
			} else if("O.".equals(s1) && ".P".equals(s2)) {
				sb.append("Lz");
			} else {
				sb.append("?");
			}
		} else if("W".equals(s)) {
			if("P.".equals(s1) && ".O".equals(s2)) {
				sb.append("T");
			} else if(".I".equals(s1) && "P.".equals(s2)) {
				sb.append("F");
			} else if(".O".equals(s1) && "P.".equals(s2)) {
				sb.append("Lz");
			} else {
				sb.append("?");
			}
		} else if("N".equals(s)) {
			if(".P".equals(s1) && "O.".equals(s2)) {
				sb.append("T");
			} else if("P.".equals(s1) && ".I".equals(s2)) {
				sb.append("F");
			} else if("P.".equals(s1) && ".O".equals(s2)) {
				sb.append("Lz");
			} else {
				sb.append("?");
			}
		} else if("E".equals(s)) {
			if("O.".equals(s1) && ".P".equals(s2)) {
				sb.append("T");
			} else if(".P".equals(s1) && "I.".equals(s2)) {
				sb.append("F");
			} else if(".P".equals(s1) && "O.".equals(s2)) {
				sb.append("Lz");
			} else {
				sb.append("?");
			}
		}


		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
