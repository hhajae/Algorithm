import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class FireBall {
	int r, c, m, s, d;

	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
	
	int[] dx = {-1, -1, 0, 1, 1,  1,  0, -1};
	int[] dy = {0,   1, 1, 1, 0, -1, -1, -1};
	public void move(int N) {
		int tmpR = this.r + (this.s * dx[this.d]);
		int tmpC = this.c + (this.s * dy[this.d]);
		this.r = (tmpR + 1000) % N;
		this.c = (tmpC + 1000) % N;
	}
	
}
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
		List<FireBall> balls = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int mass = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			balls.add(new FireBall(row, col, mass, speed, dir));
		}
		/// input end ///
		for (int i = 0; i < K; i++) { // 움직인다
			int ballsSize = balls.size();
			for (int j = 0; j < ballsSize; j++) {
				balls.get(j).move(N); // 움직이자
			}
			int[][][] isSamePos = new int[N][N][4]; // 개수, 질량 합, 속력 합, 방향
			// 방향 값 0이면 처음, 홀수면 1, 짝수면 2, 모두 홀이나 짝이 아니었다 3
			ArrayList<Integer>[][] isSameBalls = new ArrayList[N][N];
			for (int j = 0; j < ballsSize; j++) { // isSamePos 작업하기
				int nx = balls.get(j).r; int ny = balls.get(j).c;
				int tmpM = balls.get(j).m; int tmpS = balls.get(j).s;
				int tmpD = balls.get(j).d;
				if(isSamePos[nx][ny][3] != 0) { //
					isSameBalls[nx][ny].add(j);
					isSamePos[nx][ny][0]++;
					isSamePos[nx][ny][1] += tmpM;
					isSamePos[nx][ny][2] += tmpS;
					if (isSamePos[nx][ny][3] == 3) continue;
					if(tmpD % 2 == 1) {
						if (isSamePos[nx][ny][3] != 1) isSamePos[nx][ny][3] = 3;
					}
					else if (tmpD % 2 == 0) {
						if (isSamePos[nx][ny][3] != 2) isSamePos[nx][ny][3] = 3;
					}
				}
				else if(isSamePos[nx][ny][3] == 0) { // 처음인 파이어볼
					isSameBalls[nx][ny] = new ArrayList<Integer>();
					isSameBalls[nx][ny].add(j);
					isSamePos[nx][ny][0]++;
					isSamePos[nx][ny][1] += tmpM;
					isSamePos[nx][ny][2] += tmpS;
					if(tmpD % 2 == 1) isSamePos[nx][ny][3] = 1;
					else isSamePos[nx][ny][3] = 2;
				}
			}
			/// 같은 칸에 있는 파이어볼 합치고 나누기 ///
			List<Integer> removeIndLst = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(isSamePos[j][k][0] < 2) continue;
					int removeBallSize = isSameBalls[j][k].size();
//					System.out.println("j, k = " + j + ", " + k);
//					System.out.println("removeBallsize = " + isSamePos[j][k][0]);
//					System.out.println("isSameBalls = " + isSameBalls[j][k].toString());
					for (int b1 = 0; b1 < removeBallSize ; b1++) {
						int removeind = isSameBalls[j][k].get(b1);
						removeIndLst.add(removeind);
					}
					int tmpMass = isSamePos[j][k][1] / 5;
					if (tmpMass == 0) continue;
					int tmpSpeed = isSamePos[j][k][2] / isSamePos[j][k][0];
					int tmpDirect = isSamePos[j][k][3];
					if (tmpDirect == 3) {
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 1));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 3));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 5));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 7));
					}
					else {
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 0));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 2));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 4));
						balls.add(new FireBall(j, k, tmpMass, tmpSpeed, 6));
					}
				}
			}
			Collections.sort(removeIndLst);
			for (int j = removeIndLst.size()-1; j >= 0; j--) {
				int removeind = removeIndLst.get(j);
				balls.remove(removeind);
			}
		}
		int remainBallMassSum = 0;
//		bw.write("ballsSize = " + balls.size() + "\n"); /////////////////
		for (int i = 0; i < balls.size(); i++) {
			int tmpMass = balls.get(i).m;
			remainBallMassSum += tmpMass;
		}
		bw.write(remainBallMassSum + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}