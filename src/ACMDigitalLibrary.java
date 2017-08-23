//Brihi Joshi - CSE - 2016142
//Lab Assignment 2 - Q2
import java.util.Scanner;

public class ACMDigitalLibrary {

	private String author;
	private String pt;
	private String venue;
	private int year;
	
	//Constructors
	public ACMDigitalLibrary(String author, String pt, String venue, int year){
		this.author=author;
		this.pt=pt;
		this.venue=venue;
		this.year=year;
	}
	
	//Getters and Setters
	
	public String getauthor(){
		return author;
	}
	
	public void setauthor(String author){
		this.author=author;
	}
	
	public String getpt(){
		return pt;
	}
	
	public void setpt(String pt){
		this.pt=pt;
	}
	
	public String getvenue(){
		return venue;
	}
	
	//OOPSLA, PLDI, SC, ICPP and EuroPar
	public void setvenue(String venue){
		this.venue=venue;
	}
	
	public int getyear(){
		return year;
	}
	
	public void setyear(int year){
		this.year=year;
	}
	
	public static void papers_on_venue(ACMDigitalLibrary[] arr, String ven){
		for (int i=0;i<arr.length;i++){
			if (arr[i].getvenue()==ven){
				System.out.println(arr[i].getpt()+","+arr[i].getauthor()+","+arr[i].getyear());
			}
		}
	}
	
	public static void papers_on_author(ACMDigitalLibrary[] arr, String auth){
		for (int i=0;i<arr.length;i++){
			if (arr[i].getauthor()==auth){
				System.out.println(arr[i].getpt()+","+arr[i].getauthor()+","+arr[i].getyear());
			}
		}
	}
	
	public static void papers_on_year(ACMDigitalLibrary[] arr, int yr){
		for (int i=0;i<arr.length;i++){
			if (arr[i].getyear()<yr){
				System.out.println(arr[i].getpt()+","+arr[i].getauthor()+","+arr[i].getyear());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ACMDigitalLibrary[] arr = new ACMDigitalLibrary[10];
		arr[0]= new ACMDigitalLibrary("Ryan","Intro to Programming","OOPSLA",2001);
		arr[1]= new ACMDigitalLibrary("Ryan","Systems Management","IC",2002);
		arr[2]= new ACMDigitalLibrary("Megan","Data Structures","OOPSLA",1998);
		arr[3]= new ACMDigitalLibrary("Richard","Real Analysis","ICPP",1997);
		arr[4]= new ACMDigitalLibrary("Megan","Advanced ML","EuroPar",2011);
		arr[5]= new ACMDigitalLibrary("Heather","P&S","PLDI",1998);
		arr[6]= new ACMDigitalLibrary("Heather","Linear Algebra","OOPSLA",1988);
		arr[7]= new ACMDigitalLibrary("Ryan","Beginner's Rails","ICPP",1999);
		arr[8]= new ACMDigitalLibrary("Ryan","AstroPhysics","PLDI",2009);
		arr[9]= new ACMDigitalLibrary("Ryan","Intro to Assembly Lang","IC",1970);
		
		
		System.out.println("Menu:");
		System.out.println("1. List papers based on venue");
		System.out.println("2. List papers based on author name");
		System.out.println("3. List papers based on year");
		System.out.println("4. Exit");
		
		Scanner sc=new Scanner(System.in);
		
		while (true){
			System.out.println("Select Option number: ");
			int a=sc.nextInt();
			if (a==1){
				System.out.print("Enter venue: ");
				String vn=sc.next();
				papers_on_venue(arr,vn);
			}
			else if (a==2){
				System.out.print("Enter author name: ");
				String vn=sc.next();
				papers_on_author(arr,vn);
			}
			else if (a==3){
				System.out.print("Enter year: ");
				int vn=sc.nextInt();
				papers_on_year(arr,vn);
			}
			else{
				break;
			}
					
		}
		
		
	}

}
