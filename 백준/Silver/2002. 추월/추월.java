import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    HashMap<String, Integer> cars = new HashMap<>();
	    HashMap<String, HashSet<String>> fasterCars = new HashMap<>();
	    for (int i = 0; i < N; i++) {
			String s = br.readLine();
			fasterCars.put(s, new HashSet<>());
			for (String string : cars.keySet()) {
				fasterCars.get(s).add(string);
			}
			cars.put(s, i);
		}
	    int cnt = 0;
	    HashSet<String> resSet = new HashSet<>();
	    outer : for (int i = 0; i < N; i++) {
			String s = br.readLine();
			resSet.add(s);
			int seq = cars.get(s);
			if(i < seq) {
				cnt++;
				continue;
			}
			for (String string : fasterCars.get(s)) {
				if(!resSet.contains(string)) {
					cnt++;
					continue outer;
				}
			}
	    }
	    bw.write(cnt + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
