import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			/// 자료구조 준비 ///
			PriorityQueue<Integer> Minpq = new PriorityQueue<>();
			PriorityQueue<Integer> Maxpq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			Map<Integer, Integer> map = new TreeMap<>();
			int cnt = 0;
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				String s = br.readLine();
				st = new StringTokenizer(s, " ");
				String command = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(command.equals("I")) {
					Minpq.offer(n); Maxpq.offer(n);
					cnt++;
					if(map.containsKey(n)) map.replace(n, map.get(n) + 1);
					else map.put(n, 1);
				}
				else if(command.equals("D")) {
					if(cnt == 0) continue;
					if(n == 1) {
						int val = Integer.MAX_VALUE;
						while(true) {
							val = Maxpq.poll();
							if(!map.containsKey(val)) continue;
							if(map.get(val) == 0) continue;
							break;
						}
						cnt--;
						if(map.get(val) == 1) {
							map.remove(val);
							continue;
						}
						map.replace(val, map.get(val) - 1);
					}
					else if(n == -1) {
						int val = Integer.MAX_VALUE;
						while(true) {
							val = Minpq.poll();
							if(!map.containsKey(val)) continue;
							if(map.get(val) == 0) continue;
							break;
						}
						cnt--;
						if(map.get(val) == 1) {
							map.remove(val);
							continue;
						}
						map.replace(val, map.get(val) - 1);
					}
				}
			}
			if(cnt == 0) {
				sb.append("EMPTY\n");
				continue;
			}
			if(cnt == 1) {
				int resval = Integer.MAX_VALUE;
				while(true) {
					resval = Minpq.poll();
					if(!map.containsKey(resval)) continue;
					if(map.get(resval) == 0) continue;
					break;
				}
				sb.append(resval).append(" ").append(resval).append("\n");
				continue;
			}
			int maxVal = Integer.MAX_VALUE;
			int minVal = Integer.MAX_VALUE;
			while(true) {
				maxVal = Maxpq.poll();
				if(!map.containsKey(maxVal)) continue;
				if(map.get(maxVal) == 0) continue;
				break;
			}
			while(true) {
				minVal = Minpq.poll();
				if(!map.containsKey(minVal)) continue;
				if(map.get(minVal) == 0) continue;
				break;
			}
			sb.append(maxVal).append(" ").append(minVal).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
