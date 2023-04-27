import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt(); // number of players
            Player[] players = new Player[n];
            for (int j = 0; j < n; j++) {
                String name = scanner.next();
                int[] fingers = new int[n - 1];
                for (int k = 0; k < n - 1; k++) {
                    fingers[k] = scanner.nextInt();
                }
                players[j] = new Player(name, fingers);
            }
            List<String> eliminated = new ArrayList<>();
            while (players.length > 1) {
                int sum = 0;
                for (Player player : players) {
                    sum += player.chooseFingers();
                }
                int count = 0;
                int index = 0;
                while (count < sum) {
                    Player player = players[index];
                    if (player.isEliminated()) {
                        index++; // skip eliminated players
                        if (index >= players.length) {
                            index = 0; // wrap around
                        }
                    } else {
                        count++;
                        if (count == sum) {
                            player.eliminate();
                            eliminated.add(player.getName());
                        }
                        index++;
                        if (index >= players.length) {
                            index = 0; // wrap around
                        }
                    }
                }
                players = getRemainingPlayers(players);
            }
            System.out.print("Case " + i + ": ");
            for (String name : eliminated) {
                System.out.print(name + " ");
            }
            System.out.println(players[0].getName());
        }
    }

    private static Player[] getRemainingPlayers(Player[] players) {
        List<Player> remaining = new ArrayList<>();
        for (Player player : players) {
            if (!player.isEliminated()) {
                remaining.add(player);
            }
        }
        return remaining.toArray(new Player[0]);
    }
}

class Player {
    private String name;
    private int[] fingers;
    private int index;
    private boolean eliminated;

    public Player(String name, int[] fingers) {
        this.name = name;
        this.fingers = fingers;
        this.index = 0;
        this.eliminated = false;
    }

    public String getName() {
        return name;
    }

    public int chooseFingers() {
        int result = fingers[index];
        index++;
        if (index >= fingers.length) {
            index = 0; // wrap around
        }
        return result;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void eliminate() {
        eliminated = true;
    }
}
