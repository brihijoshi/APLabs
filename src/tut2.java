// Q1. to swap the contents of 2 strings without using any temp variable

class q1{
	public String str1;
	public String str2;
	
	public q1(String s1, String s2){
		str1=s1;
		str2=s2;
	}
	
	public void swap_contents(){
		str1=str1+str2;
		str2=str1.substring(0,str1.length()-str2.length());
		str1=str1.substring(str2.length());
		System.out.println(str1);
		System.out.println(str2);
	}
}

class q2{
	String format;
	String[] date;
	String[] days={"Mon","Tue","Wed","Thurs","Fri","Sat","Sun"};
	int[] month={31,29,31,30,31,30,31,31,30,31,30,31};
	
	public q2(String fm){
		format=fm;
		date=format.split("/");
	}
	
	public boolean isleap(){
		if (Integer.parseInt(date[2])%4==0 || Integer.parseInt(date[2])%400==0){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
}


public class tut2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q1 a=new q1("Hello","World");
		a.swap_contents();
	}

}
