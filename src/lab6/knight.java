package lab6;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

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



