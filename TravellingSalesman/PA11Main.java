import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PA11Main {
	
	static DGraph dg;
	
	public static ArrayList<String[]> myData = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			File myObj = new File("tinyRW.mtx");
			Scanner myReader = new Scanner(myObj);
			
		      while (myReader.hasNextLine()) {
		    	  
		          String data = myReader.nextLine();
		          
		          if(!data.startsWith("%")) {
		        	  myData.add(data.split("\\s+"));

		          }
		        }
			
		      for(String[] each : myData) {
		    	  
		    	  if(dg == null) {
		    		  dg = new DGraph(Integer.parseInt(each[0]));

		    	  }else {
		    		  int u = Integer.parseInt(each[0]);
		    		  int v =  Integer.parseInt(each[1]);
		    		  double w = Double.parseDouble(each[2]);
		    		  dg.addEdge(u,v,w);
		    		  
		    	  }
		      }
		     // dg.Heruistic();
		      dg.BackTracking();
		      System.out.println(dg);
			
		}catch(Exception e) {
				
			 System.out.println(e.getMessage());
			
		}
		
		
		
	
	}
	
	
	
	
	
	
}