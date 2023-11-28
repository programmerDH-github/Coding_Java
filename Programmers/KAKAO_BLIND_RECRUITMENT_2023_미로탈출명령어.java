package Programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2023_미로탈출명령어 {
    static int[][] visited;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static List<String> list = new ArrayList<>();
    static boolean check = false;
    public static void main(String[] args) {
        int n = 3; int m = 4; int x = 2; int y = 3; int r = 3; int c = 1; int k = 5;
        // int n = 2; int m = 2; int x = 1; int y = 1; int r = 2; int c = 2; int k = 2;
        // int n = 3; int m = 3; int x = 1; int y = 2; int r = 3; int c = 3; int k = 4;
        int[][] maps = new int[n][m];
        int length = (int)Math.abs(x-r) + (int)Math.abs(y-c);
        if((k - length) % 2 == 1 || k < length) System.err.println("impossible");
        dfs(maps,x-1,y-1,r-1,c-1,k,0,"");


        if(list.isEmpty()) {
            System.err.println("impossible");
        }
        else {
            System.out.println(list.get(0));
        }

    }

    public static void dfs(int[][] maps, int x, int y, int end_x, int end_y, int k, int count, String direct) {
        if(check) return;
        if(count + (int)Math.abs(x-end_x) + (int)Math.abs(y-end_y) > k) return;
        if(count == k) {
            if(x == end_x && y == end_y) {
                list.add(direct);
                check = true;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                //아래 d
                if(i == 0) {
                    dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"d");
                }
                //왼쪽 l
                else if(i == 1) {
                    dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"l");
                }
                //오른쪽 r
                else if(i == 2) {
                    dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"r");
                }
                //위쪽 u
                else {
                    dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"u");
                }
            }
            if(check) return;
        }
        
    }

    // public static void bfs(int[][] maps, int x, int y, int end_x, int end_y, int k, int count, String direct) {
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.add(new int[]{x,y});
    //     maps[x][y] += 1;

    //     while(!queue.isEmpty()) {
    //         int cur_x = queue.peek()[0];
    //         int cur_y = queue.peek()[1];
    //         queue.poll();

    //         for(int i = 0; i < 4; i++) {
    //         int nx = x + dx[i];
    //         int ny = y + dy[i];
    //             if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] != 2) {
    //                 maps[nx][ny] += 1;
    //                 queue.add(new int[]{nx,ny});
                
    //                 //아래 d
    //                 if(i == 0) {
    //                     dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"d");
    //                 }
    //                 //위 u
    //                 else if(i == 1) {
    //                     dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"u");
    //                 }
    //                 //오른쪽 r
    //                 else if(i == 2) {
    //                     dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"r");
    //                 }
    //                 //왼쪽 l
    //                 else {
    //                     dfs(maps,nx,ny,end_x,end_y,k,count+1,direct+"l");
    //                 }
    //                 maps[nx][ny] -= 1;
    //             }
    //         }
    //     }
        
    // }
}
