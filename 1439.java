import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] binary = sc.next().split("");

        int count = 1;
        for (int i = 1; i < binary.length; i++) {
            if (!binary[i - 1].equals(binary[i])) {
                count++;
            }
        }

        System.out.println(count / 2);
    }
}
