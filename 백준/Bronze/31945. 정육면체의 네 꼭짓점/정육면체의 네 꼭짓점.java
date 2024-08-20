import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    List<Set<Integer>> lst = new ArrayList<Set<Integer>>();
	    for (int i = 0; i < 6; i++) {
	    	lst.add(new HashSet<Integer>());
		}
	    lst.get(0).add(0); lst.get(0).add(1); lst.get(0).add(4); lst.get(0).add(5);
	    lst.get(1).add(0); lst.get(1).add(1); lst.get(1).add(2); lst.get(1).add(3);
	    lst.get(2).add(6); lst.get(2).add(7); lst.get(2).add(4); lst.get(2).add(5);
	    lst.get(3).add(2); lst.get(3).add(3); lst.get(3).add(6); lst.get(3).add(7);
	    lst.get(4).add(3); lst.get(4).add(1); lst.get(4).add(7); lst.get(4).add(5);
	    lst.get(5).add(0); lst.get(5).add(2); lst.get(5).add(4); lst.get(5).add(6);
	    int T = Integer.parseInt(br.readLine());
	    outer: for (int i = 0; i < T; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 6; j++) {
				Set<Integer> tmpSet = lst.get(j);
				if(tmpSet.contains(a) && tmpSet.contains(b)
						&& tmpSet.contains(c) && tmpSet.contains(d)) {
					sb.append("YES\n");
					continue outer;
				}
			}
			sb.append("NO\n");
		}
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
