package lab4;
import java.util.*;
import lab4.forest;

public class world {
	PriorityQueue<animal> list=new PriorityQueue<animal>();
	grassland[] glist=new grassland[2];
	int total_time;
	public world(int total_time,herbivore h1, herbivore h2, carnivore c1, carnivore c2, grassland g1, grassland g2){
		this.total_time=total_time;
		list.add(h1);
		list.add(h2);
		list.add(c1);
		list.add(c2);
		glist[0]=g1;
		glist[1]=g2;
	}
	
	public void herbiTurn(herbivore h){
		if (forest.carnivore_present(list)==false){
			int chance = (int) Math.random()*100+1;
			if (chance <=50){
				if (h.coords.insideGrassland(glist[0])){
					h.coords.moveTowards(glist[1].x, glist[1].y, 5);
					h.setHealth(h.getHealth()-25);
				}
				else if (h.coords.insideGrassland(glist[1])){
					h.coords.moveTowards(glist[0].x, glist[0].y, 5);
					h.setHealth(h.getHealth()-25);
				}
				else{
					grassland nearg=forest.getNearestGrassland(h, glist);
					h.coords.moveTowards(nearg.x, nearg.y, 5);
				}
			}
		}
		else{
			//If the herbivore is not inside the grassland
			if (h.coords.insideGrassland(glist[0])==false && h.coords.insideGrassland(glist[1])==false){
				int chance = (int) Math.random()*100+1;
				if (chance <=95){
					int chance2=(int) Math.random()*100+1;
					if (chance2<=65){
						grassland nearg=forest.getNearestGrassland(h, glist);
						h.coords.moveTowards(nearg.x, nearg.y, 5);
					}
					else{
						carnivore c=forest.getNearestCarnivore(h, list);
						h.coords.moveAway(c.coords.x, c.coords.y, 4);
					}
				}
			}
			else if (h.coords.insideGrassland(glist[0])){
				if (forest.enoughGrass(h, glist[0])){
					int chance=(int) Math.random()*100+1;
					if (chance <=90){
						glist[0].setGrass(glist[0].getGrass()-h.getGrass_capacity());
						h.setHealth((int)(h.getHealth()+0.5*h.getHealth()));
					}
					else{
						int chance2=(int) Math.random()*100+1;
						if (chance2<=50){
							carnivore c=forest.getNearestCarnivore(h, list);
							h.coords.moveAway(c.coords.x, c.coords.y, 2);
							h.setHealth(h.getHealth()-25);
						}
						else{
							h.coords.moveTowards(glist[1].x, glist[1].y, 3);
							h.setHealth(h.getHealth()-25);
						}
					}
				}
				else{
					int chance =(int)Math.random()*100+1;
					if (chance <=20){
						glist[0].setGrass(0);
						h.setHealth((int)(h.getHealth()+0.2*h.getHealth()));
					}
					else{
						int chance2=(int) Math.random()*100+1;
						if (chance2 <=70){
							carnivore c=forest.getNearestCarnivore(h, list);
							h.coords.moveAway(c.coords.x, c.coords.y, 4);
							h.setHealth(h.getHealth()-25);
						}
						else{
							h.coords.moveTowards(glist[1].x, glist[1].y, 3);
							h.setHealth(h.getHealth()-25);
						}
					}
				}
			}
			else if (h.coords.insideGrassland(glist[1])){
				if (forest.enoughGrass(h, glist[1])){
					int chance=(int) Math.random()*100+1;
					if (chance <=90){
						glist[1].setGrass(glist[1].getGrass()-h.getGrass_capacity());
						h.setHealth((int)(h.getHealth()+0.5*h.getHealth()));
					}
					else{
						int chance2=(int) Math.random()*100+1;
						if (chance2<=50){
							carnivore c=forest.getNearestCarnivore(h, list);
							h.coords.moveAway(c.coords.x, c.coords.y, 2);
							h.setHealth(h.getHealth()-25);
						}
						else{
							h.coords.moveTowards(glist[0].x, glist[0].y, 3);
							h.setHealth(h.getHealth()-25);
						}
					}
				}
				else{
					int chance =(int)Math.random()*100+1;
					if (chance <=20){
						glist[1].setGrass(0);
						h.setHealth((int)(h.getHealth()+0.2*h.getHealth()));
					}
					else{
						int chance2=(int) Math.random()*100+1;
						if (chance2 <=70){
							carnivore c=forest.getNearestCarnivore(h, list);
							h.coords.moveAway(c.coords.x, c.coords.y, 4);
							h.setHealth(h.getHealth()-25);
						}
						else{
							h.coords.moveTowards(glist[0].x, glist[0].y, 3);
							h.setHealth(h.getHealth()-25);
						}
					}
					
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		herbivore h1=new herbivore(15, 20,new point(2,2),5);
		herbivore h2=new herbivore(15, 20, new point(0,-5),15);
		carnivore c1=new carnivore(25,new point(1,5),12);
		carnivore c2= new carnivore(25,new point(2,5),10);
		world sim=new world(12, h1, h2, c1, c2);
		System.out.println(forest.carnivore_present(sim.list));*/
	}

}
