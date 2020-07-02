package TicTacToe;

public class gameSquare {
    int posX, posY;
    char content;
    gameSquare() {}
    gameSquare(int x, int y, char content) {
        this.posX = x;
        this.posY = y;
        this.content = content;
    }

    public void setContent (char content) {
        this.content = content;
    }

    public char getContent () {
        return this.content;
    }

}