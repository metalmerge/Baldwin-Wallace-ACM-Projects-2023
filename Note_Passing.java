import java.util.Scanner;

public class PaulaMessage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        input.nextLine();
        for (int i = 1; i <= numCases; i++) {
            String note1 = input.nextLine();
            String note2 = input.nextLine();
            String deciphered = "";
            for (int j = 0; j < note1.length(); j++) {
                char c1 = note1.charAt(j);
                char c2 = note2.charAt(j);
                if (c1 < c2) {
                    deciphered += c1;
                } else if (c2 < c1) {
                    deciphered += c2;
                } else {
                    deciphered += c1;
                }
            }
            System.out.println("Case " + i + ": " + deciphered);
        }
        input.close();
    }
}
