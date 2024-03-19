import java.io.*;
import java.util.*;

public class Baek_Joon_10026 {
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        maps = new String[N][N];
        for(int i = 0; i < N; i++) {
            String[] color = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                maps[i][j] = color[j];
            }
        }
        
        int area_count = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    area_count++;
                    visited[i][j] = true;
                    non_blindness(i,j,maps[i][j]);
                }
            }
        }
        sb.append(area_count).append(" ");

        area_count = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    area_count++;
                    visited[i][j] = true;
                    blindness(i,j,maps[i][j]);
                }
            }
        }
        sb.append(area_count);

        System.out.println(sb);


    }

    public static void non_blindness(int x, int y, String color) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,color));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && node.color.equals(maps[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.color));
                }
            }
        }
    }

    public static void blindness(int x, int y, String color) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,color));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if(node.color.equals("B")) {
                        if(maps[nx][ny].equals("B")) {
                            visited[nx][ny] = true;
                            queue.offer(new Node(nx, ny, node.color));
                        }
                    }
                    else {
                        if(maps[nx][ny].equals("R") || maps[nx][ny].equals("G")) {
                            visited[nx][ny] = true;
                            queue.offer(new Node(nx, ny, node.color));
                        }
                    }
                    
                    
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        String color;

        public Node(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
