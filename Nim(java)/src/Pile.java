//Aleksei Surkov 
//student number: 040939815
// Course section 18F_CST8110_340
//lab teacher name: Hubert Furey
//This program simulates the game  Nim
// Assignment #3 date: 16 November 2018
public class Pile {
	private int size;  // The current size of pile
	
	public Pile() {  // Default constructor 
		size = 10; 
	}
	public Pile(int n) {  // Initial constructor 
		size = n; 
	}
	public int getSize() {  // get current size of pile
	 
		return size;
		
	}
	public void remove(int take ) {  // remove the amount from pile
		
		size -= take;
				
		}
	}

