package labs.lab5;

public class TicTacToeGame implements Game{

    /**
    board a 3x3 array containing 0, 1, 2, values indicating
    blanks or player numbers
    */
    private char[][] board = new char[3][3];
    private int turn = 0;
    private char x = 'x';
    private char o = 'o';
    private char lastplayed;

    public TicTacToeGame(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean isValidMove(String move) {
        try{
            int row = Integer.parseInt(move.charAt(0) + "");
            int column = Integer.parseInt(move.charAt(1) + "");
            Character player = move.charAt(2);
            if (player == lastplayed){
                return false;
            }
            if (player != 'x' && player != 'o'){
                return false;
            }
            if (row > 2 || row < 0){
                return false;
            }
            if (column > 2 || column < 0){
                return false;
            }
            if (board[row][column] == ' '){
                return true;
            }
            return false;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }

    @Override
    public void executeMove(String move) {
        int row = Integer.parseInt(move.charAt(0) + "");
        int column = Integer.parseInt(move.charAt(1) + "");
        char mark = move.charAt(2);
        board[row][column] = mark;
        turn += 1;
        lastplayed = mark;
    }

    @Override
    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0 && (i < 3 && i > 0)){
                    sb.append("-----------" + System.lineSeparator());
                }
                if (j == 0){
                    sb.append(" " + board[i][j] + " | ");
                }
                else if (j == 2){
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
    public boolean gameOver() {
        if (checkWin(x)) {
            return true;
        }
        if (checkWin(o)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int determineWinner() {
        if(checkWin(x)){
            if (turn % 2 == 0){
                return 2;
            }
            else{
                return 1;
            }
        }
        if(checkWin(o)){
            if (turn % 2 == 0){
                return 2;
            }
            else{
                return 1;
            }
        }
        return 0;
    }

    private boolean checkWin(char piece){
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == piece){
            return true;
            }
        else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == piece){
            return true;
            }
        else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == piece){
            return true;
            }
        else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == piece){
            return true;
            }
        else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == piece){
            return true;
            }
        else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == piece){
            return true;
            }
        else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == piece){
            return true;
            }
        else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == piece){
            return true;
            }
        else{
            return false;
        }
    }

}

