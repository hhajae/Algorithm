import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		parents[b] = a;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
        boolean swc = false;
        outer: for (int i = 0; i < m; i++) {
			s = br.readLine();
			if(swc) continue;
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fromsPa = find(from);
			int tosPa = find(to);
			if(fromsPa == tosPa) {
				sb.append(i+1);
				swc = true;
			}
			union(from, to);
        }
        if(sb.toString().length() == 0) {
        	bw.write("0");
        }
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
