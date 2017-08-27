package lab4;

public class point {


	int x;
	int y;
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getDistance(int a, int b){
		int norm_x=(int)Math.pow(x-a,2);
		int norm_y=(int)Math.pow(y-b, 2);
		int res=(int) Math.sqrt(norm_x+norm_y);
		return res;
	}
	
	public void moveTowards(int a, int b, int units){
		int d=getDistance(a,b);
		int rem=d-units;
		int fin_x=((units*a)+(rem*x))/d;
		int fin_y=((units*b)+(rem*y))/d;
		this.setX(fin_x);
		this.setY(fin_y);
	}
	
	public boolean insideGrassland(grassland g){
		if (getDistance(g.x,g.y)<g.r){
			return true;
		}
		return false;
	}
	
	public void moveAway(int a, int b, int units){
		int full_dist=units+getDistance(a,b);
		int fin_x=((units*a)-(full_dist*x))/getDistance(a,b);
		int fin_y=((units*b)-(full_dist*y))/getDistance(a,b);
		this.setX(fin_x);
		this.setY(fin_y);
	}

}
