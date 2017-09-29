package lab7;

import java.io.Serializable;

public class song implements Serializable{
	
	public String name;
	public String singer;
	public double duration;
	
	
	public song(String name, String singer, double duration) {
		this.name = name;
		this.singer = singer;
		this.duration = duration;
	}
	
	@Override
	public String toString(){
		return "Name: "+name+" Singer: "+singer+" Duration: "+duration;
	}
	
}
