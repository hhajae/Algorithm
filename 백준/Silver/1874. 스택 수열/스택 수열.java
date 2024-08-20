import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        int[] input_arr = new int[N];
        for (int i = 0; i < N; i++) {
			input_arr[i] = Integer.parseInt(br.readLine());
		}
        Stack<Integer> box = new Stack<>();
        Stack<Integer> tnduf = new Stack<>();
        
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        boolean swc = false;
        for (int i = 0; i < N; i++) {
        	int n = input_arr[i];
			if (cnt <= n) {
				int range = n-cnt+1;
				for (int j = 0; j < range; j++) {
					box.add(cnt++);
					sb.append("+\n");	
				}
				tnduf.add(box.pop());
				sb.append("-\n");
			}
			else {
				if (box.peek() != n) {
					swc = true;
					break;
				}
				tnduf.add(box.pop());
				sb.append("-\n");
			}
		}
        if(swc) bw.write("NO");
        else {
            bw.write(sb.toString() + "");
        }
 
		bw.flush();
	    bw.close();
	    br.close();
	}
}