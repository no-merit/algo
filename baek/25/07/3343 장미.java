import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());
		if(b*c>a*d) {
			//b/a>=d/c  a집의 가성비가 c집의 가성비보다 나쁠 때
			long tmp_cnt = a;
			long tmp_price = b;
			a=c;
			b=d;
			c=tmp_cnt;
			d=tmp_price;
		}
		long minCost = Long.MAX_VALUE;
		for(long i=0; i<a; i++) {
			long costFromD = i * d;
            long remainingN = n - i * c;

            long costFromB = 0;
            if (remainingN > 0) {
                long neededA = (remainingN + a - 1) / a;
                costFromB = neededA * b;
            }

            long currentCost = costFromD + costFromB;
            minCost = Math.min(minCost, currentCost);
		}
		System.out.println(minCost);
	}

}
