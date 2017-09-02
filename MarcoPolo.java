import java.util.Random;
import java.util.Scanner;

import MarcoPolo.Spaces;
public class MarcoPolo {
	//JJ Shepherd CSCE 146 8/27/17
	//Don't drop numbers in code
	public static final int BOARD_SIZE = 10;
	enum Spaces {Empty, Player, Goal, Walked_Path}; //more efficient and easier to use than comparing strings
	public static void main(String[] args) {
		int numberOfMoves = 0;
		int pX = 0;
		int pY = 0;
		Random r = new Random();
		int gX = r.nextInt(BOARD_SIZE); //picks from 0 to BOARD_SIZE - 1
		int gY = r.nextInt(BOARD_SIZE);
		Scanner keyboard = new Scanner(System.in);
		Spaces[][] board = new Spaces[BOARD_SIZE][BOARD_SIZE];
		//must initialize each board space to zero
		for (int i=0;i<board.length;i++)
		{
			for (int j=0;j<board[i].length;i++) //board[i].length necessary because Java allows ragged arrays
			{
				board[i][j] = Spaces.Empty;
			}
			
		}
		board[pX][pY]=Spaces.Player;
		board[gX][gY]=Spaces.Goal;
		
		System.out.println("Hey you\nHow goes it?\nLet's play the marco polos");
		boolean gameOver=false;
		while(gameOver == false) //game loop
		{
			//Draw the board
			for (int i=0;i<board.length;i++)
			{
				for (int j=0;j<board[i].length;i++)
				{
					switch(board[i][j]) //enums and switch statements go hand in hand
					{
					case Empty:
						System.out.print("_");
						break;
					case Player:
						System.out.print("X");
						break;
					case Goal:
						System.out.print("_");
						break;
					case Walked_Path:
						System.out.print("#");
						break;
					default:
						System.out.print("?");
					}
				}
				System.out.println();
			}
			int test = keyboard.nextInt();
		}
		

	}

}
