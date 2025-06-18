package java23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] NM = br.readLine().split(" ");
        int C =Integer.parseInt(NM[0]);
        int R =Integer.parseInt(NM[1]);
        int [][][]map = new int [R][C][2];
        
        for(int i=0; i<R; i++) {
        	String [] row = br.readLine().split(" ");
        	for(int j=0;j<C;j++) {
        		map[i][j][0]= Integer.parseInt(row[j]);
        	}
        }
        boolean [][] checked = new boolean[R][C];
        Queue<int []> q = new LinkedList<>();
        List<Integer> area_list = new ArrayList<>();
        int max_area=0;
        int cnt =0;
        int idx = -1;
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C;j++) {
        		if(!checked[i][j]) {
        			idx++;
        			cnt++;
        			checked[i][j] = true;
        			map[i][j][1] = idx;
        			q.add(new int[] {i,j});
        			int area=0;
        			while(!q.isEmpty()) {
        				int [] poll = q.poll();
        				area++;
        				int r = poll[0];
        				int c = poll[1];
        				if((map[r][c][0] & 1)!=1 &&!checked[r][c-1]){//서
        					checked[r][c-1]=true;
        					q.add(new int [] {r,c-1});
        					map[r][c-1][1] = idx;
        				}
        				if((map[r][c][0] & 2)!=2&&!checked[r-1][c]){//북
        					checked[r-1][c]=true;
        					q.add(new int [] {r-1,c});
        					map[r-1][c][1] = idx;
        				}
        				if((map[r][c][0] & 4)!=4&&!checked[r][c+1]){//동
        					checked[r][c+1]=true;
        					q.add(new int [] {r,c+1});
        					map[r][c+1][1] = idx;
        				}
        				if((map[r][c][0] & 8)!=8&&!checked[r+1][c]){//남
        					checked[r+1][c]=true;
        					q.add(new int [] {r+1,c});
        					map[r+1][c][1] = idx;
        				}
        			}
        			max_area=Math.max(max_area, area);
        			area_list.add(area);
        		}
        	}
        }

        checked = new boolean[R][C];
        int [] dr = new int[] {0,1,0,-1};
        int [] dc = new int[] {1,0,-1,0};
        int ans = 0;
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C;j++) {
        		if(!checked[i][j]) {
        			checked[i][j] = true;
        			q.add(new int[] {i,j});
        			int name = map[i][j][1];
        			while(!q.isEmpty()) {
        				int [] poll = q.poll();
        				int r = poll[0];
        				int c = poll[1];
        				for(int k =0; k<4; k++) {
        					int nr = r+dr[k];
        					int nc = c+dc[k];
        					if(nr>=0 && nr<R && nc>=0 &&nc<C) {
        						if(map[nr][nc][1]==map[i][j][1] && !checked[nr][nc]) {
        							checked[nr][nc] =true;
        							q.add(new int [] {nr,nc});
        						}
        						if(map[nr][nc][1]!=name) {
        							int tmp = area_list.get(name)+area_list.get(map[nr][nc][1]);
        							ans = Math.max(ans,tmp);
        						}
        					}
        				}
        			}
        		}
        		
        	}
        }
        sb.append(cnt+"\n").append(max_area+"\n").append(ans);
        System.out.println(sb.toString());
    }
}
