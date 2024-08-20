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
	    
	    int N = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int[] buildings = new int[N+1];
	    for (int i = 1; i < N+1; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
	    if(N == 1) {
	    	bw.write("0"); bw.flush(); bw.close(); br.close(); return;
	    }
	    if(N == 2) {
	    	bw.write("1"); bw.flush(); bw.close(); br.close(); return;
	    }
	    if(N == 3) {
	    	bw.write("2"); bw.flush(); bw.close(); br.close(); return;
	    }
	    /// input end ///
	    int maxRes = 0;
	    for (int i = 1; i < N+1; i++) { // 현재 빌딩
	    	int sees = 2;
	    	if(i == 1 || i == N) sees = 1;
			for (int j = 1; j < N+1; j++) { // 목표 빌딩
				if(i == j || i - j == 1 || j - i == 1) continue;
				boolean swc = false;
				int x1 = i, y1 = buildings[i];
				int x2 = j, y2 = buildings[j];
				double a = 0;
				if((x1 != x2)) a = (double)(y2-y1) / (double)(x2-x1);
				int x = 0;
				double b = y1 - a * x1;
				double y = a * x + b;
				// 사이 빌딩
				for (int k = i + 1; k <= j - 1; k++) {
					int height = buildings[k];
					y = a * k + b;
					if(y <= height) {
						swc = true;
						break;	
					}
				}
				for (int k = j + 1; k <= i - 1; k++) {
					int height = buildings[k];
					y = a * k + b;
					if(y <= height) {
						swc = true;
						break;	
					}
				}
				if(!swc) sees++;
			}
			maxRes = Math.max(maxRes, sees);
		}
	    sb.append(maxRes);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
