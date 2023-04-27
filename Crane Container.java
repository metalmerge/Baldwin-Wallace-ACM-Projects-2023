import java.util.Scanner;

public class ContainerShip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt(); // number of stacks
            int[] stacks = new int[n]; // array to store stack heights
            for (int j = 0; j < n; j++) {
                stacks[j] = scanner.nextInt(); // initial stack heights
            }

            int s = scanner.nextInt(); // number of instructions
            scanner.nextLine(); // consume newline character

            int cranePos = 0; // initial position of crane
            boolean holdingContainer = false; // initially not holding a container
            StringBuilder sb = new StringBuilder(); // to store output of '*' instructions

            for (int j = 0; j < s; j++) {
                String instruction = scanner.nextLine();
                switch (instruction) {
                    case ">":
                        if (cranePos < n - 1) {
                            cranePos++;
                        }
                        break;
                    case "<":
                        if (cranePos > 0) {
                            cranePos--;
                        }
                        break;
                    case "+":
                        if (!holdingContainer && stacks[cranePos] > 0) {
                            stacks[cranePos]--;
                            holdingContainer = true;
                        }
                        break;
                    case "-":
                        if (holdingContainer && stacks[cranePos] < 20) {
                            stacks[cranePos]++;
                            holdingContainer = false;
                        }
                        break;
                    case "*":
                        sb.append(stacks[cranePos]).append(" ");
                        break;
                }
            }

            System.out.println("Case " + i + ": " + sb.toString().trim());
        }

        scanner.close();
    }
}
