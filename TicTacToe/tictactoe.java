package TicTacToe;
import java.util.Scanner;


public class tictactoe {

    public static void main(String[] args) {
        gameBoard board = new gameBoard();
        Scanner sc = new Scanner(System.in);

        board.printGameBoard();

        for(;;) {
            board.setPlayerChoice(sc.nextInt());
            char x = board.checkWinner();
            if (x != ' ') System.out.println("Winner: "+ x);;
            board.printGameBoard();
        }
    }
}