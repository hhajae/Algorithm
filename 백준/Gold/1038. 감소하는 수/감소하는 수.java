import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int globalCnt = 0;
	private static void dfs(int cnt, int maxInd, long num) {
	    if (cnt == maxInd) {
    		if(globalCnt == N) {
    			System.out.println(num);	
    			System.exit(0);
    		}
    		globalCnt++;
	    	return;
	    }
	    int maxPosNum = (int)(num % 10) - 1;
	    if(num == 0) maxPosNum = 9; 
	    for (int i = 0; i <= maxPosNum; i++) {
	        long tmp = (num * 10) + i;
	        dfs(cnt+1, maxInd, tmp);
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		if(N > 1022) {
			bw.write("-1");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		dfs(0, 10, 0L);
		
		bw.flush();
		bw.close();
		br.close();
	}
}