import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bowling = br.readLine();
        
        String[] frame = new String[10];
        int[] score = new int[10];

        int i = 0;
        int j = 0;
        while(i < 10 && j < bowling.length()) {
            if(i == 9) {
                frame[i] = bowling.substring(j);
                break;
            }

            if(bowling.charAt(j) == 'S') {
                frame[i] = "S";
                i++;
                j++;
            }
            else {
                frame[i] = bowling.charAt(j) +""+ bowling.charAt(j+1);
                i++;
                j = j+2;
            }

        }

        for(int z = 0; z < 10; z++) {

            // 마지막 프레임
            if(z == 9) {
                if(frame[z].charAt(0) == 'S') {
                    score[z] += 10;
                    if(frame[z].charAt(1) == 'S') {
                        score[z] += 10;
    
                        if(frame[z].charAt(2) == 'S') {
                            score[z] += 10;
                        }
                        else {
                            if(frame[z].charAt(2) != '-') score[z] += frame[z].charAt(2)-'0';
                        }
    
                    }
                    else {
                        String first = frame[z].charAt(1)+"";
                        String second = frame[z].charAt(2)+"";

                        if(first.equals("-")) first = "0";
                        if(second.equals("-")) second = "0";

                        if(second.equals("P")) {
                            score[z] += 10;
                        }
                        else {
                            score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                        }


                    }

                }
                else {
                    String first = frame[z].charAt(0)+"";
                    String second = frame[z].charAt(1)+"";
                    
                    if(first.equals("-")) first = "0";
                    if(second.equals("-")) second = "0";
                    
                    if(second.equals("P")) {
                        score[z] += 10;
                        if(frame[z].charAt(2) == 'S') score[z] += 10;
                        else if(frame[z].charAt(2) != '-') score[z] += frame[z].charAt(2) - '0';
                    }
                    else {
                        score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                    }

                }


                break;
            }

            // 7번째 프레임
            if(z == 7) {
                if(frame[z].equals("S")) {
                    score[z] += 10;
                    if(frame[z+1].equals("S")) {
                        score[z] += 10;
                        if(frame[z+2].charAt(0) == 'S') {
                            score[z] += 10;
                        }
                        else {
                            if(frame[z+2].charAt(0) != '-') score[z] += frame[z+2].charAt(0) - '0';
                        }

                    }
                    else {
                        String first = frame[z+1].charAt(0)+"";
                        String second = frame[z+1].charAt(1)+"";

                        if(first.equals("-")) first = "0";
                        if(second.equals("-")) second = "0";

                        if(second.equals("P")) {
                            score[z] += 10;
                        }
                        else {
                            score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                        }
                        
                    }
                    
                }
                else {
                    String first = frame[z].charAt(0)+"";
                    String second = frame[z].charAt(1)+"";

                    if(first.equals("-")) first = "0";
                    if(second.equals("-")) second = "0";
                    
                    if(second.equals("P")) {
                        score[z] += 10;
                        if(frame[z+1].equals("S")) score[z] += 10;
                        else {
                            if(frame[z+1].charAt(0) != '-') score[z] += frame[z+1].charAt(0) - '0';
                        }

                    }
                    else {
                        score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                    }

                }

                continue;
            }

            // 8번째 프레임
            if(z == 8) {
                if(frame[z].equals("S")) {
                    score[z] += 10;
                    if(frame[z+1].charAt(0) == 'S') {
                        score[z] += 10;
                        if(frame[z+1].charAt(1) == 'S') {
                            score[z] += 10;
                        }
                        else {
                            if(frame[z+1].charAt(1) != '-') score[z] += frame[z+1].charAt(1) - '0';
                        }

                    }
                    else {
                        String first = frame[z+1].charAt(0)+"";
                        String second = frame[z+1].charAt(1)+"";

                        if(first.equals("-")) first = "0";
                        if(second.equals("-")) second = "0";

                        if(second.equals("P")) {
                            score[z] += 10;
                        }
                        else {
                            score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                        }
                        
                    }
                    
                }
                else {
                    String first = frame[z].charAt(0)+"";
                    String second = frame[z].charAt(1)+"";

                    if(first.equals("-")) first = "0";
                    if(second.equals("-")) second = "0";
                    
                    if(second.equals("P")) {
                        score[z] += 10;
                        if(frame[z+1].charAt(0) == 'S') score[z] += 10;
                        else {
                            if(frame[z+1].charAt(0) != '-') score[z] += frame[z+1].charAt(0) - '0';
                        }

                    }
                    else {
                        score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                    }

                }
                continue;
            }
            
            // 6번째 프레임까지
            if(frame[z].equals("S")) {   
                score[z] += 10;
                
                if(frame[z+1].equals("S")) {
                    score[z] += 10;

                    if(frame[z+2].equals("S")) {
                        score[z] += 10;
                    }
                    else {
                        String first = frame[z+2].charAt(0)+"";

                        if(first.equals("-")) first = "0";

                        score[z] += Integer.parseInt(first);

                    }

                }
                else {
                    String first = frame[z+1].charAt(0)+"";
                    String second = frame[z+1].charAt(1)+"";

                    if(first.equals("-")) first = "0";
                    if(second.equals("-")) second = "0";

                    if(second.equals("P")) {
                        score[z] += 10;
                    }
                    else {
                        score[z] += Integer.parseInt(first) + Integer.parseInt(second);
                    }
                     
                }

            }
            else {
                String first = frame[z].charAt(0)+"";
                String second = frame[z].charAt(1)+"";

                if(first.equals("-")) first = "0";
                if(second.equals("-")) second = "0";

                if(second.equals("P")) {
                    score[z] += 10;

                    if(frame[z+1].charAt(0) == 'S') score[z] += 10;
                    else {
                        if(frame[z+1].charAt(0) != '-') score[z] += frame[z+1].charAt(0) - '0';
                    }
                }
                else score[z] += Integer.parseInt(first) + Integer.parseInt(second);

            }
            
        }

        int answer = 0;
        for(int z = 0; z < 10; z++) {
            answer += score[z];
        }

        System.out.println(answer);

    }
}
