import java.util.Scanner;

public class TaskI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xr = Integer.MIN_VALUE;
        int xl = Integer.MAX_VALUE;
        int yl = Integer.MAX_VALUE;
        int yr = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int h = sc.nextInt();
            if (x - h < xl) {
                xl = x - h;
            }
            if (x + h > xr) {
                xr = x + h;
            }
            if (y - h < yl) {
                yl = y - h;
            }
            if (y + h > yr) {
                yr = y + h;
            }
        }
        long h = (long) (Math.ceil((double) Math.max(xr - xl, yr - yl) / (double) 2));
        long x = (xl + xr) / 2;
        long y = (yl + yr) / 2;
        System.out.println(x + " " + y + " " + h);
    }
}
