
import java.util.*;

public class Two {

    public static void main(String[] args) {
        int num;
        int even = 0;
        int odd = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            num = input.nextInt();
            if (num == -1) {
                break;
            }

            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Odd number = " + odd + " and Even number = " + even);
    }
}
