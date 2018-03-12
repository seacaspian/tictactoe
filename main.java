import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Declare important arrays and set up input
		char[] [] board = new char[3] [3];
		int [] playerMove = new int [2];	
		char turn = 'X';
		Scanner input = new Scanner(System.in);
		
		do {	
			System.out.println("A new game has begun!");
			initializeArray(board);
			turn = 'X';
			for (int plays = 0; plays < 9; plays++) {
				do {
					printBoard(board);
					System.out.println("Player " + turn + " select row:");
					playerMove[0] = input.nextInt();
					System.out.println("Player " + turn + " select column:");
					playerMove[1] = input.nextInt();
				} while (validMove(board, playerMove, turn) == false);
				board[playerMove[0]-1][playerMove[1]-1] = turn;
				if (hasWinner(board, turn) == false)
					turn = changePlayer(turn);
				else
					break;
			} 
		} while(hasWinner(board,turn) == false);
		System.out.println("We have a winner! Congratulations player " + turn + "!");
		printBoard(board);
		input.close();
	}

	public static boolean hasWinner(char[][] board, char player) {
// Check the rows 
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
				return true;
		}
// Check the columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
				return true;
		}
// Check diagonal
			if (board[1][1] == player)
				if ((board[0][0] == player && board[2][2] == player) || (board[0][2] == player && board[2][0] == player) )
					return true;
			return false;
		}
	
	public static void printBoard(char[] [] board) {
		for (int x = 0; x < board.length; x++ ) {
			for (int y = 0; y < board[x].length; y++)
					System.out.print(board[x] [y] + " ");
			System.out.println("");
		}
	}
	
	public static void initializeArray(char[][] board) {
		for (int x = 0; x < board.length; x++)
			for (int y = 0; y < board[x].length; y++)
				board [x] [y] = '*';
	}
	public static boolean validMove(char[][] board, int [] playerMove, char player) {
		for (int i = 0; i < 2; i++) 	
			if (playerMove[i] < 1 || playerMove[i] > 3) {
				System.out.println("An invalid selection has been made");
				return false;}
			else	
				if (board[playerMove[0]-1][playerMove[1]-1] != '*') {
					System.out.println("An invalid selection has been made");
					return false;}
				else
					return true;
		return false;
	}
	
	public static char changePlayer(char player) {
		if (player ==  'X')
			return 'O';
		else if (player == 'O')
			return 'X';
		return 'X';	
	}
}

