package labs.lab5;

public class ConnectFourGame implements Game {

    private char[][] board = new char[6][7];
    private int turn = 0;
    private char lastplayed;
    private char y = 'y';
    private char r = 'r';

    public ConnectFourGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean isValidMove(String move) {
        try{
            int column = Integer.parseInt(move.charAt(0) + "");
            Character player = move.charAt(1);
            if (player == lastplayed){
                return false;
            }
            if (player != 'y' && player != 'r'){
                return false;
            }
            if (column < 0 || column > 6) {
                return false;
            }
            for (int i = 5; i >= 0; i--) {
                if (board[i][column] == ' ') {
                    return true;
                }
            }
            return false;}
        catch(NumberFormatException ex){
            return false;
        }
    }

    @Override
    public void executeMove(String move) {
        int column = Integer.parseInt(move.charAt(0) + "");
        char mark = move.charAt(1);
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = mark;
                break;
            }
        }
        turn += 1;
        lastplayed = mark;
    }

    @Override
    public boolean gameOver() {
        if (checkWin(y)) {
            return true;
        }
        if (checkWin(r)) {
            return true;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String displayBoard() {
    StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0 && (i < 6 && i > 0)){
                    sb.append("---------------------------" + System.lineSeparator());
                }
                if (j == 0){
                    sb.append(" " + board[i][j] + " | ");
                }
                else if (j == 6){
                    sb.append(board[i][j] + " ");
                }
                else{
                    sb.append(board[i][j] + " | ");
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public int determineWinner() {
        if(checkWin(y)){
            if (turn % 2 == 0){
                return 2;
            }
            else{
                return 1;
            }
        }
        if(checkWin(r)){
            if (turn % 2 == 0){
                return 2;
            }
            else{
                return 1;
            }
        }
        return 0;
    }

    private boolean checkWin(char piece) {
        for (int j = 0; j < 7 - 3; j++ ){
            for (int i = 0; i < 6; i++){
                if (this.board[i][j] == piece && 
                    this.board[i][j] == this.board[i][j+1] && 
                    this.board[i][j+1] == this.board[i][j+2] && 
                    this.board[i][j+2] == this.board[i][j+3]){
                    return true;
                }           
            }
        }
        for (int i = 0; i < 6 - 3; i++ ){
            for (int j = 0; j < 7; j++){
                if (this.board[i][j] == piece && 
                    this.board[i][j] == this.board[i+1][j] && 
                    this.board[i+1][j] == this.board[i+2][j] && 
                    this.board[i+2][j] == this.board[i+3][j]){
                    return true;
                }           
            }
        } 
        for (int row = 0; row < 6 - 3; row++){
            for (int col = 0; col < 7 - 3; col++){
                if (piece == board[row][col] &&
                    piece == board[row + 1][col + 1] && 
                    piece == board[row + 2][col + 2] && 
                    piece == board[row + 3][col + 3]){
                    return true;
                }
            }
        }
        for (int row = 0; row < 6 - 3; row++){
            for (int col = 3; col < 7; col++){
                if (piece == board[row][col] &&
                    piece == board[row + 1][col - 1] && 
                    piece == board[row + 2][col - 2] && 
                    piece == board[row + 3][col - 3])
                {
                    return true;
                }
            }
        }
        return false;
    }
}