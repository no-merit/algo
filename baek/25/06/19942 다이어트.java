import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class nutrient{
	int seq;
	int p ;
	int f ;
	int s ;
	int v ;
	int c ;
	nutrient(int seq, int p, int f, int s, int v, int c){
		this.seq = seq;
		this.p = p;
		this.f = f;
		this.s = s;
		this.v = v;
		this.c = c;
	}
}
public class Main {
	static int N,ans,A,B,C,D;
	static List<nutrient> list;
	static final int Max = Integer.MAX_VALUE;
	static String ans_str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String [] abcd = br.readLine().split(" ");
		A = Integer.parseInt(abcd[0]);
		B = Integer.parseInt(abcd[1]);
		C = Integer.parseInt(abcd[2]);
		D = Integer.parseInt(abcd[3]);
		list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			String [] pfsvc = br.readLine().split(" ");
			int seq = i;
			int p = Integer.parseInt(pfsvc[0]);
			int f = Integer.parseInt(pfsvc[1]);
			int s = Integer.parseInt(pfsvc[2]);
			int v = Integer.parseInt(pfsvc[3]);
			int c = Integer.parseInt(pfsvc[4]);
			list.add(new nutrient(seq,p, f, s, v, c));
		}
		ans = Max;
		ans_str = "";
		dfs(0,0);
		if(ans==Max) {
		System.out.println(-1);
		return;
		}
		
		sb.append(ans+"\n");
		String [] arr = ans_str.split(" ");
		for(int i=0; i<arr.length;i++) {
		
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int depth, int combi) {
		if(depth==N) {
			int p =0;
			int f =0;
			int s =0;
			int v =0;
			int c =0;
			String str = "";
			for(int i=0; i<N;i++) {
				if((combi&(1<<i))==1<<i) {
					p+=list.get(i).p;
					f+=list.get(i).f;
					s+=list.get(i).s;
					v+=list.get(i).v;
					c+=list.get(i).c;
					str+=list.get(i).seq+" ";
				}
			}
			if(p>=A && f>=B && s>=C && v>=D) {
				if(ans>c) {
					ans=c;
					ans_str=str;
				}else if(ans==c) {
					if(str.compareTo(ans_str)<0) {
						ans_str=str;
					}
				}
			}
			
			
			return;
		}
		dfs(depth+1,combi);
		dfs(depth+1,combi| (1 << depth));
		
	}

}
