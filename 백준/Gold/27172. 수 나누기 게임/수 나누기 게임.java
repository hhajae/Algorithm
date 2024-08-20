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
		
		int N = Integer.parseInt(br.readLine());
		boolean[] boolCards = new boolean[1000001];
		int[] cards = new int[N];
		HashMap<Integer, Integer> scores = new HashMap<>();
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			boolCards[cards[i]] = true;
			scores.put(cards[i], 0);
			if(cards[i] > maxNum) maxNum = cards[i];
		}
		for (int i = 0; i < N; i++) {
			int card = cards[i];
			for (int j = card; j < maxNum + 1; j += card) {
				if(boolCards[j]) {
					scores.replace(card, scores.get(card)+1);
					scores.replace(j, scores.get(j)-1);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(scores.get(cards[i])).append(" ");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}