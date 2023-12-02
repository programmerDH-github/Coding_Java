public class Baek_Joon_4673 {
    static boolean[] self;
    public static void main(String[] args) {
        self = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int number = d(i);
            
            if(number < 10001) self[number] = true;
        }
        
        for(int i = 1; i <= 10000; i++) {
            if(!self[i]) System.out.println(i);
        }
    }

    public static int d(int num) {
        int sum = num;

        while(num != 0) {
            sum = sum + num%10;
            num = num/10;
        }

        // String[] n = (num+"").split("");
        // for(int i = 0; i < n.length; i++) {
        //     sum += Integer.parseInt(n[i]);
        // }
        
        return sum;
    }
}
