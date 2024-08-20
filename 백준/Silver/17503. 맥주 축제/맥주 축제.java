import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		HashMap<Long, List<Integer>> degree = new HashMap<>();
		for (int i = 0; i < K; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int p = Integer.parseInt(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			if (degree.containsKey(d)) { // 이미 도수레벨이 나온거면
				degree.get(d).add(p);
			}
			else {
				degree.put(d, new ArrayList<Integer>());
				degree.get(d).add(p);
			}
		}
		PriorityQueue<Integer> prefer = new PriorityQueue<>();
		Set<Long> key_set = new TreeSet<>();
		key_set = degree.keySet();
		List<Long> sortedList = new ArrayList<>(key_set);

		Collections.sort(sortedList);
//		bw.write(degree.toString() + "\n");

//		bw.write(key_set.toString() + "\n");
		long prefer_sum = 0;
		for (Long d : sortedList) {
			List<Integer> tmp_prefer = degree.get(d);
			for (int i = 0; i < tmp_prefer.size(); i++) {
				prefer.add(tmp_prefer.get(i));
				prefer_sum += tmp_prefer.get(i);
				if (prefer.size() > N) {
					prefer_sum -= prefer.poll();
				}
				if (prefer.size() == N && prefer_sum >= M) {
					bw.write(d + "\n");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
			}
		}
		bw.write("-1\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}