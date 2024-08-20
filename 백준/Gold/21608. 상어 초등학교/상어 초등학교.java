import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int Total = N*N;
		int[][] school = new int[N][N];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] Students = new int[Total+1][4];
		int[] stuSeq = new int[Total];
		for (int i = 0; i < Total; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int cur = Integer.parseInt(st.nextToken());
			stuSeq[i] = cur;
			for (int j = 0; j < 4; j++) {
				Students[cur][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		
		/// 자리 잡자 ///
		for (int i = 0; i < Total; i++) {
			int curStudent = stuSeq[i];
			/// 널 좋아해
			int[][] MaxLikeArr = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(school[j][k] != 0) continue; // 자리요
					int cur_x = j, cur_y = k;
					int surroundLikeCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = cur_x + dx[d];
						int ny = cur_y + dy[d];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(school[nx][ny] == 0) continue;
						int islike = school[nx][ny];
						for (int m = 0; m < 4; m++) {
							if(islike == Students[curStudent][m]) {
								surroundLikeCnt++;
							}
						}
					}
					MaxLikeArr[j][k] = surroundLikeCnt;
				}
			}
			/// 주변에 좋아하는 사람이 많은 자리
			int MaxLikeChair = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(MaxLikeArr[j][k] > MaxLikeChair) MaxLikeChair = MaxLikeArr[j][k];
				}
			}
			int PossibleChairCnt = 0;
			int possibleX = 0, possibleY = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(MaxLikeArr[j][k] == MaxLikeChair) {
						possibleX = j; possibleY = k; 
						PossibleChairCnt++;	
					}
				}
			}
			if(PossibleChairCnt == 1) {
				school[possibleX][possibleY] = curStudent;
				continue;
			}
			
			
			/// 그 중에 주변에 비어있는 칸이 가장 많은 칸
			int[][] emptyArr = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					emptyArr[j][k] = -1;
				}
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(school[j][k] != 0) continue;
					if(MaxLikeArr[j][k] != MaxLikeChair) continue;
					int emptyCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = j + dx[d];
						int ny = k + dy[d];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(school[nx][ny] == 0) {
							emptyCnt++;
						}
					}
					emptyArr[j][k] = emptyCnt;
				}
			}
			/// 제일 빈 칸이 많은 곳 찾기
			int maxEmpty = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(emptyArr[j][k] > maxEmpty) maxEmpty = emptyArr[j][k];
				}
			}
			int maxEmptyCnt = 0;
			int maxEmptyX = 0, maxEmptyY = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(school[j][k] != 0) continue;
					if(emptyArr[j][k] == maxEmpty) {
						maxEmptyCnt++;
						maxEmptyX = j; maxEmptyY = k;
					}
				}
			}
			if(maxEmptyCnt == 1) {
				school[maxEmptyX][maxEmptyY] = curStudent;
				continue;
			}
			
			boolean swc = false;
			for (int j = 0; j < N; j++) {
				if(swc) break;
				for (int k = 0; k < N; k++) {
					if(school[j][k] != 0) continue;
					if(emptyArr[j][k] == maxEmpty) {
						school[j][k] = curStudent;
						swc = true;
						break;
					}
				}
			}

		}
		int satisfy = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = school[i][j];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					int islike = school[nx][ny];
					for (int k = 0; k < 4; k++) {
						if(islike == Students[cur][k]) cnt++;
					}
				}
				if(cnt == 1) satisfy++;
				else if(cnt == 2) satisfy += 10;
				else if(cnt == 3) satisfy += 100;
				else if(cnt == 4) satisfy += 1000;
			}
		}
		bw.write(satisfy + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}