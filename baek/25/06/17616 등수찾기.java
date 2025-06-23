import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class student{
	int seq;
	List<Integer> win = new ArrayList<>();
	List<Integer> lose = new ArrayList<>();
	student(int seq){
		this.seq = seq;
	}
}
public class Main {
	static List<student> all;
	static boolean [] checked;
	static int N,lose_rank, win_rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int X = Integer.parseInt(input[2]);
		all = new ArrayList<>();
		checked = new boolean [N+1];
		checked[X] = true;
		for(int i=0;i<=N;i++) {
			all.add(new student(i));
		}
		
		for(int i=0; i<M; i++) {
			String[] now = br.readLine().split(" ");
			int win = Integer.parseInt(now[0]);
			int lose = Integer.parseInt(now[1]);
			all.get(win).lose.add(lose);
			all.get(lose).win.add(win);
		}
		lose_rank = N+1;
		win_rank = 0;
		
		dfs_win(X);
		
		if(all.get(X).lose.size()==0) {
			lose_rank= N;
		}else {
			dfs_lose(X);
		}
		int cnt =0;
		for(int i=1;i<=N;i++) {
			if(!checked[i]) cnt++;
		}
		
		System.out.println(win_rank+" "+lose_rank);
		
	}

	private static void dfs_lose(int X) {
		if(all.get(X).lose.size()==0) {
			lose_rank--;
			return ;
		}
		for(int now:all.get(X).lose) {
			if(!checked[now]) {
				checked[now] =true;
				dfs_lose(now);
			}
		}
		lose_rank--;
	}

	private static void dfs_win(int X) {
		if(all.get(X).win.size()==0) {
			win_rank++;
			return;
		}
		for(int now:all.get(X).win) {
			if(!checked[now]) {
				checked[now] =true;
				dfs_win(now);
			}
		}win_rank++;
	}
}
