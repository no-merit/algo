import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static boolean [] checked;
	static int N;
	static List<List<int[]>> list;
	static int [] potion;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String [] input = br.readLine().split(" ");
		potion = new int[N+1];
		for(int i=1; i<=N;i++) {
			int now = Integer.parseInt(input[i-1]);
			potion[i] = now;
		}
		list = new ArrayList<>();
		for(int i=0;i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=1;i<=N;i++) {
			int now = Integer.parseInt(br.readLine());
			if(now==0) continue;
			for(int j=0;j<now; j++) {
				String [] discount = br.readLine().split(" ");
				
				int aj = Integer.parseInt(discount[0]);
				int dj = Integer.parseInt(discount[1]);
				list.get(i).add(new int [] {aj,dj});
			}
		}
		checked = new boolean[N+1];
		dfs(0,0,potion);
		System.out.println(min);
	}
	
	public static void dfs(int depth,int sum,int [] now) {
		if(depth==N) {
			min=Math.min(min, sum);
			return;
		}
		
		
		
		for(int i=1;i<=N;i++) {
			if(!checked[i]) {
				int tmp = sum;
				tmp+=now[i];
				int [] newPotion = new int [N+1];
				for(int j=0; j<=N;j++) {
					newPotion[j]=now[j];
				}
				for(int[] arg: list.get(i)) {
					int num = arg[0];
					int disc = arg[1];
					if(newPotion[num]-disc>=1) {
						newPotion[num] = newPotion[num]-disc;
					}else {
						newPotion[num] = 1;
					}
					
				}
				checked[i]=true;
				dfs(depth+1,tmp,newPotion);
				checked[i]=false;
			}
		}
	}
}
