import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, res_cnt;
	private static void find_RC(int N, int start_x, int start_y, int cur_cnt) {
		if (N == 1) {
			if (r == start_x && c == start_y) {
				res_cnt = cur_cnt + 3;
			}
			else if (r == start_x && c != start_y) {
				res_cnt = cur_cnt + 2;
			}
			else if (r != start_x && c == start_y) {
				res_cnt = cur_cnt + 1;
			}
			else if (r != start_x && c != start_y) {
				res_cnt = cur_cnt;
			}
			System.out.println(res_cnt + "\n");
			return;
		}
		int divided = (int)Math.pow(2, N-1) / 2; 
		if (r < start_x && c < start_y) {
			find_RC(N-1, start_x - divided, start_y - divided, cur_cnt);
		}
		else if (r < start_x && c >= start_y) {
			find_RC(N-1, start_x - divided, start_y + divided, cur_cnt + (int)Math.pow(2, N) * (int)Math.pow(2, N-2));
		}
		else if (r >= start_x && c < start_y) {
			find_RC(N-1, start_x + divided, start_y - divided, cur_cnt + (int)Math.pow(2, N) * (int)Math.pow(2, N-2) * 2);
		}
		else if (r >= start_x && c >= start_y) {
			find_RC(N-1, start_x + divided, start_y + divided, cur_cnt + (int)Math.pow(2, N) * (int)Math.pow(2, N-2) * 3);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		res_cnt = 0;
		find_RC(N, (int)Math.pow(2, N)/2, (int)Math.pow(2, N)/2, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}
}