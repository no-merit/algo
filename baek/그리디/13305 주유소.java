import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// N 2~100,000 도시의 개수
		// 총 도로의 거리 1~1,000,000,000 10억
		// 리터당 가격 1~1,000,000,000 10억
		
		
		//계산 전 값이 int 범위 내일지라도 계산 과정에서 int 범위를 넘어서면 
		//overflow된 값을 long으로 받는다고 해도 받아지지 않음
		//애초에 long 형으로 선언해서 받아줘야 overflow가 생기지 않음
		String[] road = br.readLine().split(" ");
		long[] road_arr = new long[N];
		for (int i = 1; i < N; i++) {
			road_arr[i] = Long.parseLong(road[i-1]);
		}
		
		String[] price = br.readLine().split(" ");
		long[] price_arr = new long[N];
		for (int i = 0; i < N ; i++) {
			price_arr[i] = Long.parseLong(price[i]);
		}
		// 도시가 10만개일 때 N^2 10억
		long min_price =0;	//기름의 최소값
		long ans=0;			//기름값의 합
		for(int i=0; i<N;) {
			boolean flag = false; 	//뒤에 더 싼 기름이 있는지
			int st = i;				//시작도시
			min_price=price_arr[i];	//기름 최소 값
			//i는 현재 도시, 뒤의 도시 중에 기름 값이 현재 도시보다 낮은 도시까지 갈 기름을 사야함
			for(int j=i+1; j<N; j++) {//뒤의 도시 탐색
				if(min_price>price_arr[j]) {//현재 기름값보다 낮은 기름 값이 있다면
					flag = true;			//있음을 알리고
					i=j;					//목적지는 그 도시 j
					break;
				}
			}
			if(!flag) i=N-1;					//뒤에 더 싼 값의 기름이 없으면 현재 도시에서 끝까지 갈 기름을 삼
			
			//더 싼 기름이 있으면
			int distance = 0;
			for(int j=st+1; j<=i; j++) {
				distance+=road_arr[j];
			}
			ans+=(min_price*distance);
			if(i==N-1) break;
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
