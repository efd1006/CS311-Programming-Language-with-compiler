/* PRELIM */

import java.io.*;
import java.util.*;
class wedding{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String couple_info;
	static ArrayList<String> guests = new ArrayList<String>();
	static String location;
	static String time;
	
	public static void addGuest(String g){
		guests.add(g);
	}

	public static void reservation() throws Exception{
		System.out.print("Enter couple's info: ");
		couple_info = br.readLine();
		String op="n";
		do{
			System.out.print("Add guests: ");
			String guest = br.readLine();
			addGuest(guest);
			System.out.println("Guest successfully added...");
			System.out.print("Do you want to add more guest? Y/N: ");
			op = br.readLine();
		}while(op.equalsIgnoreCase("y"));
		
		System.out.print("Enter location: ");
		location = br.readLine();
		System.out.print("Enter time: ");
		time = br.readLine();
		
	}
	static int menu;
	public static void pickMenu() throws Exception{
		System.out.println("Choose Option");
		System.out.println("1. Reservation (10,000PHP)");
		System.out.println("2. Discounts");
		System.out.println("3. Add-Ons");
		System.out.println("4. Display total");
		menu = Integer.parseInt(br.readLine());
	}
	static double discount = 0;
	public static void discounts() throws Exception{
		System.out.println("Choose Discount");
		System.out.println("1. 30% June 1-15");
		System.out.println("2. 10% June 16-30");
		int d = Integer.parseInt(br.readLine());
		if(d == 1){
			discount = .30;
		}else if(d == 2){
			discount = .10;
		}
	}
	static ArrayList<Integer> additional = new ArrayList<Integer>();
	public static void addOns() throws Exception{
		
		String o = "n";
		
		do{
			System.out.println("Choose Add-Ons");
			System.out.println("1. Wedding cake 5.000PHP");
			System.out.println("2. Rent a car  3.000PHP");
			int adds = Integer.parseInt(br.readLine());
			if(adds == 1){
				additional.add(5000);
			}else if (adds == 2){
				additional.add(3000);
			}
		}while(o.equalsIgnoreCase("y"));
	}
	static String cashout="n";
	static double total_expense;
	public static void cashedout(){
		System.out.println("Couple info: "+couple_info);
		System.out.println("Guests: ");
		for(String g : guests){
			System.out.println(g);
		}
		System.out.println("Location: "+location);
		System.out.println("Time: "+time);
		total_expense = 10000;
		for(int n : additional){
			total_expense = total_expense + n;
		}
		double less_disc=0;
		if(discount != 0){
			less_disc = total_expense*discount;
		}
		total_expense = total_expense-less_disc;
		System.out.println("Total Expense: "+total_expense);
		cashout = "y";
	}
	public static void main(String[] args) throws Exception{
		do
		{
			pickMenu();
			if(menu == 1){
				reservation();
			}else if(menu == 2){
				discounts();
			}else if(menu == 3){
				addOns();
			}else if(menu == 4){
				cashedout();
			}
		}while(cashout.equalsIgnoreCase("n"));	
	}

}