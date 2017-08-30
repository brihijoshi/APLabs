package lab4;
import java.util.*;
import lab4.forest;

public class world {
	PriorityQueue<animal> list=new PriorityQueue<animal>();
	grassland[] glist=new grassland[2];
	int total_time;
	herbivore h1;
	herbivore h2;
	carnivore c1;
	carnivore c2;
	grassland g1;
	grassland g2;
	public world(int total_time,herbivore h1, herbivore h2, carnivore c1, carnivore c2, grassland g1, grassland g2){
		this.total_time=total_time;
		this.h1=h1;
		this.h2=h2;
		this.c1=c1;
		this.c2=c2;
		this.g1=g1;
		this.g2=g2;
		list.add(h1);
		list.add(h2);
		list.add(c1);
		list.add(c2);
		glist[0]=g1;
		glist[1]=g2;
	}
	
	public int maxTimeStamp(){
		int max=0;
		for (animal a:list){
			if (a.getTimestamp()>max){
				max=a.getTimestamp();
			}
		}
		return max;
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
					if (glist[0].getGrass()!=0){
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
					else{
						glist[0].setGrass(0);
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
					if (glist[1].getGrass()!=0){
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
					else{
						glist[1].setGrass(0);
					}
				}
			}
		}
		if (h.coords.insideGrassland(glist[0]) || h.coords.insideGrassland(glist[1])){
			h.turnsoutside+=1;
		}
		else{
			h.turnsoutside=0;
		}
	}
	
	public void carniTurn(carnivore c){
		boolean flag=false;
		if (forest.herbivore_present(list)==true){
			herbivore h=forest.getNearestHerbivore(c, list);
			if (c.coords.getDistance(h.coords.x, h.coords.y)<=1){
				//kill and eat it
				c.setHealth((int)(c.getHealth()+0.66*h.getHealth()));
				list.remove(h);
				flag=true;
			}
			else{
				if (c.coords.insideGrassland(glist[0])==false && c.coords.insideGrassland(glist[1])==false){
					int chance = (int) Math.random()*100+1;
					if (chance <=92){
						c.coords.moveTowards(h.coords.x, h.coords.y, 4);
					}
					else{
						c.setHealth(c.getHealth()-60);
					}
				}
				else{
					int chance3 = (int) Math.random()*100+1;
					
					if (chance3 <=25){
						c.setHealth(c.getHealth()-30);
					}
					else{
						c.coords.moveTowards(h.coords.x, h.coords.y, 2);
					}
				}
			}
		}
		else{
			if (c.coords.insideGrassland(glist[0])==false && c.coords.insideGrassland(glist[1])==false){
				c.setHealth(c.getHealth()-60);
			}
			else{
				c.setHealth(c.getHealth()-30);
			}
		}
		if (flag){
			c.turnfarherbi=0;
		}
		else{
			herbivore h=forest.getNearestHerbivore(c, list);
			if (h==null){
				c.turnfarherbi+=1;
			}
			else{
			if (c.coords.getDistance(h.coords.x, h.coords.y)>5){
				c.turnfarherbi+=1;
			}
			else{
				c.turnfarherbi=0;
			}
			}
		}
	}
	public void runSim(){
		System.out.println("The Simulation Begins -");
		int count=0;
		while (count<total_time){
			if (list.isEmpty()){
				break;
			}
			else{
			animal a=list.peek();
			if (a.getType()=="h"){
				if (a.equals(h1)){
					System.out.println("It is First Herbivore");
				}
				else{
					System.out.println("It is Second Herbivore");
				}
				herbivore h=(herbivore)a;
				herbiTurn(h);
				if (h.turnsoutside>=7){
					h.setHealth(h.getHealth()-5);
				}
				if (h.getHealth()<=0){
					list.poll();
					System.out.println("It is dead.");
				}
				else{
					list.poll();
					System.out.println("The health after taking turn is "+h.getHealth());
					int t = maxTimeStamp() + (int)(Math.random() * ((this.total_time - maxTimeStamp()) + 1));
					if (t<total_time-1){
						a.setTimestamp(t);
						list.add(a);
					}	
				}
			}
			else{
				if (a.equals(c1)){
					System.out.println("It is First Carnivore");
				}
				else{
					System.out.println("It is Second Carnivore");
				}
				carnivore c=(carnivore)a;
				carniTurn(c);
				if (c.turnfarherbi>=7){
					c.setHealth(c.getHealth()-6);
				}
				if (c.getHealth()<=0){
					list.poll();
					System.out.println("It is dead.");
				}
				else{
					list.poll();
					System.out.println("The health after taking turn is "+c.getHealth());
					int t = maxTimeStamp() + (int)(Math.random() * ((this.total_time - maxTimeStamp()) + 1));
					if (t<total_time-1){
						a.setTimestamp(t);
						list.add(a);
					}	
				}
				
			}
			System.out.println(" ");
			count++;
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
		
		
		InputReader sc=new InputReader(System.in);
		System.out.println("Enter Total Final Time for Simulation:");
		int t=sc.readInt();
		
		
		System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
		int xg1=sc.readInt();
		int yg1=sc.readInt();
		int rg1=sc.readInt();
		int ga1=sc.readInt();
		grassland g1=new grassland(xg1, yg1, rg1, ga1);
		System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
		int xg2=sc.readInt();
		int yg2=sc.readInt();
		int rg2=sc.readInt();
		int ga2=sc.readInt();
		grassland g2=new grassland(xg2, yg2, rg2, ga2);
		
		
		System.out.println("Enter Health and Grass Capacity for Herbivores:");
		int hh=sc.readInt();
		int hgc=sc.readInt();
		System.out.println("Enter x, y position and timestamp for First Herbivore:");
		int xh1=sc.readInt();
		int yh1=sc.readInt();
		point ph1=new point(xh1,yh1);
		int th1=sc.readInt();
		herbivore h1=new herbivore(hh, hgc, ph1, th1);
		System.out.println("Enter x, y position and timestamp for Second Herbivore:");
		int xh2=sc.readInt();
		int yh2=sc.readInt();
		point ph2=new point(xh2,yh2);
		int th2=sc.readInt();
		herbivore h2=new herbivore(hh, hgc, ph2, th2);
		
		
		System.out.println("Enter Health for Carnivores:");
		int hc=sc.readInt();
		System.out.println("Enter x, y position and timestamp for First Carnivore:");
		int xc1=sc.readInt();
		int yc1=sc.readInt();
		point pc1=new point(xc1,yc1);
		int tc1=sc.readInt();
		carnivore c1=new carnivore(hc, pc1, tc1);
		System.out.println("Enter x, y position and timestamp for Second Carnivore:");
		int xc2=sc.readInt();
		int yc2=sc.readInt();
		point pc2=new point(xc2,yc2);
		int tc2=sc.readInt();
		carnivore c2=new carnivore(hc, pc2, tc2);
		
		world w=new world(t,h1,h2,c1,c2,g1,g2);
		w.runSim();
	
	}

}
