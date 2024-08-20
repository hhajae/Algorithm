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
	    StringBuilder sb = new StringBuilder();
	    
	    outer : while(true) {
	    	String s = br.readLine();
	    	if(s.equals("end")) break;
	    	char[][] map = new char[3][3];
	    	int indCnt = 0;
	    	for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = s.charAt(indCnt++);
				}
			}
	    	// 개수 세아리기
	    	int Ocnt = 0;
	    	int Xcnt = 0;
	    	for (int i = 0; i < 9; i++) {
				if(s.charAt(i) == 'O') Ocnt++;
				else if(s.charAt(i) == 'X') Xcnt++;
			}
	    	if(Ocnt > Xcnt || (Xcnt - Ocnt) > 1) {
	    		sb.append("invalid\n");
	    		continue;
	    	}
	    	if(Xcnt - Ocnt == 1) {
		    	for (int i = 0; i < 3; i++) {
					if(map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O') {
						sb.append("invalid\n");
						continue outer;
					}
		    	}
		    	for (int i = 0; i < 3; i++) {
					if(map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') {
						sb.append("invalid\n");
						continue outer;
					}
		    	}
		    	if(map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') {
					sb.append("invalid\n");
					continue outer;
		    	}
		    	if(map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O') {
		    		sb.append("invalid\n");
		    		continue outer;
		    	}
	    	}
	    	if(Xcnt == Ocnt) {
	    		for (int i = 0; i < 3; i++) {
					if(map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') {
						sb.append("invalid\n");
						continue outer;
					}
		    	}
		    	for (int i = 0; i < 3; i++) {
					if(map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') {
						sb.append("invalid\n");
						continue outer;
					}
		    	}
		    	if(map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') {
					sb.append("invalid\n");
					continue outer;
		    	}
		    	if(map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X') {
		    		sb.append("invalid\n");
		    		continue outer;
		    	}
	    	}
	    	// 끝났는지 확인하기
	    	// 가로
	    	for (int i = 0; i < 3; i++) {
				if(map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O') {
					sb.append("valid\n");
					continue outer;
				}
				if(map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') {
					sb.append("valid\n");
					continue outer;
				}
			}
	    	// 세로
	    	for (int i = 0; i < 3; i++) {
				if(map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') {
					sb.append("valid\n");
					continue outer;
				}
				if(map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') {
					sb.append("valid\n");
					continue outer;
				}
			}
	    	// 대각
	    	if(map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') {
				sb.append("valid\n");
				continue outer;
	    	}
	    	if(map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') {
	    		sb.append("valid\n");
	    		continue outer;
	    	}
	    	if(map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O') {
	    		sb.append("valid\n");
	    		continue outer;
	    	}
	    	if(map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X') {
	    		sb.append("valid\n");
	    		continue outer;
	    	}
	    	if(Xcnt + Ocnt != 9) sb.append("invalid\n");
	    	else sb.append("valid\n");
	    	
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
