package pack;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class QuestionPool {
	private static QuestionPool firstInstance = null;
	ArrayList<ArrayList<String>> questions = new ArrayList<ArrayList<String>>();
	

	private QuestionPool() throws IOException {
		FileReader file = new FileReader("resources\\InputFile.txt");
		BufferedReader reader = new BufferedReader(file);
		String before;
		String after;
		String getLine;
		try {
			while((getLine = reader.readLine()) != null) {
				if(getLine.contains("qBegin") || getLine.contains("//")) {continue;}
				System.out.println(getLine);
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
