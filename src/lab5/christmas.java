/**
 * @author Brihi Joshi
 * 2016142
 * CSE
 * @version 0.6
 * 
 */




package lab5;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;





public class christmas {
	
	public static void main(String[] args) throws FileNotFoundException{
		Map<Integer,ArrayList<Object>> students = new HashMap<Integer,ArrayList<Object>>();
		BSTFilesBuilder b=new BSTFilesBuilder();
		Scanner sc=new Scanner(System.in);
		int numTrees=sc.nextInt();
		int numStudents=sc.nextInt();
		b.createBSTFiles(numStudents, numTrees);
		for (int j=1;j<=numTrees;j++){
	        BufferedReader br = null;
	        try {
	        	ArrayList<Object> inputStudents=new ArrayList<Object>();
	            br = new BufferedReader(new FileReader("./src/"+j+".txt"));
	            String line=br.readLine();
	            int n=Integer.parseInt(br.readLine());
	            String[] tokens=br.readLine().split(" ");
	            if (line.equals("Integer")){
	            	
	            	for (int i=0;i<n;i++){
	            		inputStudents.add(Integer.parseInt(tokens[i]));
	            	}
	            }
	            else if (line.equals("Float")){
	            	for (int i=0;i<n;i++){
	            		inputStudents.add(Float.parseFloat(tokens[i]));
	            	}
	            }
	            else{
	            	for (int i=0;i<n;i++){
	            		inputStudents.add(tokens[i]);
	            	}
	            }
	            ArrayList<Object> answer=new ArrayList<Object>();
	    		if (line.equals("Integer")){
	    			BST<Integer> bs=new BST<Integer>((int)inputStudents.get(0));
	    			for (int i=1;i<inputStudents.size();i++){
	    				bs.insert(bs.getRoot(), (int)inputStudents.get(i));
	    			}
	    			bs.inorder(bs.getRoot());
	    			int sum=0;
	    			for (int i=0;i<bs.list.size();i++){
	    				sum+=bs.list.get(i);
	    			}
	    			for (int i=0;i<bs.list.size();i++){
	    				if (bs.list.get(i).equals((int)inputStudents.get(0))){
	    					if (students.get(i+1)==null){
	    						answer.add(sum);
	    						students.put(i+1, answer);
	    					}
	    					else{
	    						students.get(i+1).add(sum);
	    					}
	    				}
	    			}
	    		}
	    		
	    		else if (line.equals("Float")){
	    			BST<Float> bs=new BST<Float>((float)inputStudents.get(0));
	    			for (int i=1;i<inputStudents.size();i++){
	    				bs.insert(bs.getRoot(), (float)inputStudents.get(i));
	    			}	
	    			bs.inorder(bs.getRoot());
	    			float sum=0;
	    			for (int i=0;i<bs.list.size();i++){
	    				sum+=bs.list.get(i);
	    			}
	    			for (int i=0;i<bs.list.size();i++){
	    				if (bs.list.get(i).equals((float)inputStudents.get(0))){
	    					if (students.get(i+1)==null){
	    						answer.add(sum);
	    						students.put(i+1, answer);
	    					}
	    					else{
	    						students.get(i+1).add(sum);
	    					}
	    				}
	    			}

	    		}
	    		
	    		else{
	    			BST<String> bs=new BST<String>((String)inputStudents.get(0));
	    			for (int i=1;i<inputStudents.size();i++){
	    				bs.insert(bs.getRoot(), (String)inputStudents.get(i));
	    			}
	    			bs.inorder(bs.getRoot());
	    			String sum="";
	    			for (int i=0;i<bs.list.size();i++){
	    				sum+=bs.list.get(i);
	    			}
	    			for (int i=0;i<bs.list.size();i++){
	    				if (bs.list.get(i).equals((String)inputStudents.get(0))){
	    					if (students.get(i+1)==null){
	    						answer.add(sum);
	    						students.put(i+1, answer);
	    					}
	    					else{
	    						students.get(i+1).add(sum);
	    					}
	    				}
	    			}
	    		}     
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
	        finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	            } 
	            catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
		PrintWriter w = new PrintWriter("./src/answer.txt");
		try{
			Set<Integer> keys = students.keySet(); 
	        
			for(Integer i: keys)
	        {
	        	w.print(i+" ");
	        	for (int j=0;j<students.get(i).size();j++){
	        		w.print(students.get(i).get(j)+" ");
	        	}
	        	w.println();
	        }
			int n=students.size();
			w.println(numStudents-n);
			w.close();
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
