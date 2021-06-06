import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Createing 3 x 3 Array Board
        char[][] board = new char[3][3];

       //Create [?,?,?] Board Here
       //       [?,?,?]
       //       [?,?,?]

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '?';
            }
        }

        //We Create Scanner Here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String player_1 = scanner.nextLine();
        System.out.print("Player 2, what is your name? ");
        String player_2 = scanner.nextLine();

        // if Player1 Win Player2 Is lose
        boolean Player1 = true;

        // if Game_End_Statement == 1 Game İs Over
        int game_end_statement = 0;

        while(game_end_statement == 0) {

            //Create Board Function Called
            draw_board(board);

            //
            if(Player1) {
                System.out.println(player_1 + "'s Turn (x):");
            } else {
                System.out.println(player_2 + "'s Turn (o):");
            }

            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            char c = '?';
            if(Player1) {
                c = 'x';
            } else {
                c = 'o';
            }

            //Create row and columun variables which represent indexes that correspond to a position on our board
            int row = 0;
            int column = 0;


            while(true) {


                System.out.print("Enter a row number (0, 1, or 2): ");
                row = scanner.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                column = scanner.nextInt();


                if(row < 0 || column < 0 || row > 2 || column > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                    
                } else if(board[row][column] != '?E') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                    
                } else {
                    break;
                }

            }
            board[row][column] = c;

            //Check Which Players Has Won
            if(player_has_won(board) == 'x') {
                System.out.println(player_1 + " has won!");
                game_end_statement = 1;
            } else if(player_has_won(board) == 'o') {
                System.out.println(player_2 + " has won!");
                game_end_statement = 1;
            } else {


                if(board_ıs_full(board)) {
                    System.out.println("It's a tie!");
                    game_end_statement = 1;
                } else {

                    Player1 = !Player1;
                }

            }

        }

        //Draw the board at the end of the game
        draw_board(board);

    }


    public static void draw_board(char[][] board) {
        System.out.println("Board:");
        for(int i = 0; i < 3; i++) {
            //The inner for loop prints out each row of the board
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            //This print statement makes a new line so that each row is on a separate line
            System.out.println();
        }
    }


    public static char player_has_won(char[][] board) {
        
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }
        
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }
        
        return ' ';

    }

    
    public static boolean board_ıs_full(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}