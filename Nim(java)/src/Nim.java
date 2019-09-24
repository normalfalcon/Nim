//Aleksei Surkov 
//student number: 040939815
// Course section 18F_CST8110_340
//lab teacher name: Hubert Furey
//This program simulates the game Nim
// Assignment #3 date: 16 November 2018
import java.util.Random;
import java.util.Scanner;

public class Nim {

	private Pile pileA;                                 // first pile
	private Pile pileB;                                 // second pile
	private Pile pileC;                                 // third pile
	private Random rnd = new Random();                  // random number generator
	private Scanner input = new Scanner(System.in);     // scanner for all user input

	private int a, b, c ;
	String pileChoice;
	int numChoice;

	public Nim() {                                      // default constructor  

		System.out.println("Welcome to the NIM game");
		System.out.println("We play by the misère rules ");

		a = 10 + rnd.nextInt(10);
		b = 10 + rnd.nextInt(10);
		c = 10 + rnd.nextInt(10);

		pileA = new Pile(a);


		pileB = new Pile(b);


		pileC = new Pile(c);


		while (! done() ) {
			printPiles();
			if (playerMove())
				System.out.println("You lose");
			else {
				printPiles();
				computerRandomMove();
				if (done())
					System.out.println("You win");
			}

		}

	}
	public boolean playerMove() {                       // rules to handle user input
		Pile playerPile = null;
		do {
			//select a pile
			System.out.println("Select a pile:" );
			pileChoice = input.next();

			while (!(pileChoice.equalsIgnoreCase("A") || pileChoice.equalsIgnoreCase("B") || pileChoice.equalsIgnoreCase("C"))) {
				System.out.println("Invalid pile letter, select a, b or c");
				System.out.println("Select a pile:" );
				pileChoice = input.next();
			}

			switch (pileChoice) {
			case "A":
			case "a":
				playerPile = pileA;
				break;
			case "B":
			case"b":	
				playerPile = pileB;
				break;
			case "C":
			case"c":
				playerPile = pileC;
				break;
			}
			if(playerPile.getSize() == 0)
				System.out.println("Pile"+pileChoice+" is empty, pick another");

		}while(playerPile.getSize() == 0);

		do {
			//select amount
			System.out.println("How many do you want to remove? ");
			numChoice = input.nextInt();
			if(playerPile.getSize()<numChoice || numChoice <= 0 )
				System.out.println("Pick a number between 1 and "+playerPile.getSize());
		}while(playerPile.getSize()<numChoice || numChoice <= 0);



		//remove from pile
		switch(pileChoice.toUpperCase()) {

		case "A": 
			pileA.remove(numChoice);
			break;
		case "B":
			pileB.remove(numChoice);
			break;
		case "C":
			pileC.remove(numChoice);
			break;

		}
		return done();
	}

	public boolean done()  { // Is the game done?

		if (pileA.getSize() == 0 &&  pileB.getSize() == 0 &&   pileC.getSize() == 0) 

			return  true;

		else 

			return false;
	}

	private void computerRandomMove() { // Computer move if done randomly, is computerMove() in non-bonus version
		Pile  compPile = null;

		do {
			int comp = rnd.nextInt(3);


			switch (comp) {
			case 0:
				pileChoice = "A";
				compPile = pileA;
				break;
			case 1:
				pileChoice = "B";
				compPile = pileB;
				break;
			case 2:
				pileChoice = "C";
				compPile = pileC;
				break;
			}
		}while(compPile.getSize() == 0);  // Computer can find non-zero pile

		numChoice = rnd.nextInt(compPile.getSize())+1;
		switch(pileChoice) {

		case "A": 
			pileA.remove(numChoice);
			break;
		case "B":
			pileB.remove(numChoice);
			break;
		case "C":
			pileC.remove(numChoice);
			break;
		}
		System.out.println("Computer takes "+numChoice+" from pile "+pileChoice);


	}

	public void printPiles() {                  // print the current state of the piles
		System.out.println("      A     B     C");
		System.out.println("      "+pileA.getSize()+"    "+pileB.getSize()+"    "+pileC.getSize());
	}
}