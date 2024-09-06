import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_16956 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] R_C = br.readLine().split(" ");
        int R = Integer.parseInt(R_C[0]);
        int C = Integer.parseInt(R_C[1]);

        String[][] pasture = new String[R][C];
        ArrayList<int[]> arraylist = new ArrayList<>();
        arraylist.add(new int[2]);
        for(int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                pasture[i][j] = input[j];                               
            }
        }

        sb.append(1).append("\n");
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(pasture[i][j].equals("W")) {
                    for(int z = 0; z < 4; z++) {
                        int nx = dx[z] + i;
                        int ny = dy[z] + j;

                        if(nx < R && nx >= 0 && ny < C && ny >= 0) {
                            if(pasture[nx][ny].equals("S")) {
                                System.out.println(0);
                                return;
                            }
                        }
                    }

                }
                else if(pasture[i][j].equals(".")){
                    pasture[i][j] = "D";
                }   
                sb.append(pasture[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
