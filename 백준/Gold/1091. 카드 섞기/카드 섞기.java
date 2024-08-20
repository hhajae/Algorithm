import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] S;
	static int[] P;
	static int[] cardSet;
	static int[] tmpSet;
	private static void shuffle() {
		int[] newCards = new int[N];
		for (int i = 0; i < N; i++) {
			newCards[S[i]] = cardSet[i];
		}
		cardSet = newCards;
//		for (int i = 0; i < N; i++) {
//			tmpSet[S[i]] = cardSet[i];
//		}
//		cardSet = tmpSet;
	}
	private static boolean check() {
		outer: for (int i = 0; i < N; i++) { // i번째 카드가
			int n = P[i]; // 0 1 2 0 1 2
			for (int j = n; j < N; j+=3) {
				if(cardSet[j] == i) continue outer;
			}
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    N = Integer.parseInt(br.readLine());
	    P = new int[N];
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
	    S = new int[N];
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
	    /// input end ///
	    cardSet = new int[N];
	    tmpSet = new int[N];
	    for (int i = 0; i < N; i++) {
			cardSet[i] = i;
		}
	   if(check()) {
		   System.out.println("0"); return;
	   }
	   
	   int cnt = 0;
	    while(true) {
	    	if(cnt > 1000000) break;
	    	shuffle();
	    	cnt++;
	    	if(check()) break;
	    }
	    if(cnt > 1000000) sb.append("-1");
	    else sb.append(cnt);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
