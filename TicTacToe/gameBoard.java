package TicTacToe;

public class gameBoard {
    final int WIDTH = 3, HEIGHT = 3;
    int i,j;
    gameSquare[][] board = new gameSquare[WIDTH][HEIGHT];
    
    gameBoard () {
       for(i=0; i < WIDTH; i++) {
           for(j=0; j < HEIGHT; j++) {
               char content = (char)(j + 3*i + 1 + '0');
               this.board[i][j] = new gameSquare(i, j, content);
           }
       } 
    }

    public void printGameBoard() {
        for(i=0; i < WIDTH; i++) {
            System.out.println("+-----+");
            System.out.print("|");
            for(j=0; j < HEIGHT; j++) {
                System.out.print(this.board[i][j].getContent()+"|");
            }
            System.out.println();
        } 
        System.out.println("+-----+");
    }

    public void setPlayerChoice(int position) {
        if (this.board[(position - 1) / 3][(position - 1) % 3].getContent() == 'X' ||
            this.board[(position - 1) / 3][(position - 1) % 3].getContent() == '0') {
                System.out.println("Not a valid option. Try again.");
        }
        else {
            this.board[(position - 1) / 3][(position - 1) % 3].setContent('X');
        }
    }

    public void setComputerChoice(int position) {
        this.board[(position - 1) / 3][(position - 1) % 3].setContent('O');
    }

    private char checkWinnerByRow() {
        // System.out.println("enter row check");

        for (i=0; i < this.HEIGHT; i++) {
            for (j=0; j < this.WIDTH; j++) {
                if (j == this.WIDTH -1) {
                    return this.board[i][j].getContent();
                  
                }
                if (this.board[i][j].getContent() != this.board[i][j+1].getContent()) {
                    // System.out.println("LOL BRAK ASAP ROW");
                    break;
                }
            } 
        }
        // System.out.println("exit row check, return ' '");

        return ' ';
    }

    private char checkWinnerByColumn() {
        // System.out.println("enter col check");

        for (j=0; j<WIDTH; j++) {
            for (i=0; i < this.WIDTH; i++) {
                if (i == this.HEIGHT - 1) {
                    return this.board[i][j].getContent();
                }
                if (this.board[i][j].getContent() != this.board[i+1][j].getContent()) {
                //    System.out.println("LOL BREAK ASAP COL");
                    break;
                }
            } 
        }
        // System.out.println("exit col check, return ' '");

        return ' ';
    }

    private char checkWinnerDiagonical() {
        // System.out.println("enter diag check");
        if ((this.board[0][0].getContent() == this.board[1][1].getContent()) && (this.board[2][2].getContent() == this.board[1][1].getContent()))
            return this.board[0][0].getContent();
        else 
            return ' ';
    }
    
    public char checkWinner() {
        char winner = checkWinnerByRow();
        if (winner == ' ')
            winner = checkWinnerByColumn();
        if (winner == ' ') 
            winner = checkWinnerDiagonical();
        return winner;
    }

}