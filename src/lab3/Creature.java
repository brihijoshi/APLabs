package lab3;


//Brihi Joshi
//2016142
//Lab3

//Creature class which creates the Creature objects
public class Creature {

	private String name;
	private int power;
	private int health;
	private int cost;
	private int asset;
	private int loss;
	
	public Creature(String name, int power, int health, int cost, int asset) {
		this.name = name;
		this.power = power;
		this.health = health;
		this.cost = cost;
		this.asset = asset;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAsset() {
		return asset;
	}
	public void setAsset(int asset) {
		this.asset = asset;
	}
	


	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void combat_damage(Creature creature){
		int loss = (int) Math.random()*creature.power;
		this.setHealth(this.getHealth()-loss);
		this.loss=loss;
	}

}

//Special Damage interface which tackles the Dragon and Daemon case
interface special_damage{
	public boolean spec_damage();
}

//Inherited Classes from Creature
class Human extends Creature{
	public Human(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}	
}

class Dragon extends Creature implements special_damage{
	public Dragon(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}	
	
	public boolean spec_damage(){
		int chance = (int) Math.random()*100+1;
		if (chance<=15){
			return true;	
		}
		else{
			return false;
		}
	}
}

class Daemon extends Creature implements special_damage{
	public Daemon(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}
	
	public boolean spec_damage(){
		int chance = (int) Math.random()*100+1;
		if (chance<=50){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}

class Wolf extends Creature{
	public Wolf(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}	
}

class FireDragon extends Dragon{
	public FireDragon(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}	
}

class IceDragon extends Dragon{
	public IceDragon(String name, int power, int health, int cost, int asset) {
		super(name, power, health, cost, asset);
		// TODO Auto-generated constructor stub
	}	
	
	public boolean attack_again(){
		int chance = (int) Math.random()*100+1;
		if (chance<=5){
			return true;
		}
		else{
			return false;
		}
	}	
}



