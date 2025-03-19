import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean isPlayer1Turn;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name, 10);
        player2 = new Player(player2Name, 10);
        isPlayer1Turn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("It's " + (isPlayer1Turn ? player1.getName() : player2.getName()) + "'s turn.");
            if (isPlayer1Turn) {
                player1.displayBoard();
                System.out.println("Enter the row and column to attack (e.g. A1): ");
                String target = scanner.next();
                int row = target.charAt(1) - '0';
                int col = target.charAt(0) - 'A';

                if (player1.makeMove(row, col)) {
                    System.out.println("Hit!");
                } else {
                    System.out.println("Miss!");
                }


                SpecialAttack.radarScan(player2.getBoard());
                SpecialAttack.multiStrike(player2.getBoard(), row, col);

            } else {
                player2.displayBoard();
                System.out.println("Enter the row and column to attack (e.g. A1): ");
                String target = scanner.next();
                int row = target.charAt(1) - '0';
                int col = target.charAt(0) - 'A';

                if (player2.makeMove(row, col)) {
                    System.out.println("Hit!");
                } else {
                    System.out.println("Miss!");
                }
            }
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    public static void main(String[] args) {
        Game game = new Game("Player 1", "Player 2");
        game.start();
    }
}

