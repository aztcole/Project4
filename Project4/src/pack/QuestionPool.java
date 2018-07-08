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
		FileReader file = new FileReader("resources\\InputFile.txt");
		BufferedReader reader = new BufferedReader(file);
		String getLine;
		try {
			while((getLine = reader.readLine()) != null) {
				if(getLine.contains("qBegin") || getLine == "\n"){continue;}
				if(getLine.contains("//")) {
					qProperties = new ArrayList<String>();
					continue;
					} //skip the question number and begin
				if(getLine.contains("qEnd") == false) {
					qProperties.add(getLine);
				}
				else if(getLine.contains("qEnd")) {
					questions.add(qProperties);
					continue;}
				
			}
			for(int i = 0; i< questions.size(); i++) {
				System.out.println(questions.get(i) + "\n");
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
