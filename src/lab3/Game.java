package lab3;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
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

//Good and Bad objects 

class good{
	int money;
	ArrayList<Human> Human_list=new ArrayList<Human>();
	ArrayList<FireDragon> FireDragon_list=new ArrayList<FireDragon>();
	ArrayList<Wolf> wolf_list=new ArrayList<Wolf>();
	
	public good(int m){
		money=m;
	}
	
}

class bad{
	int money;
	ArrayList<IceDragon> IceDragon_list=new ArrayList<IceDragon>();
	ArrayList<Daemon> Daemon_list=new ArrayList<Daemon>();

	public bad(int m){
		money=m;
	}
	
}

//GameFlow class
class GameFlow {
	good good;
	bad bad;
	int[] Human_stats=new int[4];
	int[] FireDragon_stats=new int[4];
	int[] IceDragon_stats=new int[4];
	int[] Daemon_stats=new int[4];
	int[] Wolf_stats=new int[4];
	
	public GameFlow(int m, int n){
		good=new good(m);
		bad=new bad(n);
	}
	
	public void add_Human_stats(int a, int b, int c, int d){
		Human_stats[0]=a;
		Human_stats[1]=b;
		Human_stats[2]=c;
		Human_stats[3]=d;
	}
	
	public void add_FireDragon_stats(int a, int b, int c, int d){
		FireDragon_stats[0]=a;
		FireDragon_stats[1]=b;
		FireDragon_stats[2]=c;
		FireDragon_stats[3]=d;
	}
	
	public void add_IceDragon_stats(int a, int b, int c, int d){
		IceDragon_stats[0]=a;
		IceDragon_stats[1]=b;
		IceDragon_stats[2]=c;
		IceDragon_stats[3]=d;
	}
	public void add_Daemon_stats(int a, int b, int c, int d){
		Daemon_stats[0]=a;
		Daemon_stats[1]=b;
		Daemon_stats[2]=c;
		Daemon_stats[3]=d;
	}
	public void add_Wolf_stats(int a, int b, int c, int d){
		Wolf_stats[0]=a;
		Wolf_stats[1]=b;
		Wolf_stats[2]=c;
		Wolf_stats[3]=d;
	}
	
	public Human make_human(String a){
		Human h=new Human(a, Human_stats[0],Human_stats[1],Human_stats[2],Human_stats[3]);
		return h;
	}
	public FireDragon make_firedragon(String a){
		FireDragon h=new FireDragon(a, FireDragon_stats[0],FireDragon_stats[1],FireDragon_stats[2],FireDragon_stats[3]);
		return h;
	}
	public Wolf make_wolf(String a){
		Wolf h=new Wolf(a, Wolf_stats[0],Wolf_stats[1],Wolf_stats[2],Wolf_stats[3]);
		return h;
	}
	public Daemon make_daemon(String a){
		Daemon h=new Daemon(a, Daemon_stats[0],Daemon_stats[1],Daemon_stats[2],Daemon_stats[3]);
		return h;
	}
	public IceDragon make_icedragon(String a){
		IceDragon h=new IceDragon(a, IceDragon_stats[0],IceDragon_stats[1],IceDragon_stats[2],IceDragon_stats[3]);
		return h;
	}
	public int[] get_good_type(String a){
		int[] r={-1,-1};
		for (int i=0;i<good.Human_list.size();i++){
			if (good.Human_list.get(i).getName().equals(a)){
				r[0]=1;
				r[1]=i;
				break;
			}
			else{
				continue;
			}
		}
		for (int i=0;i<good.FireDragon_list.size();i++){
			if (good.FireDragon_list.get(i).getName().equals(a)){
				r[0]=2;
				r[1]=i;
				break;
			}
			else{
				continue;
			}
		}
		for (int i=0;i<good.wolf_list.size();i++){
			if (good.wolf_list.get(i).getName().equals(a)){
				r[0]=3;
				r[1]=i;
				break;
			}
			else{
				continue;
			}
		}
		return r;	
	}
	
	public int[] get_bad_type(String a){
		int[] r={-1,-1};
		for (int i=0;i<bad.IceDragon_list.size();i++){
			if (bad.IceDragon_list.get(i).getName().equals(a)){
				r[0]=2;
				r[1]=i;
				break;
			}
			else{
				continue;
			}
		}
		for (int i=0;i<bad.Daemon_list.size();i++){
			if (bad.Daemon_list.get(i).getName().equals(a)){
				r[0]=1;
				r[1]=i;
				break;
			}
			else{
				continue;
			}
		}
		System.out.println(r[0]);
		return r;
		
	}
		
	
	public void good_menu(){
		System.out.println("Select Creatures for Team Good");
		System.out.println("1. Human");
		System.out.println("2. Fire Dragon");
		System.out.println("3. Wolf");
		System.out.println("4. Exit Selection");
	}
	
	public void bad_menu(){
		System.out.println("Select Creatures for Team Bad");
		System.out.println("1. Daemon");
		System.out.println("2. Ice Dragon");
		System.out.println("3. Exit Selection");
	}
	
	public void display_menu(){
		InputReader sc=new InputReader(System.in);
		while(this.good.money>=Math.min(Math.min(Human_stats[0], FireDragon_stats[0]), Wolf_stats[0])){
			this.good_menu();
			int num=sc.readInt();
			if (num==1){
				System.out.println("Enter Name of the Human");
				String name=sc.next();
				Human hum=this.make_human(name);
				this.good.Human_list.add(hum);
				good.money=good.money-Human_stats[0];
				
			}
			else if (num==2){
				System.out.println("Enter Name of the Fire Dragon");
				String name=sc.next();
				FireDragon fd=this.make_firedragon(name);
				this.good.FireDragon_list.add(fd);
				good.money=good.money-FireDragon_stats[0];
			}
			else if(num==3){
				System.out.println("Enter Name of the Wolf");
				String name=sc.next();
				Wolf w=this.make_wolf(name);
				this.good.wolf_list.add(w);
				good.money=good.money-Wolf_stats[0];
			}
			else{
				break;
			}
		}
		
		while (this.bad.money>=Math.min(Daemon_stats[0], IceDragon_stats[0])){
			this.bad_menu();
			int num=sc.readInt();
			if (num==1){
				System.out.println("Enter Name of the Daemon");
				String name=sc.next();
				Daemon d=this.make_daemon(name);
				this.bad.Daemon_list.add(d);
				bad.money=bad.money-Daemon_stats[0];
				
			}
			else if (num==2){
				System.out.println("Enter the name of the Ice Dragon");
				String name=sc.next();
				IceDragon ic=this.make_icedragon(name);
				this.bad.IceDragon_list.add(ic);
				bad.money=bad.money-IceDragon_stats[0];
			}
			else {
				break;
			}
		}
	}
	
}

//Game class which inherits the class

public class Game extends GameFlow{
	public Game(int m, int n) {
		super(m, n);
		// TODO Auto-generated constructor stub
	}
	
	public void fight(Creature one, Creature two){
		one.combat_damage(two);
		two.combat_damage(one);	
	}
	public void HvsDae(Human human, Daemon daemon){
		fight(human,daemon);
		if (daemon.spec_damage()==true){
			human.setHealth(human.getHealth()-human.getLoss());
		}
	}
	public void FDvsDae(FireDragon firedragon, Daemon daemon){
		fight(firedragon,daemon);
		if (daemon.spec_damage()==true){
			firedragon.setHealth(firedragon.getHealth()-firedragon.getLoss());
		}
		if (firedragon.spec_damage()==true){
			daemon.setHealth(daemon.getHealth()-25);
		}
	}
	public void WvsDae(Wolf wolf, Daemon daemon){
		fight(wolf,daemon);
		if (daemon.spec_damage()==true){
			wolf.setHealth(wolf.getHealth()-wolf.getLoss());
		}
	}
	public void HvsIceDragon(Human human, IceDragon icedragon){
		fight(human,icedragon);
		if (icedragon.spec_damage()==true){
			human.setHealth(human.getHealth()-25);
		}
		if (icedragon.attack_again()==true){
			human.setHealth(human.getHealth()-((int) Math.random()*icedragon.getPower()));
		}
	}
	public void FDvsIceDragon(FireDragon firedragon, IceDragon icedragon){
		fight(firedragon,icedragon);
		if (firedragon.spec_damage()==true){
			icedragon.setHealth(icedragon.getHealth()-25);
		}
		if (icedragon.spec_damage()==true){
			firedragon.setHealth(firedragon.getHealth()-25);
		}
		if (icedragon.attack_again()==true){
			firedragon.setHealth(firedragon.getHealth()-((int) Math.random()*icedragon.getPower()));
		}
	}
	public void WvsIceDragon(Wolf wolf, IceDragon icedragon){
		fight(wolf,icedragon);
		if (icedragon.spec_damage()==true){
			wolf.setHealth(wolf.getHealth()-25);
		}
		if (icedragon.attack_again()==true){
			wolf.setHealth(wolf.getHealth()-((int) Math.random()*icedragon.getPower()));
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader sc=new InputReader(System.in);
		System.out.println("Enter Team Good's total money");
		int l=sc.readInt();
		System.out.println("Enter Team Bad's total money");
		int m=sc.readInt();
		Game game=new Game(l,m);
		System.out.println("Enter cost, asset , power and health for Human (space-separated) -");
		int h1=sc.readInt();
		int h2=sc.readInt();
		int h3=sc.readInt();
		int h4=sc.readInt();
		game.add_Human_stats(h1, h2, h3, h4);
		
		System.out.println("Enter cost, asset , power and health for Fire Dragon (space-separated) -");
		int fd1=sc.readInt();
		int fd2=sc.readInt();
		int fd3=sc.readInt();
		int fd4=sc.readInt();
		game.add_FireDragon_stats(fd1, fd2, fd3, fd4);
		
		System.out.println("Enter cost, asset , power and health for Ice Dragon (space-separated) -");
		int id1=sc.readInt();
		int id2=sc.readInt();
		int id3=sc.readInt();
		int id4=sc.readInt();
		game.add_IceDragon_stats(id1, id2, id3, id4);
		
		System.out.println("Enter cost, asset , power and health for Daemon (space-separated) -");
		int d1=sc.readInt();
		int d2=sc.readInt();
		int d3=sc.readInt();
		int d4=sc.readInt();
		game.add_Daemon_stats(d1, d2, d3, d4);
		
		System.out.println("Enter cost, asset , power and health for Wolf (space-separated) -");
		int w1=sc.readInt();
		int w2=sc.readInt();
		int w3=sc.readInt();
		int w4=sc.readInt();
		game.add_Wolf_stats(w1, w2, w3, w4);
		
		game.display_menu();
		System.out.println("The War Begins");
		
		int[] g={-1,-1};
		int[] b={-1,-1};
//		System.out.println(h1);
//		System.out.println(fd1);
//		System.out.println(w1);
//		System.out.println(id1);
//		System.out.println(d1);
		int goodtotal=game.good.Human_list.size()+game.good.FireDragon_list.size()+game.good.wolf_list.size();
		int badtotal=game.bad.Daemon_list.size()+game.bad.IceDragon_list.size();
		while ((game.good.money>=0) && (game.bad.money>=0) && goodtotal!=0 && badtotal!=0){
			int round=1;
			if (g[0]==-1 && g[1]==-1 && b[0]==-1 && b[1]==-1){
			System.out.println("Round"+round+":");
			System.out.println("Enter Creature from Good’s Team to fight in the war -");
			String n1=sc.next();
			System.out.println("Enter Creature from Bad’s Team to fight in the war -");
			String n2=sc.next();
			g[0]=game.get_good_type(n1)[0];	
			g[1]=game.get_good_type(n1)[1];
			b[0]=game.get_bad_type(n2)[0];
			b[1]=game.get_bad_type(n2)[1];
			goodtotal+=1;
			badtotal+=1;
			}
			
			else if(g[0]==-1 && g[1]==-1 && b[0]!=-1 && b[1]!=-1){
				System.out.println("Round"+round+":");
				System.out.println("Enter Creature from Good’s Team to fight in the war -");
				String n1=sc.next();
				g[0]=game.get_good_type(n1)[0];	
				g[1]=game.get_good_type(n1)[1];
				goodtotal+=1;
			}
			else if (g[0]!=-1 && g[1]!=-1 && b[0]==-1 && b[1]==-1){
				System.out.println("Round"+round+":");
				System.out.println("Enter Creature from Bad’s Team to fight in the war -");
				String n2=sc.next();
				b=game.get_bad_type(n2);
				b[0]=game.get_bad_type(n2)[0];
				b[1]=game.get_bad_type(n2)[1];
				badtotal+=1;
			}
			
		if (((goodtotal!=0 && badtotal!=0))){
			if (g[0]==1 && b[0]==1){
				if(game.good.Human_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.HvsDae(game.good.Human_list.get(g[1]), game.bad.Daemon_list.get(b[1]));
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.Human_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.Human_list.get(b[1]).getAsset();
					System.out.println(game.bad.Daemon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					badtotal-=1;
					game.bad.Daemon_list.remove(b[1]);
					b[0]=-1;
					b[1]=-1;
					
				}
				else if (game.good.Human_list.get(g[1]).getHealth()<=0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.Daemon_list.get(b[1]).getAsset();
					System.out.println(game.good.Human_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					goodtotal-=1;
					game.good.Human_list.remove(g[1]);	
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.Daemon_list.remove(b[1]);
					game.good.Human_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
				
			}
			else if (g[0]==2 && b[0]==1){
				if (game.good.FireDragon_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.FDvsDae(game.good.FireDragon_list.get(g[1]), game.bad.Daemon_list.get(b[1]));
					
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.FireDragon_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.FireDragon_list.get(g[1]).getAsset();
					System.out.println(game.bad.Daemon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.bad.Daemon_list.remove(b[1]);
					badtotal-=1;
					b[0]=-1;
					b[1]=-1;
				}
				else if (game.good.Human_list.get(g[1]).getHealth()<=0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.Daemon_list.get(b[1]).getAsset();
					System.out.println(game.good.FireDragon_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.good.FireDragon_list.remove(g[1]);
					goodtotal-=1;
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.Daemon_list.remove(b[1]);
					game.good.FireDragon_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
			}
			else if (g[0]==3 && b[0]==1){
				if (game.good.wolf_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.WvsDae(game.good.wolf_list.get(g[1]), game.bad.Daemon_list.get(b[1]));
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.wolf_list.get(g[1]).getHealth()>0 && game.bad.Daemon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.wolf_list.get(g[1]).getAsset();
					System.out.println(game.bad.Daemon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.bad.Daemon_list.remove(b[1]);
					badtotal-=1;
					b[0]=-1;
					b[1]=-1;
				}
				else if (game.good.wolf_list.get(g[1]).getHealth()<=0 && game.bad.Daemon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.Daemon_list.get(b[1]).getAsset();
					System.out.println(game.good.wolf_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.good.wolf_list.remove(g[1]);
					goodtotal-=1;
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.Daemon_list.remove(b[1]);
					game.good.wolf_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
			}
			else if (g[0]==1 && b[0]==2){
				if (game.good.Human_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.HvsIceDragon(game.good.Human_list.get(g[1]), game.bad.IceDragon_list.get(b[1]));
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.Human_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.Human_list.get(b[1]).getAsset();
					System.out.println(game.bad.IceDragon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.bad.IceDragon_list.remove(b[1]);
					badtotal-=1;
					b[0]=-1;
					b[1]=-1;
				}
				else if (game.good.Human_list.get(g[1]).getHealth()<=0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.IceDragon_list.get(b[1]).getAsset();
					System.out.println(game.good.Human_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.good.Human_list.remove(g[1]);
					goodtotal-=1;
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.IceDragon_list.remove(b[1]);
					game.good.Human_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
			}
			else if (g[0]==2 && b[0]==2){
				if (game.good.FireDragon_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.FDvsIceDragon(game.good.FireDragon_list.get(g[1]), game.bad.IceDragon_list.get(b[1]));
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.FireDragon_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.FireDragon_list.get(g[1]).getAsset();
					System.out.println(game.bad.IceDragon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.bad.IceDragon_list.remove(b[1]);
					badtotal-=1;
					b[0]=-1;
					b[1]=-1;
				}
				else if (game.good.FireDragon_list.get(g[1]).getHealth()<=0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.IceDragon_list.get(b[1]).getAsset();
					System.out.println(game.good.FireDragon_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.good.FireDragon_list.remove(g[1]);
					goodtotal-=1;
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.IceDragon_list.remove(b[1]);
					game.good.FireDragon_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
			}
			else if(g[0]==3 && b[0]==2){
				if (game.good.wolf_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.WvsIceDragon(game.good.wolf_list.get(g[1]), game.bad.IceDragon_list.get(b[1]));
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
				}
				else if (game.good.wolf_list.get(g[1]).getHealth()>0 && game.bad.IceDragon_list.get(b[1]).getHealth()<=0){
					game.good.money=game.good.money+game.good.wolf_list.get(g[1]).getAsset();
					System.out.println(game.bad.IceDragon_list.get(b[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.bad.IceDragon_list.remove(b[1]);
					badtotal-=1;
					b[0]=-1;
					b[1]=-1;
				}
				else if (game.good.wolf_list.get(g[1]).getHealth()<=0 && game.bad.IceDragon_list.get(b[1]).getHealth()>0){
					game.bad.money=game.bad.money+game.bad.IceDragon_list.get(b[1]).getAsset();
					System.out.println(game.good.wolf_list.get(g[1]).getName()+" loses this round");
					System.out.println("Money Of Team Bad is"+game.bad.money);
					System.out.println("Money Of Team Good is"+game.good.money);
					game.good.wolf_list.remove(g[1]);
					goodtotal-=1;
					g[0]=-1;
					g[1]=-1;
				}
				else{
					game.bad.IceDragon_list.remove(b[1]);
					game.good.wolf_list.remove(g[1]);
					badtotal-=1;
					goodtotal-=1;
				}
			}
			round++;
			
		}
		
		
		}
		if(goodtotal==0 && game.good.money<Math.min(Math.min(h1, fd1), w1)){
			System.out.println("Team Good wins the war. The money the team has is "+game.good.money);
		}
		else{
			System.out.println("Team Bad wins the war. The money the team has is "+game.bad.money);
		}
		
		
		
		
		
		
		
		
	}
	
}
