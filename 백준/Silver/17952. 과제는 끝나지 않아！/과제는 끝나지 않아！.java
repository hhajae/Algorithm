import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> que = new ArrayDeque<>(); // 밀린 일
		HashMap<Integer, Integer> map_score = new HashMap<>(); // 점수 확인
		HashMap<Integer, Integer> map_minute = new HashMap<>(); // 남은 시간
		
		/// 처음 시작 ///
		int scoreSum = 0;
		int startind = 0;
		for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			if (s.length() == 1) continue;
			startind = i+1;
			st = new StringTokenizer(s, " ");
			int score = Integer.parseInt(st.nextToken());
			score = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()) - 1;
			if (m == 0) {
				scoreSum += score;
				break;
			}
			map_score.put(i, score);
			map_minute.put(i, m);
			que.addFirst(i);
			break;
		}
		for (int i = startind; i < N+1; i++) {
//			bw.write("map_score = " + map_score.toString() + "\n");
//			bw.write("map_minute = " + map_minute.toString() + "\n");
//			bw.write("queue = " + que.toString() + "\n");
			String s = br.readLine();
			if (s.length() == 1) { // 0이다 -> 밀린거부터
				if (que.isEmpty()) continue;
				int prework = que.pollFirst();
				int pre_minute = map_minute.get(prework) - 1;
				if (pre_minute == 0) {
					scoreSum += map_score.get(prework);
					map_minute.remove(prework);
					map_score.remove(prework);
					continue;
				}
				else {
					que.addFirst(prework);
					map_minute.replace(prework, pre_minute);
				}
			}
			else {
				st = new StringTokenizer(s, " ");
				int score = Integer.parseInt(st.nextToken());
				score = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken()) - 1; // 받자마자 바로 시작
				if (m == 0) {
					scoreSum += score;
					continue;
				}
				map_score.put(i, score);
				map_minute.put(i, m);
				que.addFirst(i);
			}
		}
		bw.write(scoreSum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}