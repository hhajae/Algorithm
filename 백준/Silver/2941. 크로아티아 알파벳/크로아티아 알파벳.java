import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = null;
		
		String s = br.readLine();
		String res = "";
		int cnt = 0;
		int swc = 0;
		s += "++";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(swc > 0) {
				swc--;
				continue;	
			}
			///// c /////
			if (c == 'c') {
				if(s.charAt(i+1) == '=') {
					res += "c=";
					cnt++;	swc++;	continue;
				}
				else if(s.charAt(i+1) == '-') {
					res += "c-"; cnt++;	swc++;
					continue;
				}
			}
			///// d /////
			else if (c == 'd') {
				if (s.charAt(i+1) == 'z') {
					if(s.charAt(i+2) == '=') {
						res += "dz=";
						cnt++;	swc+=2;	continue;
					}
				}
				else if (s.charAt(i+1) == '-') {
					res += "d-";
					cnt++;	swc++;	continue;
				}
			}
			///// l /////
			else if (c == 'l') {
				if (s.charAt(i+1) == 'j') {
					res += "lj";
					cnt++;	swc++;	continue;
				}
			}
			///// n /////
			else if (c == 'n') {
				if (s.charAt(i+1) == 'j') {
					res += "nj";
					cnt++;	swc++;	continue;
				}
			}
			///// s /////
			else if (c == 's') {
				if (s.charAt(i+1) == '=') {
					res += "s=";
					cnt++;	swc++;	continue;
				}
			}
			///// z /////
			else if (c == 'z') {
				if (s.charAt(i+1) == '=') {
					res += "z=";
					cnt++;	swc++;	continue;
				}
			}
			if (c == '+') break;
			res += c;
			cnt++;
		}
		res += "++";
		if (res.equals(s)) {
			bw.write(cnt + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
