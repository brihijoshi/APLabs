package lab7;
import java.io.*;
import java.util.*;

class SongNotFoundException extends Exception{
	public SongNotFoundException(String Message){
		super(Message);
	}
}

public class playlist {
	
	static ArrayList<song> plist;
	static ArrayList<song> plist_out;
	
	static song s1 =new song("Dusk till Dawn","ZAYN ft Sia",3.15);
	static song s2 =new song("Beautiful Creatures","Illenium",4);
	static song s3 =new song("Paper Love","Allie X",5.30);
	
	public static void setup(String name){
		plist_out=new ArrayList<song>();
		plist_out.add(s1);
		plist_out.add(s2);
		plist_out.add(s3);
		serialise(name);
	}
	
	
	public static void serialise(String name){
		try{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("./"+name+".ser"));
			for (int i=0;i< plist_out.size();i++){
				out.writeObject(plist_out.get(i));
			}
			out.close();
			//System.out.println("Object Serialised");
		}
		catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public static void deserialise(String name) throws ClassNotFoundException, EOFException{
		plist=new ArrayList<song>();
		try{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("./"+name+".ser"));
			try{
				while (true){
					song x=(song) in.readObject();
					plist.add(x);
				}
			}
			catch (EOFException e){
				
			}
		}
		catch (IOException i){
			i.printStackTrace();
		}
		//System.out.println("Object Deserialised");
		plist_out=plist;
	}
	
	public static void getPlaylistMenu(){
		File curDir=new File(".");
		File[] filesList=curDir.listFiles();
		for (File f: filesList){
			if (f.isFile()){
				if (f.getName().toLowerCase().endsWith(".ser")){
					System.out.println(f.getName());
				}
			}
		}
	}
	
	public static int countSongs() {
		return plist.size();
	}
	
	public static void add(String name, String singer, double duration, String filename)throws EOFException, ClassNotFoundException{
		deserialise(filename);
		song newsong=new song(name, singer, duration);
		plist_out.add(newsong);
		serialise(filename);
	}
	
	public static void show(String filename) throws EOFException, ClassNotFoundException, SongNotFoundException {
		deserialise(filename);
		if (plist.size()==0){
			throw new SongNotFoundException("No Song Exists");
		}
		else{
			for (int i=0;i<plist.size();i++){
				System.out.println(plist.get(i).toString());
			}
		}
	}
	
	public static void Search(String name, String filename) throws EOFException, ClassNotFoundException, SongNotFoundException {
		
		deserialise(filename);
		int flag=0;
		for (int i=0;i<plist.size();i++){
			if (name.equals(plist.get(i).name)){
				flag=1;
				System.out.println(plist.get(i).toString());
			}
		}
		if (flag==0) System.out.println(("The song does not exist"));
	}
	
	public static void Delete(String name, String filename) throws EOFException, ClassNotFoundException, SongNotFoundException{
		deserialise(filename);
		int flag=0;
		for (int i=0;i<plist.size();i++){
			if (name.equals(plist.get(i).name)){
				plist_out.remove(i);
				serialise(filename);
				System.out.println("The number of songs now are "+countSongs());
				flag=1;
			}
		}
		if (flag==0) System.out.println("The song does not exist!");

	}
	
	public static void back(){
		getPlaylistMenu();
	}
	
	public static void menu_list(){
		System.out.println("Select one of the options: ");
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. Search");
		System.out.println("4. Show");
		System.out.println("5. Back");
		System.out.println("6. Exit");
	}
	
	public static void menu() throws EOFException, ClassNotFoundException, SongNotFoundException{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Available Playlists : ");
		getPlaylistMenu();
		System.out.println("Choose a playlist from the above list: ");
		String playlist_name=sc.nextLine();
		setup(playlist_name);
		/*deserialise(playlist_name);
		System.out.println("Number of songs in this playlist:");
		System.out.println(countSongs());
		menu_list();
		int choice=sc.nextInt();
		
		while (choice!=6){
			switch(choice){
			case 1:
				Scanner sc1=new Scanner(System.in);
				System.out.println("Song: ");
				String name=sc1.nextLine();
				System.out.println("Singer: ");
				String singer=sc1.nextLine();
				System.out.println("Duration: ");
				Double dur=Double.parseDouble(sc1.nextLine());
				add(name,singer,dur,playlist_name);
				System.out.println("Number of songs in this playlist:");
				System.out.println(countSongs());
				System.out.println("The songs in the current playlist are: ");
				show(playlist_name);
				menu_list();
				choice=sc1.nextInt();
				break;
			case 2:
				Scanner sc2=new Scanner(System.in);
				System.out.println("Enter the name of the song to be deleted");
				String name_del=sc2.nextLine();
				Delete(name_del,playlist_name);
				System.out.println("Number of songs in this playlist:");
				System.out.println(countSongs());
				System.out.println("The songs in the current playlist are: ");
				show(playlist_name);
				menu_list();
				choice=sc2.nextInt();
				break;
			case 3:
				Scanner sc3=new Scanner(System.in);
				System.out.println("Enter the name of the song to be searched");
				String name_search=sc3.nextLine();
				Search(name_search,playlist_name);
				menu_list();
				choice=sc3.nextInt();
				break;
			case 4:
				Scanner sc4=new Scanner(System.in);
				System.out.println("The songs in the current playlist are: ");
				show(playlist_name);
				menu_list();
				choice=sc4.nextInt();
				break;
			case 5:
				Scanner sc5=new Scanner(System.in);
				System.out.println("Available Playlists : ");
				getPlaylistMenu();
				System.out.println("Choose a playlist from the above list: ");
				playlist_name=sc5.nextLine();
				//setup(playlist_name);
				deserialise(playlist_name);
				System.out.println("Number of songs in this playlist:");
				System.out.println(countSongs());
				menu_list();
				choice=sc5.nextInt();
				break;
			}
		}
		*/
		
		
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SongNotFoundException {
		// TODO Auto-generated method stub
		
		menu();
		
	
	}

}
