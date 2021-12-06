import java.io.*;
import java.text.*;
import java.util.*;

// Task#1;
// Task#2;
// Task#3;

public class StudentList {

	public static void main(String[] args) {

//              Check arguments

		if(args.length == 0) {

			System.out.println("Enter one argument");
		}

		else if(args.length > 1) {

			System.out.println("Multiple argument passes.");
		}

		else if(args[0].length > 1) {

			System.out.println("Sorry ! Enter correct argument.");
		}

		else if(args[0].equals("a")) {

			System.out.println("Loading data ...");

			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

				String Lines = bufferedReader.readLine();

				String students[] = Lines.split(",");
				for(String student : students) {
					System.out.println(student);
				}

			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r"))
		{
			System.out.println("Loading data ...");

			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

				String Lines = bufferedReader.readLine();
				System.out.println(Lines);

				String students[] = Lines.split(",");

				Random random = new Random();
				int random_name = random.nextInt();
				System.out.println(students[random_name]);

			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}

		else if(args[0].contains("+")){

			System.out.println("Loading data ...");

			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));

				String new_student = args[0].substring(1);
				Date date = new Date();
				String date_of_month = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(date_of_month);
				String updated_date = dateFormat.format(date);
				bufferedWriter.write(", "+t+"\nList last updated on "+updated_date);
				bufferedWriter.close();

			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}

		else if(args[0].contains("?"))
		{
			System.out.println("Loading data ...");

			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

				String Lines = bufferedReader.readLine();

				String students[] = Lines.split(",");
				boolean done = false;
				String new_student = args[0].substring(1);

				for(int idx = 0; idx<i.length && !done; idx++) {

					if(students[idx].equals(new_student)) {
						System.out.println("We found it!");
						done=true;
					}
				}

			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}

		else if(args[0].contains("c"))
		{
			System.out.println("Loading data ...");

			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

				String date = bufferedReader.readLine();

				char words[] = date.toCharArray();
				boolean in_word = false;
				int count=0;

				for(char c:words) {

					if(c ==' ')
					{
						if (!in_word) {
							count++;
							in_word =true;
						}
						else {
							in_word=false;
						}
					}
				}

				System.out.println(count +" word(s) found " + words.length);

			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}
	}
}
