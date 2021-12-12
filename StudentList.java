import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

//		bufferfile reader

	public static BufferedReader fileReader() {
		try {
				BufferedReader bufferreader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				return bufferreader;
			}
		catch (Exception e){
			return null;
		}

	}
//		bufferfile writer
	public static BufferedWriter fileWriter() {
		try {
				BufferedWriter bufferreader = new BufferedWriter(
					new FileWriter("students.txt", true));
				return bufferreader;
			}
		catch (Exception e){
			return null;
		}

	}

	public static void main(String[] args) {

//		Check arguments
		if (args.length!=1)
			System.out.println(Constants.wrngarg);
		else if(args[0].equals(Constants.list)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader bufferreader = fileReader();
				String name = bufferreader.readLine();
				String i[] = name.split(Constants.comma);			
				for(String j : i) 
				{ 
					if (!j.startsWith("List"))
						System.out.println(j); 
				}
			} 
			catch (Exception e){} 
			System.out.println(Constants.dataLoaded);
		}
//			random name checking
		else if(args[0].equals(Constants.randomName)) 
		{
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader bufferreader = fileReader();
				String name = bufferreader.readLine();
				String i[] = name.split(Constants.comma);	
				Random randVal = new Random();
				int value = randVal.nextInt(i.length);
				if (i[value].startsWith("List"))
					value--;
				System.out.println(i[value]);
			} catch (Exception e){} 
			System.out.println(Constants.dataLoaded);			
		}
//			add new name 
		else if(args[0].contains(Constants.add) && args[0].indexOf(Constants.add)==0 && args[0].length()>1){
			System.out.println(Constants.loadingData);			
			try {
				BufferedWriter bufferreader = fileWriter();
				String target = args[0].substring(1);
				Date day = new Date();
				String dateformate = Constants.dmy;
				DateFormat dateFormat = new SimpleDateFormat(dateformate);
				String fd= dateFormat.format(day);
				bufferreader.write(Constants.comma+target+Constants.listLast+fd);
				bufferreader.close();
			} catch (Exception e){}

			System.out.println(Constants.dataLoaded);	
		}
//			searching a name 
		else if(args[0].contains(Constants.search) && args[0].indexOf(Constants.search)==0 && args[0].length()>1) 
		{
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader bufferreader = fileReader();
				String name = bufferreader.readLine();
				String i[] = name.split(Constants.comma);	
				boolean done = false;
				String target = args[0].substring(1);
				for(int index = 0; index<i.length && !done; index++) {
					if(i[index].equals(target)) {
						System.out.println(Constants.found);
						done=true;
					}
				}
				if (done==false)
					System.out.println(Constants.dontEx);
			} catch (Exception e){} 
			System.out.println(Constants.dataLoaded);				
		}
//			counting the input data 
		else if(args[0].contains(Constants.count)) 
		{
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader bufferreader = fileReader();
				String name = bufferreader.readLine();
				String i[] = name.split(Constants.comma);	
				int count =0;		
				for(String j : i) 
				{ 
					if (!j.startsWith("List"))
						count++;
				}

				System.out.println(count +Constants.wf);
			} catch (Exception e){} 
			System.out.println(Constants.dataLoaded);				
		}
// if the user enter the wrong arguments
		else 
			System.out.println(Constants.enter);
	}
}