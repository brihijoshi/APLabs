/*
 * Brihi Joshi
 * 2016142
 * Lab 1
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Reader class to take input from the user

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}


//The students class, which will hold all the data about a student

class students{
	private String name;
	private String rno;
	private String prog;
	private int dist;
	
	public students(String n, String r,String p, int d){
		name=n;
		rno=r;
		prog=p;
		dist=d;
	}	
	
	
	//Getters and Setters for the class attributes
	public String getname(){
		return name;
	}
	public void setname(String n){
		name=n;
	}
	public String getrno(){
		return rno;
	}
	public void setrno(String r){
		rno=r;
	}
	
	public String getprog(){
		return prog;
	}
	public void setprog(String p){
		prog=p;
	}
	public int getdist(){
		return dist;
	}
	public void setdist(int d){
		dist=d;
	}
	
	//Method to print the Student info in the desired order
	@Override
	public String toString(){
		return name+" "+rno+" "+prog+" "+dist;
	}
	
}


//Class to perform the allotment

class hostel_allot{
	private students[] phd;
	private students[] pg;
	private students[] ug;
	private int num_applicants;
	private int num_rooms;
	
	
	//Construtor
	public hostel_allot(int n, int m){
		num_applicants=n;
		num_rooms=m;
	}
	
	
	//Method to swap two student objects
	
	public void swap(students a, students b){
		String n;
		String r;
		String p;
		int d;
		
		n=a.getname();
		a.setname(b.getname());
		b.setname(n);
		
		r=a.getrno();
		a.setrno(b.getrno());
		b.setrno(r);
		
		p=a.getprog();
		a.setprog(b.getprog());
		b.setprog(p);
		
		d=a.getdist();
		a.setdist(b.getdist());
		b.setdist(d);
	}
	
	//Method to sort an Array of Student elements according to their distances
	public void sort_dist(students[] arr){
		int len=arr.length;
		for (int i=0;i<len-1;i++){
			int index=i;
			
			for (int j=i+1;j<len;j++){
				if (arr[j].getdist()>arr[index].getdist()){
					index=j;
				}
			}
			
			swap(arr[i],arr[index]);
		}
		
	}
	
	
	//Method to separate the programs according to their programs and sorting them
	public void separate_progs(students[] arr){
		int num_phd=0;
		int num_pg=0;
		int num_ug=0;
		
		for (int i=0;i<arr.length;i++){
			if (arr[i].getprog().equals("PhD")){
				num_phd++;
			}
			else if (arr[i].getprog().equals("PG")){
				num_pg++;
			}
			else {
				num_ug++;
			}
		}
		
		phd=new students[num_phd];
		pg=new students[num_pg];
		ug=new students[num_ug];
		
		//System.out.println(num_phd);
		//System.out.println(num_pg);
		//System.out.println(num_ug);
		int count1=0;
		for (int i=0;i<arr.length;i++){
			if (arr[i].getprog().equals("PhD")){
				phd[count1]=arr[i];
				count1++;
			}
		}
		
		int count2=0;
		for (int i=0;i<arr.length;i++){
			if (arr[i].getprog().equals("PG")){
				pg[count2]=arr[i];
				count2++;
			}
		}
		int count3=0;
		for (int i=0;i<arr.length;i++){
			if (arr[i].getprog().equals("UG")){
				ug[count3]=arr[i];
				count3++;
			}
		}
		
		sort_dist(phd);
		sort_dist(pg);
		sort_dist(ug);
	}
	
	//Method to allot the hostel
	public void allot_hostel(students[] arr, students[] orig){
		separate_progs(arr);
		
		//This is the final list which will store eligible students
		students[] final_list=new students[num_rooms];
		int count=0;
		
		//Number of PhD reserved rooms
		int half=(num_rooms+1)/2;
		
		
		if (phd.length<=half){
			for (int i=0;i<phd.length;i++){
				final_list[count]=phd[i];
				count++;
			}
		}
		else{
			for (int i=0;i<half;i++){
				final_list[count]=phd[i];
				count++;
			}
		}
		
		if (pg.length<=(num_rooms-half)){
			for (int i=0;i<pg.length;i++){
				final_list[count]=pg[i];
				count++;
			}
		}
		else{
			for (int i=0;i<num_rooms-half;i++){
				final_list[count]=pg[i];
				count++;
			}
		}
		
		int remain_rooms=num_rooms-(count);
		
		for (int i=0;i<remain_rooms;i++){
			final_list[count]=ug[i];
			
		}

		
		//Comparing the final list with the original list to get the order correct
		for (int i=0;i<orig.length;i++){
			for (int j=0;j<num_rooms;j++){
				if (orig[i].getrno().equals(final_list[j].getrno())){
					System.out.println(orig[i].toString());
				}
			}
		}
		
		
	}

	
}

public class lab1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int n=Reader.nextInt();
		int m=Reader.nextInt();
		hostel_allot allotment=new hostel_allot(n,m);
		students[] list=new students[n];
		students[] list2=new students[n];
		
		for (int i=0;i<n;i++){
			String nm=Reader.next();
			String r=Reader.next();
			String p=Reader.next();
			int d=Reader.nextInt();
			
			students s1=new students(nm,r,p,d);
			students s2=new students(nm,r,p,d);
			list[i]=s1;
			list2[i]=s2;
		}
		
		allotment.allot_hostel(list, list2);
		
	}

}
