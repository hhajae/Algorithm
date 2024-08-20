import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int MX = 6000001;
	public static char[] dat = new char[MX];
	public static int[] pre = new int[MX];
	public static int[] nxt = new int[MX];
	public static int unused = 1;
	
	
	public static void insert(int addr, char text) {
		dat[unused] = text;
		pre[unused] = addr;
		nxt[unused] = nxt[addr];
		if (nxt[addr] != -1 ) pre[nxt[addr]] = unused;
		nxt[addr] = unused;
		unused++;
	}
	
	public static void erase(int addr) {
		nxt[pre[addr]] = nxt[addr];
		if (nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
	}
	
	public static String traverse() throws IOException {
		StringBuilder dat_s = new StringBuilder();
		int cur = nxt[0];
		while(cur != -1) {
			dat_s.append(dat[cur]);
			cur = nxt[cur];
		}
		return dat_s.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		for (int i = 0; i < MX; i++) {
			dat[i] = '0';
			pre[i] = -1;
			nxt[i] = -1;
		}
		String s = br.readLine();
		int M = Integer.parseInt(br.readLine());
		int cur = s.length();
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			insert(i, s.charAt(i));
		}
		
		for (int i = 0; i < M; i++) {
			String Command = br.readLine();
			if (Command.equals("L")) {
				if (pre[cur] != -1) {
					cur = pre[cur];
				}
			}
			
			else if (Command.equals("D")) {
				if (nxt[cur] != -1) {
					cur = nxt[cur];
				}
			}
			
			else if (Command.equals("B")) {
				if (dat[cur] != '0') {
				int tmp = pre[cur];
				erase(cur);
				cur = tmp;
				}
			}
			
			else { // P
				st = new StringTokenizer(Command, " ");
				char n_txt = st.nextToken().charAt(0);
				n_txt = st.nextToken().charAt(0);
				
				insert(cur, n_txt);
				cur = nxt[cur];
			}
			
		}
		res = traverse();
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}