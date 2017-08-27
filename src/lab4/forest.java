package lab4;
import java.util.*;

class grassland{
	int x;
	int y;
	int r;
	int grass;
	
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
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getGrass() {
		return grass;
	}
	public void setGrass(int grass) {
		this.grass = grass;
	}
	
	
}
public class forest {

	public static boolean carnivore_present(PriorityQueue<animal> list){
		for (animal a:list){
			if (a.getType().equals("c")){
				return true;
			}
		}
		return false;
	}
	public static boolean herbivore_present(PriorityQueue<animal> list){
		for (animal a:list){
			if (a.getType().equals("h")){
				return true;
			}
		}
		return false;
	}
	public static grassland getNearestGrassland(animal a, grassland[] g){
		if ((a.coords.getDistance(g[0].x, g[0].y)-g[0].r)<(a.coords.getDistance(g[1].x, g[1].y)-g[1].r)){
			return g[0];
		}
		else if ((a.coords.getDistance(g[0].x, g[0].y)-g[0].r)>(a.coords.getDistance(g[1].x, g[1].y)-g[1].r)){
			return g[1];
		}
		else{
			return g[0];
		}
	}
	
	public static carnivore getNearestCarnivore(animal a, PriorityQueue<animal> list){
		int dist=Integer.MAX_VALUE;
		animal l=null;
		for (animal m:list){
			if (m.getType().equals("c")){
				if (a.coords.getDistance(m.coords.x, m.coords.y)<dist){
					dist=a.coords.getDistance(m.coords.x, m.coords.y);
					l=m;
				}
			}
		}
		return (carnivore)l;
	}
	public static herbivore getNearestHerbivore(animal a, PriorityQueue<animal> list){
		int dist=Integer.MAX_VALUE;
		animal l=null;
		for (animal m:list){
			if (m.getType().equals("h")){
				if (a.coords.getDistance(m.coords.x, m.coords.y)<dist){
					dist=a.coords.getDistance(m.coords.x, m.coords.y);
					l=m;
				}
			}
		}
		return (herbivore)l;
	}
	
	public static boolean enoughGrass(herbivore h, grassland g){
		if (h.getGrass_capacity()<=g.grass){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
