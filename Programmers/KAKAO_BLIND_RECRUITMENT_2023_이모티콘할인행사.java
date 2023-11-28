package Programmers;

public class KAKAO_BLIND_RECRUITMENT_2023_이모티콘할인행사 {
    static int[] sale;
    static int[] answer = new int[2];
    public static void main(String[] args) {
        // int[][] users = {{40, 10000}, {25, 10000}};
        // int[] emoticons = {7000, 9000};
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        sale = new int[emoticons.length];

        combi(users,emoticons,0);

        System.out.println(answer[0] +" "+answer[1]);

    }
    
    public static void combi (int[][] users, int[] emoticons, int start) {
        if(start == emoticons.length) {            
            cal(users,emoticons);
            return;
        }

        for(int i = 10; i <= 40; i += 10) {
            sale[start] = i;
            combi(users, emoticons, start+1);
        }
    }

    public static void cal (int[][] users, int[] emoticons) {
        int join_count = 0;
        int sale_users_sum = 0;

        for(int i = 0; i < users.length; i++) {
            int sale_user = 0;
            for(int j = 0; j < emoticons.length; j++) {
                if(users[i][0] <= sale[j]) {
                    sale_user += (emoticons[j]/100) * (100-sale[j]);
                }

                if(users[i][1] <= sale_user) {
                    join_count++;
                    sale_user = 0;
                    break;
                }
            }
            sale_users_sum += sale_user;
        }

        if(answer[0] < join_count) {
            answer[0] = join_count;
            answer[1] = sale_users_sum;
        }
        else if(answer[0] == join_count && answer[1] < sale_users_sum) {
            answer[1] = sale_users_sum;
        }

    }
}