import java.io.*;
import java.lang.*;
class Guess{
	private int correct_number;
	private int guess;
	
	public void setGuess(int n){
		this.guess = n;
	}
	public int getGuess(){
		return guess;
	}
	
	public int getCorrectNumber(){
		return correct_number;
	}
	
	public int getRandomNumber(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	public void setRandomNumber(int n){
		this.correct_number = n;
	}
}
class Mp3 {
		static Guess g = new Guess();
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static int i=1;
		public static void newGame() throws Exception{
			do{
				//g.setRandomNumber(10); // debug
				System.out.print("Enter your guess: ");
				g.setGuess(Integer.parseInt(br.readLine()));
				if(g.getGuess() == g.getCorrectNumber()){
					System.out.println("You won");
					System.out.print("Enter your name: ");
					String name = br.readLine();
					System.out.println("You name is: "+name);
					break;
				}
				if(i == 10){
					System.out.println("You reached 10 tries..the game will restart");
					i=1;
					newGame();
				}
				i++;
			}while(i<11);
		}
		public static void main(String[] args) throws Exception{
			
			
			g.setRandomNumber(g.getRandomNumber(1,10));
			newGame();
			
		}
	
}