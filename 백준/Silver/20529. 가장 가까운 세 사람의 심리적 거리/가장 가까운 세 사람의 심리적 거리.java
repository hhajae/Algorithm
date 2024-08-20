import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static boolean np(int[] p) {
		int N = p.length;
		
		int x = N-1;
		while(x > 0 && p[x-1] >= p[x]) x--;
		if(x == 0) return false;
		
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
	private static int mbtiDistance(String A, String B, String C) {
		int AB = 0, BC = 0, AC = 0;
		for (int i = 0; i < 4; i++) {
			if(A.charAt(i) != B.charAt(i)) AB++;
			if(B.charAt(i) != C.charAt(i)) BC++;
			if(A.charAt(i) != C.charAt(i)) AC++;
		}
		return AB+BC+AC;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			boolean swc = false;
			for (int j = 0; j < N; j++) {
				String mbti = st.nextToken();
				if(map.containsKey(mbti)) {
					map.replace(mbti, map.get(mbti) + 1);
					if(map.get(mbti) == 3) {
						swc = true;
						break;
					}
				}
				else map.put(mbti, 1);
			}
			if(swc) {
				sb.append(0).append("\n");
				continue;
			}
			Set<String> mbtiSet = map.keySet();
			List<String> mbtiLst = new ArrayList<>();
			for (String str : mbtiSet) {
				int students = map.get(str);
				for (int j = 0; j < students; j++) {
					mbtiLst.add(str);
				}
			}
			int mbtiLstSize = mbtiLst.size();
			int[] npArr = new int[mbtiLstSize];
			for (int j = 0; j < 3; j++) {
				npArr[mbtiLstSize-j-1] = 1;
			}
			int minMbtiDis = Integer.MAX_VALUE;
			do {
				String[] tmpStr = new String[3];
				int tmpStrind = 0;
				for (int j = 0; j < mbtiLstSize; j++) {
					if(npArr[j] == 1) tmpStr[tmpStrind++] = mbtiLst.get(j); 
				}
				int mbtiDis = mbtiDistance(tmpStr[0], tmpStr[1], tmpStr[2]);
				minMbtiDis = Math.min(minMbtiDis, mbtiDis);
			} while(np(npArr));
			sb.append(minMbtiDis).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}