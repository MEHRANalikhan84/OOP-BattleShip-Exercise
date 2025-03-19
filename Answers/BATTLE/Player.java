public class Player {
    private String name;
    private Board board;
    private Ship[] ships;

    public Player(String name, int boardSize) {
        this.name = name;
        this.board = new Board(boardSize);
        this.ships = new Ship[4];
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (!board.placeShip(ship, row, col, horizontal)) {
            System.out.println("Failed to place " + ship.getName());
        }
    }

    public boolean makeMove(int row, int col) {
        return board.attack(row, col);
    }

    public void displayBoard() {
        board.displayBoard();
    }
}

