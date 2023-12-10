import java.io.*;

public class Baek_Joon_15596 {
    public static long sum(int[] a) {
        long all  = 0;
        for(int i = 0; i < a.length; i++) {
            all += a[i];
        }
        return all;
    }
}