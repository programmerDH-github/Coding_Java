import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16955 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[10][10];

        for(int i = 0; i < 10; i++) {
            String[] stone = br.readLine().split("");
            for(int j = 0; j < 10; j++) {
                board[i][j] = stone[j];
            }
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int di = i;
                int dj = j;

                boolean visited = false;
                if(board[i][j].equals(".")) {
                    
                    int count = 1;
                    visited = true;
                    // 아래
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj;

                        if(ni >= 10 || nj >= 10) break;
                        if(!board[ni][nj].equals("X")) break;
                        else {
                            di = ni;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    // 오른쪽
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di;
                        int nj = dj + 1;

                        if(ni >= 10 || nj >= 10) break;
                        if(!board[ni][nj].equals("X")) break;
                        else {
                            dj = nj;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    // 대각선
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj + 1;

                        if(ni >= 10 || nj >= 10) break;
                        if(!board[ni][nj].equals("X")) break;
                        else {
                            di = ni;
                            dj = nj;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    // 대각선
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj - 1;

                        if(ni >= 10 || nj < 0) break;
                        if(!board[ni][nj].equals("X")) break;
                        else {
                            di = ni;
                            dj = nj;
                        }
                        count++;
                    }
                }
                else if(board[i][j].equals("X")) {
                    int count = 1;
                    visited = false;

                    // 아래
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj;

                        if(ni >= 10 || nj >= 10) break;
                        if(board[ni][nj].equals(".")) {
                            if(!visited) {
                                visited = true;
                                di = ni;
                            }
                            else break;
                        }
                        else if(board[ni][nj].equals("O")) break;
                        else {
                            di = ni;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    visited = false;
                    // 오른쪽
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di;
                        int nj = dj + 1;

                        if(ni >= 10 || nj >= 10) break;
                        if(board[ni][nj].equals(".")) {
                            if(!visited) {
                                visited = true;
                                dj = nj;
                            }
                            else break;
                        }
                        else if(board[ni][nj].equals("O")) break;
                        else {
                            dj = nj;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    visited = false;
                    // 대각선
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj + 1;

                        if(ni >= 10 || nj >= 10) break;
                        if(board[ni][nj].equals(".")) {
                            if(!visited) {
                                visited = true;
                                di = ni;
                                dj = nj;
                            }
                            else break;
                        }
                        else if(board[ni][nj].equals("O")) break;
                        else {
                            di = ni;
                            dj = nj;
                        }
                        count++;
                    }

                    di = i;
                    dj = j;
                    count = 1;
                    visited = false;
                    // 대각선
                    while(true) {
                        if(count == 5) {
                            System.out.println("1");
                            return;
                        }

                        int ni = di + 1;
                        int nj = dj - 1;

                        if(ni >= 10 || nj < 0) break;
                        if(board[ni][nj].equals(".")) {
                            if(!visited) {
                                visited = true;
                                di = ni;
                                dj = nj;
                            }
                            else break;
                        }
                        else if(board[ni][nj].equals("O")) break;
                        else {
                            di = ni;
                            dj = nj;
                        }
                        count++;
                    }

                }
            }
        }

        System.out.println("0");
    }
}
