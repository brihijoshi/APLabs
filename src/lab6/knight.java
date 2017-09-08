package lab6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class coordinate implements Comparable {

	int x;
	int y;
	
	public coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		coordinate c=(coordinate)o;
		if (this.x==c.x && this.y==c.y){
			return 1;
		}
		return 0;
	}
	
	public void setCoord(coordinate c){
		this.x=c.x;
		this.y=c.y;
	}

}


class NonCoordinateException extends Exception{
	public NonCoordinateException(String s){
		super(s);
	}
}
class StackEmptyException extends Exception{
	public StackEmptyException(String s){
		super(s);
	}
}
class OverlabException extends Exception{
	public OverlabException(String s){
		super(s);	
	}
}
class QueenFoundException extends Exception{
	public QueenFoundException(String s){
		super(s);
	}
}

class stackobj{
	
	String type;
	Object value;
	
	public stackobj(String type, Object value) {
		this.type = type;
		this.value = value;
	}
	
	
}

public class knight {
	
	String name;
	coordinate coord;
	Stack box;
	int num;
	
	public knight(String s, coordinate c, int n){
		name=s;
		coord=c;
		num=n;
		box=new Stack();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("The number of knights - ");
		int n=sc.nextInt();
		System.out.println("The total number of Iterations -");
		int iter=sc.nextInt();
		System.out.println("Coordinates of the queen x and y");
		int x_q=sc.nextInt();
		int y_q=sc.nextInt();
		coordinate queen=new coordinate(x_q,y_q);
		ArrayList<knight> knight_list=new ArrayList<knight>();
		
		for (int i=0;i<n;i++){
			BufferedReader br=new BufferedReader(new FileReader("./src/"+(i+1)+".txt"));
			String name=br.readLine();
			//System.out.println(name);
			String[] init_coordinates=br.readLine().split(" ");
			//System.out.println(Arrays.toString(init_coordinates));
			coordinate c=new coordinate(Integer.parseInt(init_coordinates[0]),Integer.parseInt(init_coordinates[1]));
			int m=Integer.parseInt(br.readLine());
			//System.out.println(m);
			knight k=new knight(name, c, m);
			for (int j=0;j<m;j++){
				String[] stackob=br.readLine().split(" ");
				//System.out.println(Arrays.toString(stackob));
				coordinate temp;
				if (stackob[0]=="Coordinate"){
					temp=new coordinate(Integer.parseInt(stackob[1]),Integer.parseInt(stackob[2]));
					stackobj s=new stackobj(stackob[0],temp);
					k.box.push(s);
				}
				else{
					stackobj s=new stackobj(stackob[0],stackob[1]);
					k.box.push(s);
				}
			}
			knight_list.add(i, k);	
		}
		
		
		

	}

}



