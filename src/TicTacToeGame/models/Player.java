package TicTacToeGame.models;

import java.util.Scanner;

public class Player {

    private int id;
    private String name;
    private PlayerType playerType;
    private char symbol;

    private Scanner sc = new Scanner(System.in);

    public Player(int id, String name, PlayerType playerType, char symbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Cell makeMove(Board board) {
        System.out.println(this.name+", It's your turn to make the move. Enter the row and col ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        while(!validateMove(row, col, board)) {
            System.out.println("Invalid move "+this.name+".  Enter row and col ");
            row = sc.nextInt();
            col = sc.nextInt();
        }

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        return cell;
    }

    private boolean validateMove(int row, int col, Board board) {
        if(row >= board.getDimension()) {
            return false;
        }

        if(col >= board.getDimension()) {
            return false;
        }

        if(CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellState())) {
            return false;
        }

        return true;
    }
}
