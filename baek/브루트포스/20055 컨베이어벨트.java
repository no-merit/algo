import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.CheckedInputStream;

public class Main {
	static StringBuilder sb;
	static int N,K;
	static int [] arr;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		arr = new int[2*N];
		check = new boolean[N];
		String [] str = br.readLine().split(" ");
		for(int i=0; i<2*N; i++) {
			arr[i]= Integer.parseInt(str[i]); 
		}
		
		int ans =0;
		while(test()) {
			rotate();
			position();
			ans++;
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	static void rotate() {
		int tmp = arr[2*N-1];
		
		for(int i=2*N-1; i>0; i--) {
			arr[i]=arr[i-1];
			
		}
		arr[0]=tmp;
	}//컨베이어 벨트의 회전
	static void position() {
		
		for(int i=N-1; i>0; i--) {
			check[i]=check[i-1];
		}
		check[0]=false;
		check[N-1]=false;
		//컨베이어 벨트따라 로봇 이동
		for(int i=N-2; i>0; i--) {
			if(check[i] && !check[i+1] && arr[i+1]>0) {
				check[i]=false;
				check[i+1]=true;
				arr[i+1]--;
				
			}
		}
    //로봇이 다음칸에 갈 수 잇으면 이동
		if(arr[0]>0) {
			check[0]=true;
			arr[0]--;
		}

	}
	static boolean test () {
		int cnt=0;
		for(int i=0; i<2*N;i++) {
			if(arr[i]==0) {
				cnt++;
			}
			if(cnt>=K) {
				return false;
			}
		}
		
		
		return true;
	}

}
