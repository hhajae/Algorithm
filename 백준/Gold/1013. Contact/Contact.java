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
		StringBuilder sb = new StringBuilder();
		
		// (100+1+ | 01)+
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			int ind = 0;
			while(ind < s.length()) {
				if(s.charAt(ind) == '1') {
					if(ind + 3 >= s.length() || s.charAt(ind + 1) == '1' || s.charAt(ind + 2) == '1') {
						sb.append("NO\n");
						break;
					} 
					boolean hasLast = false;
					int lastInd = -1;
					for (int i = ind+1; i < s.length(); i++) { // 100000~
						if(s.charAt(i) == '1') {
							hasLast = true;
							lastInd = i;
							break;
						}
					}
					
					if(!hasLast) { // 1000000~~
						sb.append("NO\n");
						break;
					}
					if(lastInd == s.length() - 1) { // 100~~1
						sb.append("YES\n");
						break;
					}
					if(s.charAt(lastInd + 1) == '0') { // 10010~
						ind = lastInd + 1;
						continue;
					}
					boolean endofOne = true;
					int oneEndInd = -1;
					for (int i = lastInd + 1; i < s.length(); i++) { // 10011111.
						if(s.charAt(i) == '0') {
							endofOne = false;
							oneEndInd = i - 1;
							break;
						}
					}
					if(endofOne) { // 100111111.
						sb.append("YES\n");
						break;
					}
					if(s.charAt(oneEndInd + 1) == '0' && s.charAt(oneEndInd + 2) == '0') {
						ind = oneEndInd;
						continue;
					}
					if(s.charAt(oneEndInd + 1) == '0' && s.charAt(oneEndInd + 2) == '1') {
						ind = oneEndInd + 1;
						continue;
					}
				}
				else if(s.charAt(ind) == '0') {
					if(ind == s.length() - 1 || s.charAt(ind + 1) == '0') {
						sb.append("NO\n");
						break;
					}
					if(ind + 1 >= s.length()) {
						sb.append("NO\n");
						break;
					}
					if(ind + 1 == s.length() - 1) {
						sb.append("YES\n");
						break;
					}
					ind += 2;
					continue;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
