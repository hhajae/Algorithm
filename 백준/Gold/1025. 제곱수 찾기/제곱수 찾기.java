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
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		int maxPower = -1;
		StringBuilder numStr = null;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sqr = (int)Math.sqrt(arr[i][j]);
				if(sqr * sqr == arr[i][j]) {
					maxPower = Math.max(maxPower, arr[i][j]);
				}
				
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < M; col++) {
						if(row == 0 && col == 0) continue;
						numStr = new StringBuilder();
						numStr.append(arr[i][j]);
						int mulCnt = 0;
						while(true) {
							mulCnt++;
							int nx = i + row * mulCnt;
							int ny = j + col * mulCnt;
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
							numStr.append(arr[nx][ny]);
							int num = Integer.parseInt(numStr.toString());
							int sqrNum = (int) Math.sqrt(num);
							if(sqrNum * sqrNum == num) {
								maxPower = Math.max(maxPower, (int)num);
							}
						}
						numStr = new StringBuilder();
						numStr.append(arr[i][j]);
						mulCnt = 0;
						while(true) {
							mulCnt--;
							int nx = i + row * mulCnt;
							int ny = j + col * mulCnt;
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
							numStr.append(arr[nx][ny]);
							int num = Integer.parseInt(numStr.toString());
							int sqrNum = (int) Math.sqrt(num);
							if(sqrNum * sqrNum == num) {
								maxPower = Math.max(maxPower, (int)num);
							}
						}
						numStr = new StringBuilder();
						numStr.append(arr[i][j]);
						mulCnt = 0;
						while(true) {
							mulCnt++;
							int nx = i + row * mulCnt;
							int ny = j + col * (-1) * mulCnt;
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
							numStr.append(arr[nx][ny]);
							int num = Integer.parseInt(numStr.toString());
							int sqrNum = (int) Math.sqrt(num);
							if(sqrNum * sqrNum == num) {
								maxPower = Math.max(maxPower, (int)num);
							}
						}
						numStr = new StringBuilder();
						numStr.append(arr[i][j]);
						mulCnt = 0;
						while(true) {
							mulCnt++;
							int nx = i + row * (-1) * mulCnt;
							int ny = j + col * mulCnt;
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
							numStr.append(arr[nx][ny]);
							int num = Integer.parseInt(numStr.toString());
							int sqrNum = (int) Math.sqrt(num);
							if(sqrNum * sqrNum == num) {
								maxPower = Math.max(maxPower, (int)num);
							}
						}
					}
				}
			}
		}
		
		sb.append(maxPower);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
