import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int res = (int) (2 * Math.ceil((double) (n - b) / (double) (b - a)) + 1);
        System.out.println(res);
    }
}
