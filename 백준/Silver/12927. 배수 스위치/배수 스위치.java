import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        String s = br.readLine();
        boolean swc = true;
        int cnt = 0;
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) != 'N') {
        		swc = false;
        		break;
        	} 
		}
        
        if(swc) bw.write(0 + "\n");
        
        else if (s.charAt(0) == 'N'){
        	for (int i = 2; i < s.length() + 1; i++) {
        		int N_cnt = 0;
        		int Y_cnt = 0;
				if (s.charAt(i-1) == 'Y') {
					for (int j = 0; j < lst.size(); j++) {
						if ((i % lst.get(j) == 0)) {
							N_cnt++;
						}
					}
					if (N_cnt == 0) lst.add(i);
					else if (N_cnt % 2 == 0) lst.add(i);
				}
				
				else if (s.charAt(i-1) == 'N') {
					for (int j = 0; j < lst.size(); j++) {
						if (i % lst.get(j) == 0) {
							Y_cnt++;
						}
					}
					if (Y_cnt == 0) continue;
					else if (Y_cnt % 2 == 1) lst.add(i); 
				}
			}
        	cnt = lst.size();
        	bw.write(cnt + "\n");
        }
        else if (s.length() != 0 && s.charAt(0) == 'Y'){
        	for (int i = 2; i < s.length() + 1; i++) {
        		int N_cnt = 0;
        		int Y_cnt = 0;
				if (s.charAt(i-1) == 'N') {
					for (int j = 0; j < lst.size(); j++) {
						if ((i % lst.get(j) == 0)) {
							N_cnt++;
						}
					}
					if (N_cnt == 0) lst.add(i);
					else if (N_cnt % 2 == 0) lst.add(i);
				}
				
				else if (s.charAt(i-1) == 'Y') {
					for (int j = 0; j < lst.size(); j++) {
						if (i % lst.get(j) == 0) {
							Y_cnt++;
						}
					}
					if (Y_cnt == 0) continue;
					else if (Y_cnt % 2 == 1) lst.add(i); 
				}
			}
        	cnt = lst.size() + 1;
        	bw.write(cnt + "\n");
        }
        else {
            bw.write(1 + "\n");
        }

		bw.flush();
	    bw.close();
	    br.close();
	}
}