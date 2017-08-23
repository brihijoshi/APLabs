//Brihi Joshi - CSE - 2016142
//Lab Assignment 2 - Q1


public class Student {
	
	
	//Defining all the attributes for the Student class
	private String Name;
	private int Age;
	private int RllNo;
	private String Branch;
	public static int counter = 0;
	private int latestRNo;
	
	
	//Default Constructor
	public Student(){
		counter++;
		this.Name=null;
		this.Age=0;
		this.RllNo=0;
		this.Branch=null;
		this.latestRNo=counter;
	}
	
	
	//Constructors with all fields as parameters
	public Student(String Name, int Age, int RllNo, String Branch){
		counter++;
		this.Name=Name;
		this.Age=Age;
		this.RllNo=RllNo;
		this.Branch=Branch;
		this.latestRNo=counter;
		
	}
	
	//Getters and Setter for the rest of the fields
	
	public String getName(){
		return Name;
	}
	
	public void setName(String Name){
		this.Name=Name;
	}
	
	public int getAge(){
		return Age;
	}
	
	public void setAge(int Age){
		this.Age=Age;
	}
	
	public int getRllNo(){
		return RllNo;
	}
	
	public void setRllNo(int RllNo){
		this.RllNo=RllNo;
	}
	
	public String getBranch(){
		return Branch;
	}
	
	public void setBranch(String Branch){
		this.Branch=Branch;
		
	}
	
	//toString method to display the fields of the class
	
	public String toString(){
		return "Name: "+Name+" Age :"+Age+" RllNo: "+RllNo+" Branch: "+Branch+" LatestRllNo: "+latestRNo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] arr=new Student[10];
		arr[0]=new Student("Brihi",18, 2016142, "CSE");
		arr[1]=new Student("Alice",19, 2015178, "ECE");
		arr[2]=new Student("Ryan",16, 2017154, "CSAM");
		arr[3]=new Student("Megan",20, 2014098, "CSE");
		arr[4]=new Student("Cooper",18, 2016245, "ECE");
		arr[5]=new Student("Richie",21, 2013213, "CSAM");
		arr[6]=new Student("Hannah",17, 2016001, "CSE");
		arr[7]=new Student("Clay",22, 2012345, "ECE");
		arr[8]=new Student("Monty",19, 2016234, "CSAM");
		arr[9]=new Student("Bridget",20, 2013432, "CSE");
		
		for (int i=0;i<arr.length;i++){
			System.out.println(arr[i].toString());
		}
		
		
	}

}
