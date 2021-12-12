import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");			
				for(String j : i) 
				{ 
					if (!j.startsWith("List"))
						System.out.println(j); 
				}
			} 
			catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				Random x = new Random();
				int y = x.nextInt(i.length);
				if (i[y].startsWith("List"))
					y--;
				System.out.println(i[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				s.write(","+t+",List last updated on "+fd);
				s.close();
			} catch (Exception e){}

			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].equals(t)) {
						System.out.println("We found it!");
						done=true;
					}
				}
				if (done==false)
					System.out.println("The data doesn't exist");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				int count =0;		
				for(String j : i) 
				{ 
					if (!j.startsWith("List"))
						count++;
				}

				System.out.println(count +" word(s) found ");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}