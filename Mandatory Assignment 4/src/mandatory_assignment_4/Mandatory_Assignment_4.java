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
	
}


abstract class Token extends Board {
	
	int x1;					//Coordinates of token
	int y1;
	
	int xp1;					//First possible position
	int yp1;
	int xp2;					//Second possible position
	int yp2;
	
	int x2;					//New coordinates of token
	int y2;
	
	Scanner s = new Scanner(System.in);
	
	Token() {
		this.x1 = 0;
		this.y1 = 0;
	}
	
	void enterCoordinates() {
		System.out.print("Enter X: ");
		
		x1 = s.nextInt();
		
		System.out.print("Enter Y: ");
		
		y1 = s.nextInt();
	}
	
	abstract boolean checkValidity1();
	
	abstract void possiblePositions();
	
	boolean checkOccupation(int yp, int xp) {						//false if occupied
		if ( board[yp+2][xp+2].equals("1") || board[yp+2][xp+2].equals("2") ) {
			return false;
		} else { return true; }
	}
	
	void enterNewCoordinates() {
		System.out.print("Enter X: ");
		
		x2 = s.nextInt();
		
		System.out.print("Enter Y: ");
		
		y2 = s.nextInt();
	}
	
	boolean checkValidity2() {
		try {
			if ( !( ((x2 == 0) || (x2 == 1) || (x2 == 2) || (x2 == 3) || (x2 == 4) || (x2 == 5) || (x2 == 6) || (x2 == 7)) && ((y2 == 0) || (y2 == 1) || (y2 == 2) || (y2 == 3) || (y2 == 4) || (y2 == 5) || (y2 == 6) || (y2 == 7)) ) ) {
				throw new MyException("Invalid coordinate!");
			} else {
				if ( (this.checkOccupation(yp1, xp1) && (x2 == xp1) && (y2 == yp1)) || (this.checkOccupation(yp2, xp2) && (x2 == xp2) && (y2 == yp2)) ) {
					return true;
				} else { throw new MyException("Invalid coordinate!"); }
			}
		}
		catch (MyException e) {
			System.out.println("Invalid coordinate! Try again!");
			return false;
		}
	}
	
	abstract void moveToken();
	
}


class Token_1 extends Token {
	
	@Override
	boolean checkValidity1() {
		try {
			if ( !( ((x1 == 0) || (x1 == 1) || (x1 == 2) || (x1 == 3) || (x1 == 4) || (x1 == 5) || (x1 == 6) || (x1 == 7)) && ((y1 == 0) || (y1 == 1) || (y1 == 2) || (y1 == 3) || (y1 == 4) || (y1 == 5) || (y1 == 6) || (y1 == 7)) ) ) {
				throw new MyException("Invalid coordinate!");
			} else {
				if ( board[y1+2][x1+2].equals("1") ) {
					return true;
				} else { throw new MyException("Invalid coordinate!"); }
			}
		}
		catch (MyException e) {
			System.out.println("Invalid coordinate! Try again!");
			return false;
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
		board[y1+2][x1+2] = " ";
		board[y2+2][x2+2] = "1";
	}
	
}


class Token_2 extends Token {
	
	@Override
	boolean checkValidity1() {
		try {
			if ( !( ((x1 == 0) || (x1 == 1) || (x1 == 2) || (x1 == 3) || (x1 == 4) || (x1 == 5) || (x1 == 6) || (x1 == 7)) && ((y1 == 0) || (y1 == 1) || (y1 == 2) || (y1 == 3) || (y1 == 4) || (y1 == 5) || (y1 == 6) || (y1 == 7)) ) ) {
				throw new MyException("Invalid coordinate!");
			} else {
				if ( board[y1+2][x1+2].equals("2") ) {
					return true;
				} else { throw new MyException("Invalid coordinate!"); }
			}
		}
		catch (MyException e) {
			System.out.println("Invalid coordinate! Try again!");
			return false;
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
		board[y1+2][x1+2] = " ";
		board[y2+2][x2+2] = "2";
	}
}





//GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME---GAME




public class Mandatory_Assignment_4 {

	public static void main(String[] args) {
		
		
		//Compile board
		
		Board board = new Board();
		
		Token_1 token_1 = new Token_1();
		Token_2 token_2 = new Token_2();
		
		
		do {
			
			
		//Print board + first instruction
		
		board.printBoard();
		
		
		//First player's turn
		
		System.out.print("\n" + "Turn of player no. 1" + "\n" + "Coordinates of piece to move" + "\n");
		
		
		//Request coordinates of token to move
		//Check if right token is on the entered coordinates
		
		//Token_1 token_1 = new Token_1();
		
		do {
			token_1.enterCoordinates();
		} while (!(token_1.checkValidity1()));
		
		
		//Calculate possible moves
		
		//Possible positions
		
		token_1.possiblePositions();
		
		
		//Request coordinates of new position
		
		System.out.println("\n" + "Coordinates of new position");
		
		do {
			token_1.enterNewCoordinates();
		} while (!(token_1.checkValidity2()));
		
		
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
			token_2.enterCoordinates();
		} while (!(token_2.checkValidity1()));
		
		
		//Calculate possible moves
		
		//Possible positions
		
		token_2.possiblePositions();
		
		
		//Request coordinates of new position
		
		System.out.println("\n" + "Coordinates of new position");
				
		do {
			token_2.enterNewCoordinates();
		} while (!(token_2.checkValidity2()));
		
		
		//Move token to new position
		
		token_2.moveToken();
				
		System.out.print("\n");
		
		
		} while ( true );
		
	}

}






















