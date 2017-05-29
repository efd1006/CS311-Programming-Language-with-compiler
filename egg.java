/* PRELIM PERIOD */

import java.io.*;

class egg {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String salt = "n";
	public static void ask() throws Exception{
		System.out.print("Add some salt Y/N?");
		salt = br.readLine();
	}
	
	public static void main(String[] args) throws Exception{
		int num_egg = 0;
		
		
		System.out.println("How many eggs: ");
		num_egg = Integer.parseInt(br.readLine());
		System.out.println("Crack the egg.");
		System.out.println("Put the egg on the pan");
		
		do{
			ask();
			if(salt.equalsIgnoreCase("Y")){
				System.out.println("Serve");
			}else{
				System.out.println("wait...");
			}
		}while(salt.equalsIgnoreCase("N"));
		
	}
}
