import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<String> players = new ArrayList<>();
		List<String> increasePlayers = new ArrayList<>();
		List<String> decreasePlayers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			players.add(s);
			increasePlayers.add(s);
			decreasePlayers.add(s);
		}
		Collections.sort(increasePlayers);
		Collections.sort(decreasePlayers, Collections.reverseOrder());
		if(players.toString().equals(increasePlayers.toString())) {
			sb.append("INCREASING");
		} else if (players.toString().equals(decreasePlayers.toString())) {
			sb.append("DECREASING");
		} else {
			sb.append("NEITHER");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
