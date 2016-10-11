import java.util.Scanner;

/**
 * Created by zaclee on 10/1/16.
 */
public class UserInput {

    Scanner scan = new Scanner(System.in);

    public String promptString() {
        return scan.next();
    }

    int promptInt() {
        return scan.nextInt();
    }

    void displayString(String str) {
        System.out.println(str);
    }


}
