/**
 *
 * @author Brihi Joshi
 *
 * 2016142
 * CSE
 * Lab 2 - Advanced Programming
 *
 * Note - No in-built functions (INCLUDING SORT) have been used in this program. Everything has been self coded.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/*
 * The InputReader class is default and is used to take inputs from the user.
 *
 */
class InputReader {
    private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}


/*
 * The College Class stored the mess, hostel, library and acad details, along with fees and Grade.
 */


class college{
	private String name;
	private mess m;
	private hostel h;
	private library l;
	private acad a;
	private int fee;
	private char grade;
	private double mess_rank;
	private double hostel_rank;
	private double library_rank;
	private double acad_rank;


	/*
	 * Constructor which initializes the college class to the given parameters and initially allots all the sub-catgory
	 * ranks as 0.
	 */

	public college(String name, mess m, hostel h, library l, acad a, int fee, char grade){
		this.name=name;
		this.m=m;
		this.h=h;
		this.l=l;
		this.a=a;
		this.fee=fee;
		this.grade=grade;
		mess_rank=0;
		hostel_rank=0;
		library_rank=0;
		acad_rank=0;
	}


	/*
	 * The Setters and Getter methods for all the attributes. They are created to facilitate encapsulation,
	 * as the attributes are "private".
	 *
	 */


	public String getname(){
		return name;
	}
	public void setname(String n){
		name=n;
	}
	public mess getmess(){
		return m;
	}
	public void setmess(mess me){
		m=me;
	}
	public hostel gethostel(){
		return h;
	}
	public void sethostel(hostel ho){
		h=ho;
	}
	public library getlibrary(){
		return l;
	}
	public void setlibrary(library li){
		l=li;
	}
	public acad getacad(){
		return a;
	}
	public void setacad(acad ac){
		a=ac;
	}
	public int getfee(){
		return fee;
	}
	public void setfee(int f){
		fee=f;
	}
	public char getgrade(){
		return grade;
	}
	public void setgrade(char g){
		grade=g;
	}
	public double getmrank(){
		return mess_rank;
	}
	public void setmrank(double mr){
		mess_rank=mr;
	}
	public double gethrank(){
		return hostel_rank;
	}
	public void sethrank(double hr){
		hostel_rank=hr;
	}
	public double getlrank(){
		return library_rank;
	}
	public void setlrank(double lr){
		library_rank=lr;
	}
	public double getarank(){
		return acad_rank;
	}
	public void setarank(double ar){
		acad_rank=ar;
	}


	/*
	 * The final_rank() method calculates the final rank of a college based on the sub-category ranks
	 * and multiplying the weights to them.
	 *
	 */

	public double final_rank(){
		return (0.25*mess_rank)+(0.20*hostel_rank)+(0.25*library_rank)+(0.30*acad_rank);
	}

}

/*
 * The mess class contains all the mess attributes.
 *
 */


class mess{
	double food_avail;
	double nutri_val;
	double hyg_main;
	double deliv_delay;


	/*
	 * Constructor for the mess class
	 */

	public mess(double f, double n, double h, double d){
		food_avail=f;
		nutri_val=n;
		hyg_main=h;
		deliv_delay=d;
	}


	/*
	 * The comp_m function compares the objects of the college array, and ranks them according to the mess criteria.
	 */

	public static void comp_m(college[] a){
		int n=a.length;
		for (int i=0; i<n-1; i++ ){
			int max=i;
			for (int j=i+1;j<n;j++){
				if (a[j].getmess().food_avail>a[i].getmess().food_avail){
					max=j;
				}
				else if((a[j].getmess().food_avail==a[i].getmess().food_avail) && a[j].getmess().nutri_val>a[i].getmess().nutri_val){
					max=j;
				}
				else if ((a[j].getmess().food_avail==a[i].getmess().food_avail) && (a[j].getmess().nutri_val==a[i].getmess().nutri_val) && a[j].getmess().hyg_main>a[i].getmess().hyg_main){
					max=j;
				}
				else if ((a[j].getmess().food_avail==a[i].getmess().food_avail) && (a[j].getmess().nutri_val==a[i].getmess().nutri_val) && (a[j].getmess().hyg_main==a[i].getmess().hyg_main) && a[j].getmess().deliv_delay<a[i].getmess().deliv_delay){
					max=j;
				}
			}

			lab2.swap(a[i],a[max]);
		}
	}

	/*
	 * This function updates the mess ranks of the college in their college attribute "mess_rank"
	 */
	public static void mess_ranks(college[] a){
		comp_m(a);
		for (int i=0;i<a.length;i++){
			a[i].setmrank(i+1);
		}
	}

}

/*
 * As seen by the mess class, a similar class hostel is created with similar methods.
 */

class hostel{
	double room_cond;
	double study_fac;
	double clean;
	double recrea_fac;

	public hostel(double r, double s, double c, double rf){
		room_cond=r;
		study_fac=s;
		clean=c;
		recrea_fac=rf;
	}
	public static void comp_h(college[] a){
		int n=a.length;
		for (int i=0; i<n-1; i++ ){
			int max=i;
			for (int j=i+1;j<n;j++){
				if (a[j].gethostel().room_cond>a[i].gethostel().room_cond){
					max=j;
				}
				else if((a[j].gethostel().room_cond>a[i].gethostel().room_cond) && a[j].gethostel().study_fac>a[i].gethostel().study_fac){
					max=j;
				}
				else if ((a[j].gethostel().room_cond>a[i].gethostel().room_cond) && (a[j].gethostel().study_fac==a[i].gethostel().study_fac) && a[j].gethostel().clean>a[i].gethostel().clean){
					max=j;
				}
				else if ((a[j].gethostel().room_cond>a[i].gethostel().room_cond) && (a[j].gethostel().study_fac==a[i].gethostel().study_fac) && (a[j].gethostel().clean==a[i].gethostel().clean) && a[j].gethostel().recrea_fac>a[i].gethostel().recrea_fac){
					max=j;
				}
			}

			lab2.swap(a[i],a[max]);
		}
	}
	public static void hostel_ranks(college[] a){
		comp_h(a);
		for (int i=0;i<a.length;i++){
			a[i].sethrank(i+1);
		}
	}

}

/*
 * As seen by the mess class, a similar class library is created with similar methods.
 */

class library{
	double book_avail;
	double digi_faci;
	double sys_val;
	double av;

	public library(double b, double d, double s){
		book_avail=b;
		digi_faci=d;
		sys_val=s;
		av=(book_avail+digi_faci+sys_val)/3;
	}

	public static void comp_l(college[] a){
		int n=a.length;
		for (int i=0; i<n-1; i++ ){
			int max=i;
			for (int j=i+1;j<n;j++){
				if (a[j].getlibrary().av>a[i].getlibrary().av){
					max=j;
				}
			lab2.swap(a[i],a[max]);
			}
		}
	}
	public static void library_ranks(college[] a){
		comp_l(a);
		for (int i=0;i<a.length;i++){
			a[i].setlrank(i+1);
		}
	}
}


/*
 * As seen by the mess class, a similar class acad is created with similar methods.
 */

class acad{
	double know_impart;
	double domain;
	double course_struc;
	double crit;

	public acad(double k, double d, double c){
		know_impart=k;
		domain=d;
		course_struc=c;
		crit=know_impart+domain+(course_struc*2);
	}

	public static void comp_a(college[] a){
		int n=a.length;
		for (int i=0; i<n-1; i++ ){
			int max=i;
			for (int j=i+1;j<n;j++){
				if (a[j].getacad().crit>a[i].getacad().crit){
					max=j;
				}
			lab2.swap(a[i],a[max]);
			}
		}
	}
	public static void acad_ranks(college[] a){
		comp_a(a);
		for (int i=0;i<a.length;i++){
			a[i].setarank(i+1);
		}
	}
}


/*
 * The Ranking class is used to allot final ranks to the colleges by calling out the sub category ranks,
 * as well as printing the final order of the colleges.
 *
 */

class ranking{
	college[] list;

	public ranking(college[] a){
		list=a;
		mess.mess_ranks(list);
		hostel.hostel_ranks(list);
		library.library_ranks(list);
		acad.acad_ranks(list);
	}

	public void rank(){
		int n=list.length;
		for (int i=0; i<n-1; i++ ){
			int max=i;
			for (int j=i+1;j<n;j++){
				if (list[j].final_rank()<list[i].final_rank()){
					max=j;
				}
				else if((list[j].final_rank()==list[i].final_rank()) && list[j].getfee()<list[i].getfee()){
					max=j;
				}
				else if((list[j].final_rank()==list[i].final_rank()) && (list[j].getfee()==list[i].getfee()) && (int)list[j].getgrade()<(int)list[i].getgrade()){
					max=j;
				}
			lab2.swap(list[i],list[max]);
			}
		}
	}

	public void print(){
		rank();
		for(int i=0;i<list.length;i++){
			System.out.println(list[i].getname());
		}
	}

}

public class lab2 {

	/*
	 * Instead of creating a swap method for each sorting in the sub category classes,
	 * I have created a static class "swap" which is re-used in all the sorting methods above.
	 *
	 */

	public static void swap(college a, college b){
		String n;
		mess m;
		hostel h;
		library l;
		acad ac;
		int f;
		char g;
		double mr;
		double hr;
		double lr;
		double ar;

		n=a.getname();
		a.setname(b.getname());
		b.setname(n);

		m=a.getmess();
		a.setmess(b.getmess());
		b.setmess(m);

		h=a.gethostel();
		a.sethostel(b.gethostel());
		b.sethostel(h);

		l=a.getlibrary();
		a.setlibrary(b.getlibrary());
		b.setlibrary(l);

		ac=a.getacad();
		a.setacad(b.getacad());
		b.setacad(ac);

		f=a.getfee();
		a.setfee(b.getfee());
		b.setfee(f);

		g=a.getgrade();
		a.setgrade(b.getgrade());
		b.setgrade(g);

		mr=a.getmrank();
		a.setmrank(b.getmrank());
		b.setmrank(mr);

		hr=a.gethrank();
		a.sethrank(b.gethrank());
		b.sethrank(hr);

		lr=a.getlrank();
		a.setlrank(b.getlrank());
		b.setlrank(lr);

		ar=a.getarank();
		a.setarank(b.getarank());
		b.setarank(ar);
	}


	public static void main(String[] args) throws IOException{

		// TODO Auto-generated method stub

		InputReader sc = new InputReader(System.in);
		int t=sc.readInt();
		college[] list=new college[t];
		for (int i=0;i<t;i++){
			String n=sc.next();
			String temp1=sc.next();
			double m1=Double.parseDouble(sc.next());
			double m2=Double.parseDouble(sc.next());
			double m3=Double.parseDouble(sc.next());
			double m4=Double.parseDouble(sc.next());

			String temp2=sc.next();
			double h1=Double.parseDouble(sc.next());
			double h2=Double.parseDouble(sc.next());
			double h3=Double.parseDouble(sc.next());
			double h4=Double.parseDouble(sc.next());

			String temp3=sc.next();
			double l1=Double.parseDouble(sc.next());
			double l2=Double.parseDouble(sc.next());
			double l3=Double.parseDouble(sc.next());

			String temp4=sc.next();
			double a1=Double.parseDouble(sc.next());
			double a2=Double.parseDouble(sc.next());
			double a3=Double.parseDouble(sc.next());

			String temp5=sc.next();
			int fees=sc.readInt();

			String temp6=sc.next();
			String temp7=sc.next();

			char grade=sc.next().charAt(0);

			mess m=new mess(m1,m2,m3,m4);
			hostel h=new hostel(h1,h2,h3,h4);
			library l=new library(l1,l2,l3);
			acad a=new acad(a1,a2,a3);

			college c=new college(n,m,h,l,a,fees,grade);
			list[i]=c;

		}
		ranking r=new ranking(list);
    System.out.println("List of colleges as per their ranking (starting from rank-1) is as following:");
		r.print();

	}

}
