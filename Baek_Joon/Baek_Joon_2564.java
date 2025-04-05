import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2564 {
    static boolean[][] visited;
    static int targetX,targetY,X,Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] targetY_targetX = br.readLine().split(" ");
        Y = Integer.parseInt(targetY_targetX[0]);
        X = Integer.parseInt(targetY_targetX[1]);

        int storeCount = Integer.parseInt(br.readLine());
        int[][] location = new int[storeCount][2];
        for(int i = 0; i < storeCount; i++) {
            String[] input = br.readLine().split(" ");
            // 북
            if(input[0].equals("1")) {
                location[i][0] = 0;
                location[i][1] = Integer.parseInt(input[1]);
            }
            // 남
            else if(input[0].equals("2")) {
                location[i][0] = X;
                location[i][1] = Integer.parseInt(input[1]);
            }
            // 서
            else if(input[0].equals("3")) {
                location[i][0] = Integer.parseInt(input[1]);
                location[i][1] = 0;
            }
            // 동
            else {
                location[i][0] = Integer.parseInt(input[1]);
                location[i][1] = Y;
            }
            
        }

        String[] input = br.readLine().split(" ");
        targetX = 0;
        targetY = 0;
        // 북
        if(input[0].equals("1")) {
            targetY = Integer.parseInt(input[1]);
        }
        // 남
        else if(input[0].equals("2")) {
            targetX = X;
            targetY = Integer.parseInt(input[1]);
        }
        // 서
        else if(input[0].equals("3")) {
            targetX = Integer.parseInt(input[1]);
            targetY = 0;
        }
        // 동
        else {
            targetX = Integer.parseInt(input[1]);
            targetY = Y;
        }

        

        int answer = 0;
        for(int i = 0; i < storeCount; i++) {
            visited = new boolean[X+1][Y+1];
            for(int j = 1; j < X; j++) {
                for(int z = 1; z < Y; z++) {
                    visited[j][z] = true;
                }                
            }

            answer += bfs(location[i][0], location[i][1]);
            // System.out.println(bfs(location[i][0], location[i][1]));
        }

        System.out.println(answer);

    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == targetX && node.y == targetY) {
                if(min > node.move) min = node.move;
                return node.move;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx <= X && nx >= 0 && ny <= Y && ny >= 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.move+1));
                }

            }

        }
        
        return min;
    }

    static class Node{
        int x;
        int y;
        int move;

        Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
        
    }

}
