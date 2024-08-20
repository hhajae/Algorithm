import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		HashMap<String, int[]> moves = new HashMap<>();
		moves.put("R", new int[] {0, 1}); moves.put("L", new int[] {0, -1});
		moves.put("B", new int[] {-1, 0}); moves.put("T", new int[] {1, 0});
		moves.put("RT", new int[] {1, 1}); moves.put("LT", new int[] {1, -1});
		moves.put("RB", new int[] {-1, 1}); moves.put("LB", new int[] {-1, -1});
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		String kingPos = st.nextToken();
		String dollPos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		int kingRow = Integer.parseInt(kingPos.charAt(1) + "") - 1;
		int kingCol = kingPos.charAt(0) - 'A';
		int dollRow = Integer.parseInt(dollPos.charAt(1) + "") - 1;
		int dollCol = dollPos.charAt(0) - 'A';
		
		for (int i = 0; i < N; i++) {
			String move = br.readLine();
			int[] movePos = moves.get(move);
			int dx = movePos[0], dy = movePos[1];
			int nx = kingRow + dx, ny = kingCol + dy;
			if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
			if(nx == dollRow && ny == dollCol) {
				int dollnx = dollRow + dx;
				int dollny = dollCol + dy;
				if(dollnx < 0 || dollnx >= 8 || dollny < 0 || dollny >= 8) continue;
				dollRow = dollnx;
				dollCol = dollny;
			}
			kingRow = nx; kingCol = ny;
		}
		bw.write((char)(kingCol + 'A')); bw.write((kingRow + 1) + "\n");
		bw.write((char)(dollCol + 'A')); bw.write((dollRow + 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}