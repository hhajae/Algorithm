import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> card = new LinkedList<>();
		
		if (N == 1) {
			bw.write(1 + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			card.add(i);
		}
		
		int n = 0;
		while(card.size() != 1) {
			card.poll();
			n = card.poll();
			card.add(n);
		}
		int res = card.poll();
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}