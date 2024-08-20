import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static boolean isFlat(int[] road) {
		for (int i = 1; i < road.length; i++) {
			if(road[i] != road[i-1]) return false;
		}
		return true;
	}
	private static boolean isRoad(int[] road, int L) {
		// 높이가 2이상 차이가 나냐
		for (int i = 1; i < road.length; i++) {
			int tmpH = Math.abs(road[i] - road[i-1]);
			if (tmpH > 1) return false;
		}
		
		// 경사로 놓을 수 있냐 없냐
		boolean[] isCurved = new boolean[road.length];
		for (int i = 0; i < road.length - 1; i++) {
			if (road[i] == road[i+1]) continue;
			int curveCnt = 1;
			if (road[i] > road[i+1]) { // 높고 낮다
				for (int pos = i+1; pos < road.length; pos++) {
					if(road[i+1] != road[pos]) return false;
					if(isCurved[pos]) return false;
					if(curveCnt == L) {
						for (int j = i+1; j < (i+1) + L; j++) {
							isCurved[j] = true;
						}
						break;
					}
					if (pos != road.length-1) curveCnt++;
				}
			}
			else { // 낮고 높다
				for (int pos = i; pos >= 0; pos--) {
					if(road[i] != road[pos]) return false;
					if(isCurved[pos]) return false;
					if(curveCnt == L) {
						for (int j = i; j > (i+1) - L; j--) {
							isCurved[j] = true;
						}
						break;
					}
					if(pos != 0) curveCnt++;
				}
			}
			if(curveCnt != L) return false;
			
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		
		int resCnt = 0;
		int[] rowMap = new int[N];
		int[] colMap = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rowMap[j] = map[i][j];
				colMap[j] = map[j][i];				
			}
			boolean rowSwc = false, colSwc = false;
			if(isFlat(rowMap)) {rowSwc = true; resCnt++;}
			if(isFlat(colMap)) {colSwc = true; resCnt++;}
			/// row ///
			if(!rowSwc) {
				if(isRoad(rowMap, L)) resCnt++;
			}
			
			/// col ///
			if(!colSwc) {
				if(isRoad(colMap, L)) resCnt++;
			}
		}
		bw.write(resCnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}