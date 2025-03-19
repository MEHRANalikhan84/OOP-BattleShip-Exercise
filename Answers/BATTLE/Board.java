public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeBoard();
    }

    public int getSize() {
        return size;
    }

    public char[][] getGrid() {
        return grid;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (horizontal) {
            if (col + ship.getSize() > size) return false;
            for (int i = 0; i < ship.getSize(); i++) {
                if (grid[row][col + i] != '-') return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                grid[row][col + i] = 'S';
            }
        } else {
            if (row + ship.getSize() > size) return false;
            for (int i = 0; i < ship.getSize(); i++) {
                if (grid[row + i][col] != '-') return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                grid[row + i][col] = 'S';
            }
        }
        return true;
    }

    public boolean attack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            return true;
        } else {
            grid[row][col] = 'O';
            return false;
        }
    }

    public void displayBoard() {

        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print((char)('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
