import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        s = br.readLine();
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
        int firstKnowTruthPerson = -1;
        int p = 0;
        if(!s.equals("0") ) {
        	st = new StringTokenizer(s, " ");
        	p = Integer.parseInt(st.nextToken());
        	for (int i = 0; i < p; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(firstKnowTruthPerson == -1) {
					firstKnowTruthPerson = n;
					continue;
				}
				union(firstKnowTruthPerson, n);
			}
        }
        List[] parties = new List[M];
        for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int n = Integer.parseInt(st.nextToken());
			parties[i] = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				parties[i].add(Integer.parseInt(st.nextToken()));
			}
		}
        if(p == 0) {
        	bw.write(M + "\n"); bw.flush(); bw.close(); br.close(); return;
        }
        for (int iter = 0; iter < M; iter++) {
        	for (int i = 0; i < M; i++) {
        		boolean isKnowtruth = false;
        		for (int j = 0; j < parties[i].size(); j++) {
        			if(find((int)parties[i].get(j)) == firstKnowTruthPerson) {
        				isKnowtruth = true;
        				break;
        			}
        		}
        		if(isKnowtruth) {
        			for (int j = 0; j < parties[i].size(); j++) {
        				union(firstKnowTruthPerson, (int)parties[i].get(j));
        			}
        		}
        	}
        }
        int resCnt = 0;
        outer : for (int i = 0; i < M; i++) {
    		for (int j = 0; j < parties[i].size(); j++) {
    			if(find((int)parties[i].get(j)) == firstKnowTruthPerson) {
    				continue outer;
    			}
    		}
    		resCnt++;
    	}
        sb.append(resCnt);

        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
