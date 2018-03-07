package mandatory_assignment_4;

import java.util.Arrays;

import java.util.Scanner;



class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}
}


class Board {
	
	static String[][] board;
	
	Board() {
		board = new String[][] {
				{" ", " ", "0", "1", "2", "3", "4", "5", "6", "7", " "},
				{" ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "+"},
				{"0", "|", " ", "1", " ", "1", " ", "1", " ", "1", "|"},
				{"1", "|", "1", " ", "1", " ", "1", " ", "1", " ", "|"},
				{"2", "|", " ", "1", " ", "1", " ", "1", " ", "1", "|"},
				{"3", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
				{"4", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
				{"5", "|", "2", " ", "2", " ", "2", " ", "2", " ", "|"},
				{"6", "|", " ", "2", " ", "2", " ", "2", " ", "2", "|"},
				{"7", "|", "2", " ", "2", " ", "2", " ", "2", " ", "|"},
				{" ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "+"}
		};
	}
	
	void printBoard() {
		System.out.println(Arrays.deepToString(board).replace("], ", "\n").replace("[[", "").replace("]]", "").replace("[",  "").replace(",", ""));
	}
	
	String get(int x, int y) {
		return board[y+2][x+2];
	}
	
}


abstract class Token {
	
	Board board;
	
	int x1;					//Coordinates of token
	int y1;
	
	int xp1;					//First possible position
	int yp1;
	int xp2;					//Second possible position
	int yp2;
	
	int x2;					//New coordinates of token
	int y2;
	
	boolean exception;
	
	Scanner s = new Scanner(System.in);
	
	Token() {
		this.x1 = 0;
		this.y1 = 0;
	}
	
	abstract void enterCoordinates() throws MyException;
	abstract void possiblePositions();
	
	void setBoard(Board x) {
		board = x;
	}
	
	boolean checkOccupation(int yp, int xp) {						//false if occupied
		if ( board.get(xp, yp).equals("1") || board.get(xp, yp).equals("2") ) {
			return false;
		} else { return true; }
	}
	
	void enterNewCoordinates() throws MyException {
		System.out.print("Enter X: ");
		
		x2 = s.nextInt();
		
		System.out.print("Enter Y: ");
		
		y2 = s.nextInt();
		
		if ( !( ((x2 == 0) || (x2 == 1) || (x2 == 2) || (x2 == 3) || (x2 == 4) || (x2 == 5) || (x2 == 6) || (x2 == 7)) && ((y2 == 0) || (y2 == 1) || (y2 == 2) || (y2 == 3) || (y2 == 4) || (y2 == 5) || (y2 == 6) || (y2 == 7)) ) ) {
			exception = true;
			throw new MyException("Invalid coordinate!");
		} else {
			if ( (this.checkOccupation(yp1, xp1) && (x2 == xp1) && (y2 == yp1)) || (this.checkOccupation(yp2, xp2) && (x2 == xp2) && (y2 == yp2)) ) {
				exception = false;
			} else {
				exception = true;
				throw new MyException("Invalid coordinate!");
				}
		}
	}
	
	abstract void moveToken();
	
}


class Token_1 extends Token {
	
	@Override
	void enterCoordinates() throws MyException{
		System.out.print("Enter X: ");
		
		x1 = s.nextInt();
		
		System.out.print("Enter Y: ");
		
		y1 = s.nextInt();
		
		if ( !( ((x1 == 0) || (x1 == 1) || (x1 == 2) || (x1 == 3) || (x1 == 4) || (x1 == 5) || (x1 == 6) || (x1 == 7)) && ((y1 == 0) || (y1 == 1) || (y1 == 2) || (y1 == 3) || (y1 == 4) || (y1 == 5) || (y1 == 6) || (y1 == 7)) ) ) {
			exception = true;
			throw new MyException("Invalid coordinate!");
		} else {
			if ( (board.get(x1, y1)).equals("1") ) {
				exception = false;
			} else {
				exception = true;
				throw new MyException("Invalid coordinate!");
				}
		}
	}
	
	@Override
	void possiblePositions() {
		xp1 = (x1 - 1);
		yp1 = (y1 + 1);
		
		xp2 = (x1 + 1);
		yp2 = (y1 + 1);
	}

	@Override
	void moveToken() {
		board.board[y1+2][x1+2] = " ";
		board.board[y2+2][x2+2] = "1";
	}
	
}


class Token_2 extends Token {
	
	@Override
	void enterCoordinates() throws MyException{
		System.out.print("Enter X: ");
		
		x1 = s.nextInt();
		
		System.out.print("Enter Y: ");
		
		y1 = s.nextInt();
		
		if ( !( ((x1 == 0) || (x1 == 1) || (x1 == 2) || (x1 == 3) || (x1 == 4) || (x1 == 5) || (x1 == 6) || (x1 == 7)) && ((y1 == 0) || (y1 == 1) || (y1 == 2) || (y1 == 3) || (y1 == 4) || (y1 == 5) || (y1 == 6) || (y1 == 7)) ) ) {
			exception = true;
			throw new MyException("Invalid coordinate!");
		} else {
			if ( board.get(x1, y1).equals("2") ) {
				exception = false;
			} else {
				exception = true;
				throw new MyException("Invalid coordinate!"); }
		}
	}
	
	@Override
	void possiblePositions() {
		xp1 = (x1 - 1);
		yp1 = (y1 - 1);
		
		xp2 = (x1 + 1);
		yp2 = (y1 - 1);
	}

	@Override
	void moveToken() {
		board.board[y1+2][x1+2] = " ";
		board.board[y2+2][x2+2] = "2";
	}
}




//GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME




public class Mandatory_Assignment_4 {

	public static void main(String[] args) {
		
		
		//Compile board
		
		Board board = new Board();
		
		Token_1 token_1 = new Token_1();
		Token_2 token_2 = new Token_2();
		
		token_1.setBoard(board);
		token_2.setBoard(board);
		
		do {
			
			
		//Print board + first instruction
		
		board.printBoard();
		
		
		//First player's turn
		
		System.out.print("\n" + "Turn of player no. 1" + "\n" + "Coordinates of piece to move" + "\n");
		
		
		//Request coordinates of token to move
		//Check if right token is on the entered coordinates
		
		//Token_1 token_1 = new Token_1();

		do {
			try {
				token_1.enterCoordinates();
			}
			catch (MyException e) {
				System.out.println("Invalid coordinate! Try again!");
			}
		} while (token_1.exception);
		
		
		//Calculate possible moves
		
		//Possible positions
		
		token_1.possiblePositions();
		
		
		//Request coordinates of new position
		
		System.out.println("\n" + "Coordinates of new position");
		
		do {
			try {
				token_1.enterNewCoordinates();
			}
			catch (MyException e) {
				System.out.println("Invalid coordinate! Try again!");
			}
		} while (token_1.exception);
		
		
		//Move token to new position
		
		token_1.moveToken();
		
		System.out.print("\n");
		
		
		//Print board
		
		board.printBoard();
		
		
		
		//Second player's turn
		
		//Token_2 token_2 = new Token_2();
		
		System.out.print("\n" + "Turn of player no. 2" + "\n" + "Coordinates of piece to move" + "\n");
		
		
		//Request coordinates of token to move
		//Check if right token is on the entered coordinates
		
		do {
			try {
				token_2.enterCoordinates();
			}
			catch (MyException e) {
				System.out.println("Invalid coordinate! Try again!");
			}
		} while (token_2.exception);
		
		
		//Calculate possible moves
		
		//Possible positions
		
		token_2.possiblePositions();
		
		
		//Request coordinates of new position
		
		System.out.println("\n" + "Coordinates of new position");
				
		do {
			try {
				token_2.enterNewCoordinates();
			}
			catch (MyException e) {
				System.out.println("Invalid coordinate! Try again!");
			}
		} while (token_2.exception);
		
		
		//Move token to new position
		
		token_2.moveToken();
				
		System.out.print("\n");
		
		
		} while ( true );
		
	}

}






















