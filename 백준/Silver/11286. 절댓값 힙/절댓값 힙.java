import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pque = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pque.add(x);
				continue;
			}
			if (pque.size() == 0) {
				bw.write("0\n");
				continue;
			}
			bw.write(pque.poll() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}