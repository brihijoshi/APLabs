package lab4;

public abstract class animal implements Comparable<animal>{
	private int health;
	point coords;
	private int timestamp;
	
	abstract String getType();
	public animal(int health, point coords, int timestamp) {
		this.health = health;
		this.coords = coords;
		this.timestamp = timestamp;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public point getCoords() {
		return coords;
	}

	public void setCoords(point coords) {
		this.coords = coords;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String toString() {
		return "animal [health=" + health + ", coords=" + coords.x + " "+ coords.y + ", timestamp=" + timestamp + "]";
	}
	public int compareTo(animal a){
		if (timestamp<a.timestamp){
			return -1;
		}
		else if (timestamp>a.timestamp){
			return 1;
		}
		else {
			if (health>a.health){
				return -1;
			}
			else if (health<a.health){
				return 1;
			}
			else{
				if (getType()=="h" && a.getType()=="c"){
					return -1;
				}
				else if (getType()=="c" && a.getType()=="h"){
					return 1;
				}
				else{
					if (coords.getDistance(0, 0)<a.coords.getDistance(0, 0)){
						return -1;
					}
					else if (coords.getDistance(0, 0)>a.coords.getDistance(0, 0)){
						return 1;
					}
					else{
						return 0;
					}
				}
			}
		}
	}
}
class herbivore extends animal{
	private int grass_capacity;
	int turnsoutside;
	
	public herbivore(int health,int grass_capacity, point coords, int timestamp) {
		super(health, coords, timestamp);
		this.grass_capacity=grass_capacity;
		turnsoutside=0;
		// TODO Auto-generated constructor stub
	}
	
	public int getGrass_capacity() {
		return grass_capacity;
	}
	public void setGrass_capacity(int grass_capacity) {
		this.grass_capacity = grass_capacity;
	}	
	public String getType(){
		return "h";
	}
	
	
	
}
class carnivore extends animal{
	int turnfarherbi;	
	public carnivore(int health, point coords, int timestamp) {
		super(health, coords, timestamp);
		turnfarherbi=0;
		// TODO Auto-generated constructor stub
	}

	public String getType(){
		return "c";
	}
}