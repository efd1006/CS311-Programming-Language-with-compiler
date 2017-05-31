import java.io.*;
import java.util.*;
class Reservation{
	private String couple_info;
	private ArrayList<String> guests = new ArrayList<String>();
	private String location;
	private String time;

	public void setCoupleInfo(String c){
		this.couple_info = c;
	}
	
	public void setGuest(String g){
		this.guests.add(g);
	}
	public void setLocation(String l){
		this.location = l;
	}
	public void setTime(String t){
		this.time = t;
	}
	
	public String getCoupleInfo(){
		return couple_info;
	}
	public ArrayList<String> getGuests(){
		return guests;
	}
	public String getLocation(){
		return location;
	}
	public String getTime(){
		return time;
	}
	
}
class Discount{
	private Double discount=0.0;
	
	public void displayDiscount(){
		System.out.println("1. June 1-15 (50% Discount)");
		System.out.println("2. June 16-30 (10% Discount)");
	}
	
	public void setDiscount(Double d){
		this.discount = d/100;
	}
	
	public double getDiscount(Double t){
		return t*discount;
	}
}
class GUI{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean isQuitting = false;
	Reservation r = new Reservation();
	Discount d = new Discount();
	Double total_expense=0.00;
	public void displayMenu() throws Exception{
		System.out.println("1. Reservation (10000 PHP)");
		System.out.println("2. Discounts");
		System.out.println("3. Add-Ons");
		System.out.println("4. Display");
		System.out.println("5. Quit");
		System.out.print("Choose: ");
		int o = Integer.parseInt(br.readLine());
		
		if(o == 1){
			System.out.print("Enter couple info: ");
			r.setCoupleInfo(br.readLine());
			boolean stop = false;
			do{
				System.out.print("Enter guest: ");
				r.setGuest(br.readLine());
				System.out.print("Do you want to add more guest? [Y/N]: ");
				String q = br.readLine();
				if(q.equalsIgnoreCase("n")){
					stop = true;
				}
			}while(stop == false);
			
			System.out.print("Enter location: ");
			r.setLocation(br.readLine());
			System.out.print("Enter time: ");
			r.setTime(br.readLine());
			total_expense = 10000.0;
		}else if(o == 2){
			d.displayDiscount();
			System.out.print("Select Discount: ");
			int s = Integer.parseInt(br.readLine());
			if(s == 1){
				d.setDiscount(50.0);
			}else if(s == 2){
				d.setDiscount(10.0);
			}
		}else if(o == 3){
			System.out.println("1. Wedding cake (3000 PHP)");
			System.out.println("2. Car rental (5000 PHP)");
			System.out.print("Select add-on: ");
			int a = Integer.parseInt(br.readLine());
			if(a == 1){
				total_expense += 3000.0;
			}else if(a == 2){
				total_expense += 5000.0;
			}
		}else if(o == 4){
			System.out.println("Couple Name: "+r.getCoupleInfo());
			System.out.println("Guests: ");
			for(String s : r.getGuests()){
				System.out.println(s);
			}
			System.out.println("Location: "+r.getLocation());
			System.out.println("Time: "+r.getTime());
			Double less = (d.getDiscount(total_expense) == 0.0 ? 0:d.getDiscount(total_expense));
			total_expense -= less;
			System.out.println("Total Expense: "+(total_expense));
		}else if(o == 5){
			isQuitting = true;
		}
	}
	public boolean quit(){
		return isQuitting;
	}	
}
class Wedding {
	public static void main(String[] args) throws Exception{
		GUI g = new GUI();
		do{
			g.displayMenu();
		}while(g.quit() == false);
	}
}