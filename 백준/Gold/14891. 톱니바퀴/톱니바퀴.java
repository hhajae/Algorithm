import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class wheel {
	int t12, t1, t3, t5, t6, t7, t9, t11;

	public wheel(String s) {
		this.t12 = s.charAt(0) - 48; this.t1 = s.charAt(1) - 48; this.t3 = s.charAt(2) - 48;
		this.t5 = s.charAt(3) - 48; this.t6 = s.charAt(4) - 48; this.t7 = s.charAt(5) - 48;
		this.t9 = s.charAt(6) - 48; this.t11 = s.charAt(7) - 48;
	}
	public int getTwelve() {
		return this.t12;
	}
	public int getThree() {
		return this.t3;
	}
	public int getNine() {
		return this.t9;
	}
	public void move(int dir) {
		if (dir == 1) { // 시계
			int tmp = t12; this.t12 = t11; this.t11 = t9;
			this.t9 = t7; this.t7 = t6; this.t6 = t5;
			this.t5 = t3; this.t3 = t1; this.t1 = tmp;
		}
		else if (dir == -1) { // 반시계
			int tmp = t12; this.t12 = t1; this.t1 = t3;
			this.t3 = t5; this.t5 = t6; this.t6 = t7;
			this.t7 = t9; this.t9 = t11; this.t11 = tmp;
		}
	}
	@Override
	public String toString() {
		return "wheel [t12=" + t12 + ", t1=" + t1 + ", t3=" + t3 + ", t5=" + t5 + ", t6=" + t6 + ", t7=" + t7 + ", t9="
				+ t9 + ", t11=" + t11 + "]";
	}
	
}
public class Main {
	static final int S = 1;
	static final int N = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
//		int T = Integer.parseInt(br.readLine());
		int T = 4;
		wheel[] wheels = new wheel[T];
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			wheels[i] = new wheel(s);
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int wheelNum = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int[] dirArr = new int[T];
			dirArr[wheelNum] = dir;
			for (int j = wheelNum - 1; j >= 0; j--) { // 회전시킬 놈 앞에부터 맨앞에놈 
				if(wheels[j].getThree() == wheels[j+1].getNine()) break;
				if(dirArr[j+1] == -1) dirArr[j] = 1;
				else if (dirArr[j+1] == 1) dirArr[j] = -1;
			}
			for (int j = wheelNum + 1; j < T; j++) { // 회전시킬 놈 뒷놈부터 뒤에놈 
				if(wheels[j-1].getThree() == wheels[j].getNine()) break;
				if(dirArr[j-1] == -1) dirArr[j] = 1;
				else if (dirArr[j-1] == 1) dirArr[j] = -1;
			}
			for (int j = 0; j < T; j++) {
//				bw.write("wheel( " + j + ") = " + wheels[j] + "\ndir = " + dirArr[j] + "\n");
				wheels[j].move(dirArr[j]);
//				bw.write("after move ~ " + wheels[j] + "\n\n");
			}
		}
		int resCnt = 0;
		if(wheels[0].getTwelve() == S) resCnt += 1;
		if(wheels[1].getTwelve() == S) resCnt += 2;
		if(wheels[2].getTwelve() == S) resCnt += 4;
		if(wheels[3].getTwelve() == S) resCnt += 8;
		
		bw.write(resCnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}