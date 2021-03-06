// Class: QuestionPool.java
// Lead Contributor: Andrew Durkiewicz
// Description: A singleton class that reads in the data from an input file and converts it into questions.

package pack;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuestionPool {
	private static QuestionPool firstInstance = null;
	ArrayList<ArrayList<String>> questions = new ArrayList<ArrayList<String>>();
	ArrayList<String> qProperties; 
	

	private QuestionPool() throws IOException {
		FileReader file = new FileReader("resources//InputFile.txt");
		BufferedReader reader = new BufferedReader(file);
		String getLine;
		try {
			while((getLine = reader.readLine()) != null) {
				if(getLine.contains("qBegin") || getLine == "\n"){
					qProperties = new ArrayList<String>(); // when a qBegin exists, this is the start of a new Question
					continue;} //gets rid of the qBegin
				else if(getLine.contains("//")) {continue;} //skip any comment
				else if(getLine.contains("qEnd") == false) {
					qProperties.add(getLine); //while between qBegin and qEnd, add the contents to the array
				}
				else if(getLine.contains("qEnd")) {
					questions.add(qProperties); //at qEnd we need to stop and add our qProperties to questions
					continue;}
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.close();
	}
	
	public static QuestionPool getInstance() throws IOException {
		if(firstInstance == null) {
			firstInstance = new QuestionPool();
		}
		return firstInstance;
	}

}
