import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    boolean swc = true;
	    int cnt = 0;
	    int real = N;
	    while(swc) {
	    	cnt++;
	    	int first = 0, second = 0;
	    	first = N / 10;
	    	second = N % 10;
	    	int newNumber = second * 10 + (first+second) % 10;
	    	N = newNumber;
	    	if (newNumber == real) swc = false;
	    }
	    bw.write(cnt + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}