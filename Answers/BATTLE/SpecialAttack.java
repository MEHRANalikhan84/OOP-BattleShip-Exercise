public class SpecialAttack {

    public static void radarScan(Board enemyBoard) {
        System.out.println("Radar scan activated!");
        char[][] grid = enemyBoard.getGrid();
        for (int i = 0; i < enemyBoard.getSize(); i++) {
            for (int j = 0; j < enemyBoard.getSize(); j++) {
                if (grid[i][j] == 'S') {
                    System.out.println("Ship detected at: " + (char) ('A' + j) + i);
                }
            }
        }
    }


    public static void multiStrike(Board enemyBoard, int row, int col) {
        System.out.println("Multi-Strike attack!");

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int targetRow = row + i;
                int targetCol = col + j;
                if (targetRow >= 0 && targetRow < enemyBoard.getSize() && targetCol >= 0 && targetCol < enemyBoard.getSize()) {
                    if (enemyBoard.attack(targetRow, targetCol)) {
                        System.out.println("Hit at: " + (char) ('A' + targetCol) + targetRow);
                    } else {
                        System.out.println("Miss at: " + (char) ('A' + targetCol) + targetRow);
                    }
                }
            }
        }
    }
}
