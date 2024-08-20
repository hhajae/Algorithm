import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int year = Integer.parseInt(br.readLine());
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) { // 4년마다인데 100년마다는 아님 근데 400년은 가넝
			System.out.println("1");
		}
		else System.out.println("0");
	}		
}
