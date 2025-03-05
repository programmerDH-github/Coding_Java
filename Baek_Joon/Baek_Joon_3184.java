import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_3184 {
    static int R,C;
    static String[][] yard;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] answer = {0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] R_C = br.readLine().split(" ");
        R = Integer.parseInt(R_C[0]);
        C = Integer.parseInt(R_C[1]);

        yard = new String[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                yard[i][j] = input[j];
            }
        }
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if((yard[i][j].equals("o") || yard[i][j].equals("v")) && !visited[i][j]) {
                    bfs(i, j,yard[i][j]);
                }
            }
        }

        System.out.println(answer[0]+" "+answer[1]);


    }

    static void bfs(int x, int y, String type) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        visited[x][y] = true;
        int sheep = 0;
        int wolf = 0;        

        if(type.equals("o")) sheep++;
        else if(type.equals("v")) wolf++;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && !yard[nx][ny].equals("#")) {
                    visited[nx][ny] = true;

                    if(yard[nx][ny].equals("o")) {
                        sheep++;
                    }
                    else if(yard[nx][ny].equals("v")) {
                        wolf++;
                    }
                    
                    queue.offer(new Node(nx, ny));
                    
                }
            }
        }

        if(sheep > wolf) answer[0] += sheep;
        else answer[1] += wolf;
        
    }

    public static class Node {
        public int x,y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
