import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean np(int[] p) {
		int N = p.length;
		
		int x = N-1;
		while(x > 0 && p[x-1] >= p[x]) x--;
		if (x == 0) return false;
		
		int y = N-1;
		while(p[x-1] >= p[y]) y--;
		
		int tmp = p[x-1];
		p[x-1] = p[y];
		p[y] = tmp;
		
		int z = N-1;
		while(x < z) {
			tmp = p[x];
			p[x++] = p[z];
			p[z--] = tmp;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] rounds = new int[N+1][10]; // 이닝 별로 각 선수가 치는거임
		for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 1; j < 10; j++) {
				rounds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] playerArr = {2, 3, 4, 5, 6, 7, 8, 9};
		int maxScore = 0;
		int cnt = 0;
		do { // 타순 새로 만들기
			cnt++;
			///
//			System.out.println(cnt + "번째 타순 -----");
			///
			Queue<Integer> batting_turn = new ArrayDeque<>();
			int score = 0;
			for (int i = 0; i < 8; i++) { // 타순에 차라락 들어가자
				batting_turn.offer(playerArr[i]);
				if (i == 2) batting_turn.offer(1); // 1번은 4번타자 시키자
			}
			///
//			System.out.println("타순 잘드갔나 " + batting_turn.toString());
			///
			for (int i = 1; i < N+1; i++) { // 1회부터 드가자
				///
//				System.out.println(i + "회 시작이요 -----");
//				System.out.println("이번 이닝 타순이요");
//				System.out.println(batting_turn.toString());
				///
				int outCnt = 0; // 3아웃되면 컷
				int[] base = new int[4]; // 1루 2루 3루
				while(outCnt < 3) { // 3아웃 -> 컷
//					Thread.sleep(1000);
					///s
//					System.out.println(outCnt + "아웃이고 " + Arrays.toString(base) + " 베이스 상태요 ");
//					System.out.println(score + " 점수요");
					///
					int cur_taja = batting_turn.poll(); // 타자 나와라
					int bat_type = rounds[i][cur_taja]; // 타자가 뭘쳤는데
					///
//					System.out.println(bat_type + " 이거 쳤습니다\n");
//					System.out.println();
					///
					if (bat_type == 0) outCnt++; // 너는 아웃
					else if (bat_type == 4) { // 너는 홈런
						score++; // 타자도 흠으로 와야지
						for (int j = 1; j < 4; j++) {
							if (base[j] != 0) score++;
							base[j] = 0; // 베이스 정리해야지
						}
					}
					///// 1루타 2루타 3루타 /////
					else if (bat_type == 1) { // 1루타
						if (base[3] != 0) score++;
						base[3] = base[2]; base[2] = base[1];
						base[1] = 1;
					}
					else if (bat_type == 2) { // 2루타
						if(base[3] != 0) score++;
						if(base[2] != 0) score++;
						base[3] = base[1];
						base[2] = 1;
						base[1] = 0;
					}
					else if (bat_type == 3) { // 3루타
						if(base[3] != 0) score++;
						if(base[2] != 0) score++;
						if(base[1] != 0) score++;
						base[3] = 1;
						base[2] = 0;
						base[1] = 0;
					}
					batting_turn.offer(cur_taja); // 타자 드가라
				}
			}
			maxScore = Math.max(maxScore, score);
		} while(np(playerArr));
		bw.write(maxScore + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}