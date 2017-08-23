import java.util.Arrays;

//Lab Assignment 1 - Section A Question 1 and 2

public class r1_q1 {
	
	public static void compress (String s){
		String str="";
		
		char a=s.charAt(0);
		int count=0;
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)!=(a)){
				//System.out.println("here");
				str=str+a+Integer.toString(count);
				//System.out.println(str);
				count=1;
				a=s.charAt(i);
				//System.out.println(a);
			}
			else{
				//System.out.println("there");
				//System.out.println(a);
				count++;
			}
			//System.out.println(a);
			//System.out.println(count);
		}
		System.out.println(str+a+Integer.toString(count));
		
	}
	
	public static void anagram(String s1, String s2){
		char[] c1= s1.toCharArray();
		char[] c2= s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		System.out.println(Arrays.equals(c1,c2));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		compress("aabbbcccabaddee");
		anagram("hello","olleh");
	}

}
