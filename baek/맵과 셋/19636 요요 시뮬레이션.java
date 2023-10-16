import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String [] WIT = br.readLine().split(" ");
		int W = Integer.parseInt(WIT[0]);	//체중
		int I = Integer.parseInt(WIT[1]);
		int E = Integer.parseInt(WIT[1]);
		//다이어트 전 일일 에너지 섭취량, 일일 기초 대사량
		int T = Integer.parseInt(WIT[2]);	//기초 대사량 변화 역치
		
		//다이어트를 하면 체중과 일일 기초 대사량이 변화함
		
		//체중은 D_I-D_A 만큼 더 해 짐 
		//일일 에너지 소비량은 일일 기초 대사량과 일일 활동 대사량을 더한 것
		//일일 에너지 섭취량 - 일일 에너지 소비량의 절댓값이 기초 대사량 변화 역치 T를 초과하면
		//일일 기초 대사량은  (일일 에너지 섭취량 − 일일 에너지 소비량) / 2  만큼 더해진다
		//일일 기초 대사량 변화는 체중 변화 후 일어난다
		
		//체중이 0이하가 되거나 일일 기초대사량이 0이하이면 dangetdiet
		
		String [] Diet = br.readLine().split(" ");
		int D = Integer.parseInt(Diet[0]);	//다이어트 기간
		int D_I = Integer.parseInt(Diet[1]);//다이어트 기간 일일 에너지 섭취량
		int D_A = Integer.parseInt(Diet[2]);//다이어트 기간 일일 활동 대사량
		
		int no_change = W+D*(D_I-I-D_A);
		
		if(no_change<=0) {
			sb.append("Danger Diet").append("\n");
		}else {
			sb.append(no_change).append(" ").append(I).append("\n");
		}
		
		int change = W;
		
		for(int i=0; i<D; i++) {
			change += D_I-I-D_A;
			
			if(Math.abs(D_I-I-D_A)>T) {
				I+=(Math.floor((D_I-I-D_A)))/2;
			}
		}
		
		if(change<=0 || I<=0) {
			sb.append("Danger Diet").append("\n");
		}else if(E>I){
			sb.append(change).append(" ").append(I).append(" ").append("YOYO").append("\n");
		}else {
			sb.append(change).append(" ").append(I).append(" ").append("NO").append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}
}
