import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int A, B, C;
	static int[] origin_bucket;
	static TreeSet<Integer> set = new TreeSet<>();
	static HashSet<String> check = new HashSet<>();
	private static void dfs(int[] bucket) {
		if(bucket[0] == 0) {
			set.add(bucket[2]);
		}
		if(check.contains(Arrays.toString(bucket))) return;
		check.add(Arrays.toString(bucket));
		for (int i = 0; i < 3; i++) { // 붓는 통
			for (int j = 0; j < 3; j++) { // 담을 통
				if(i == j) continue;
				if(bucket[i] == 0 || bucket[j] == origin_bucket[j]) continue;
				int[] tmp_bucket = new int[3];
				tmp_bucket[0] = bucket[0]; tmp_bucket[1] = bucket[1]; tmp_bucket[2] = bucket[2];
				if(tmp_bucket[i] > (origin_bucket[j] - tmp_bucket[j])) { // 
					// 부어야 하는 양이 들어갈 수 있는 양보다 많으면
					tmp_bucket[i] = tmp_bucket[i] - (origin_bucket[j] - tmp_bucket[j]);
					tmp_bucket[j] = origin_bucket[j];
					dfs(tmp_bucket);
				}
				else if(tmp_bucket[i] <= (origin_bucket[j] - tmp_bucket[j])) {
					// 부어야 하는 양이 들어갈 수 있는 양보다 적거나 같다
					// 있는거 다 부어야함
					tmp_bucket[j] = tmp_bucket[j] + tmp_bucket[i];
					tmp_bucket[i] = 0;
					dfs(tmp_bucket);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    int[] bucket = {0, 0, C};
	    origin_bucket = new int[3];
	    origin_bucket[0] = A; origin_bucket[1] = B; origin_bucket[2] = C;
	    dfs(bucket);
	    for (int i : set) {
			bw.write(i + " ");
		}
//	    bw.write(set.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}