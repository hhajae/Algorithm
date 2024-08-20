import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int[] names = new int[26];
        for (int i = 0; i < s.length(); i++) {
			names[s.charAt(i) - 'A']++;
		}
        if(s.length() % 2 == 0) {
        	for (int i = 0; i < 26; i++) {
				if(names[i] == 0) continue;
				if(names[i] % 2 == 1) {
					bw.write("I'm Sorry Hansoo"); bw.flush(); bw.close(); br.close(); return;
				}
				for (int j = 0; j < names[i]/2; j++) {
					sb.append((char)(i + 'A'));
				}
			}
        	String front = sb.toString();
        	front += sb.reverse();
        	bw.write(front);
        } else { // odd length
        	char center = 'a';
        	for (int i = 0; i < 26; i++) {
				if(names[i] == 0) continue;
				if(names[i] % 2 == 1) {
					if(center != 'a') {
						bw.write("I'm Sorry Hansoo"); bw.flush(); bw.close(); br.close(); return;
					}
					center = (char)(i+'A');
					if(names[i] > 1) {
						for (int j = 0; j < names[i]/2; j++) {
							sb.append((char)(i + 'A'));
						}
					}
					continue;
				}
				for (int j = 0; j < names[i]/2; j++) {
					sb.append((char)(i + 'A'));
				}
			}
        	String front = sb.toString();
        	front += center;
        	front += sb.reverse();
        	bw.write(front);
        }
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}
