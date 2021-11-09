import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int [] a = new int [n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            HashMap<Integer, Integer> c = new HashMap<>();
            for (int j = n-1; j > 1; j--) {
                for (int i = 1; i < j; i++) {
                    for (int k = j; k < n; k++) {
                        if (c.containsKey(a[k]) && a[k] == 2 * a[j] - a[i]) {
                            int count = c.get(a[k]);
                            count++;
                            c.put(a[k], count);
                        } else if (a[k] == 2 * a[j] - a[i]) {
                            c.put(a[k], 1);
                        }
                    }
                }
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
                res += entry.getValue();
            }
            System.out.println(res);

        }
    }
}
