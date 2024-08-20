import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static boolean np(int[] p) {
		final int N = p.length;
		
		// 교환위치 찾기(뒤쪽부터 꼭대기를 찾으면 꼭대기 다음이 교환위치
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) --i;
		
		if (i == 0) return false; // 현재가 가장 큰 상태이므로 np 없음
		
		// 교환위치에 넣을 값 뒤쪽부터 찾기(교환위치값보다 큰 값중 최소값)
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		// 교환위치와 찾은위치 교환
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		// 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) {
			tmp = p[i];
			p[i++] = p[k];
			p[k--] = tmp;
		}
		return true;
	}
	private static int chick_distance(List<Integer> x, List<Integer> y,
			List<Integer> chx, List<Integer> chy) {
		int dis = 0;
		for (int i = 0; i < x.size(); i++) {
			int cur_x = x.get(i);
			int cur_y = y.get(i);
			int mindis = Integer.MAX_VALUE;
			for (int j = 0; j < chx.size(); j++) {
				int nx = chx.get(j);
				int ny = chy.get(j);
				mindis = Math.min(mindis, Math.abs(cur_x-nx) + Math.abs(cur_y-ny));
			}
			dis += mindis;
		}
		return dis;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] city = new int[N+1][N+1];
		List<Integer> hque_x = new ArrayList<>();
		List<Integer> hque_y = new ArrayList<>();
		List<Integer> chick_x = new ArrayList<>();
		List<Integer> chick_y = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 1; j < N+1; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					hque_x.add(i); hque_y.add(j);
				}
				else if (city[i][j] == 2) {
					chick_x.add(i); chick_y.add(j); 
				}
			}
		}
		/// input end ///
		if (M == chick_x.size()) {
			int resDis = chick_distance(hque_x, hque_y, chick_x, chick_y);
			bw.write(resDis + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		/// start ///
		int[] nCr = new int[chick_x.size()];
		for (int i = 0; i < M; i++) {
			nCr[nCr.length-1-i] = 1;
		}
		int minDis = Integer.MAX_VALUE;
		do {
			List<Integer> tmpX = new ArrayList<>();
			List<Integer> tmpY = new ArrayList<>();
			for (int i = 0; i < nCr.length; i++) {
				if (nCr[i] == 1) {
					tmpX.add(chick_x.get(i));
					tmpY.add(chick_y.get(i));
				}
			}
			minDis = Math.min(minDis, chick_distance(hque_x, hque_y, tmpX, tmpY));
		} while (np(nCr));
		bw.write(minDis + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}