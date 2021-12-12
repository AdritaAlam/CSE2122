import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if (args.length!=1)
			System.out.println("Wrong argument!");
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferreader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String name = bufferreader.readLine();
				String i[] = name.split(",");			
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
				BufferedReader bufferreader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String name = bufferreader.readLine();
				String i[] = name.split(",");	
				Random randVal = new Random();
				int value = randVal.nextInt(i.length);
				if (i[value].startsWith("List"))
					value--;
				System.out.println(i[value]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+") && args[0].indexOf("+")==0 && args[0].length()>1){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferreader = new BufferedWriter(
					new FileWriter("students.txt", true));
				String target = args[0].substring(1);
				Date day = new Date();
				String dateformate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateformate);
				String fd= dateFormat.format(day);
				bufferreader.write(","+target+",List last updated on "+fd);
				bufferreader.close();
			} catch (Exception e){}

			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?") && args[0].indexOf("?")==0 && args[0].length()>1) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferreader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String name = bufferreader.readLine();
				String i[] = name.split(",");	
				boolean done = false;
				String target = args[0].substring(1);
				for(int index = 0; index<i.length && !done; index++) {
					if(i[index].equals(target)) {
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
				BufferedReader bufferreader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				String name = bufferreader.readLine();
				String i[] = name.split(",");	
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
		else 
			System.out.println("please enter right argument!");
	}
}