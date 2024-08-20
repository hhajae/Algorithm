import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class group {
	int size;
	int candy;
	public group(int size, int candy) {
		super();
		this.size = size;
		this.candy = candy;
	}
	@Override
	public String toString() {
		return "group [size=" + size + ", candy=" + candy + "]";
	}
}
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] candys = new int[N+1];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 1; i < N+1; i++) {
			candys[i] = Integer.parseInt(st.nextToken());
		}
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
        for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to);
		}
        for (int i = 1; i < N+1; i++) {
			int tmp = find(i);
		}
        group[] groups = new group[N+1];
        for (int i = 1; i < N+1; i++) {
        	if(groups[parents[i]] == null) {
        		groups[parents[i]] = new group(1, candys[i]);
        		continue;
        	}
        	groups[parents[i]].size++;
        	groups[parents[i]].candy += candys[i];
        }
//        System.out.println(Arrays.toString(parents));
        List<group> lst = new ArrayList<>();
        lst.add(new group(0,0));
        for (int i = 1; i < N+1; i++) {
        	if(groups[i] == null) continue;
        	if(groups[i].size >= K) continue;
        	lst.add(groups[i]);
        }
//        System.out.println(lst.toString());
        int lstSize = lst.size();
        int[][] D = new int[lstSize+1][K];
        for (int i = 1; i < lstSize; i++) {
			for (int j = 1; j < K; j++) {
				if(lst.get(i).size > j) D[i][j] = D[i-1][j];
				else D[i][j] = Math.max(lst.get(i).candy + D[i-1][j - lst.get(i).size],
						D[i-1][j]);
			}
		}
        sb.append(D[lstSize-1][K-1]);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
