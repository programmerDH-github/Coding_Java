package Programmers;

public class PCCE_기출문제_1번_동영상_재생기 {
    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = {"next", "prev"};

        
        String[] video_arr = video_len.split(":");
        String[] pos_arr = pos.split(":");
        String[] op_start_arr = op_start.split(":");
        String[] op_end_arr = op_end.split(":");
        
        int video_int = Integer.parseInt(video_arr[0]) * 60 + Integer.parseInt(video_arr[1]);
        int pos_int = Integer.parseInt(pos_arr[0]) * 60 + Integer.parseInt(pos_arr[1]);
        int op_start_int = Integer.parseInt(op_start_arr[0]) * 60 + Integer.parseInt(op_start_arr[1]);
        int op_end_int = Integer.parseInt(op_end_arr[0]) * 60 + Integer.parseInt(op_end_arr[1]);
        
        for(int i = 0; i < commands.length; i++) {            
            if(pos_int < 0) pos_int = 0;
            if(pos_int > video_int) pos_int = video_int;
            if(op_start_int <= pos_int && pos_int <= op_end_int) pos_int = op_end_int;
            
            if(commands[i].equals("prev")) {
                pos_int -= 10;
            }
            else if(commands[i].equals("next")){
                pos_int += 10;
            }            
        }
        
        if(op_start_int <= pos_int && pos_int <= op_end_int) pos_int = op_end_int;
        if(pos_int < 0) pos_int = 0;
        if(pos_int > video_int) pos_int = video_int;
        
        String answer = String.format("%02d",(pos_int/60)) + ":" + String.format("%02d",(pos_int%60));
        
        System.out.println(answer);
    }
}