package exercise01;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
	
	String[] questions = {
			"Every complete statement end with a: ",
			"A group of statements, such as the contents of a class or a method, are enclosed in: ",
			"These characters mark the beginning of a single-line: ",
			"You can use this class to display dialog boxes: ",
			"You can use this method to display formatted output in a console window: "		
	};
	
	String[][] multipleChoice = {
			{"period", "parenthesis", "semicolon", "ending brace"},
			{"braces{}","parenthesis()","brackets[]","none"},
			{"//","/*","*/","/**"},
			{"JOptionPane","ButferedReader","InputStreamReader","DialogBox"},
			{"Formatout.println","Console.Format","System.out.println","System.out.formatted"}
	};	
	
	int correctAnswer[] = {2, 0, 0, 0, 2};
	
	int userAnswer;
	int userAnswers[];
	double score = 0;
	
	public int simulateQuestion(int i) {
		return  JOptionPane.showOptionDialog(
				null, 
				questions[i], 
				"TEST COMP228 - LAB 02 ", 
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, multipleChoice[i],null);
	}
	
	public void checkAnswer(int currentAnswer) {
		if (userAnswer == correctAnswer[currentAnswer]) {
			score++;
			JOptionPane.showMessageDialog(null, generatePositiveMessage(""));		
		} else {
			String negativeMessage = generateNegativeMessage(" ");
			JOptionPane.showMessageDialog(null, negativeMessage);		
		}
	}
	
	public String generatePositiveMessage(String msg) {
		Random positive = new Random();
		
		int positiveMessage = positive.nextInt(4);
		
		switch(positiveMessage) {
		case 0: 
			return msg = "Excellent!";
		case 1:
			return msg = "Good job!";
		case 2:
			return msg = "You rock!";
		case 3:
			return msg = "Keep up the good work!";
		}
		return msg;
	}
	
	public String generateNegativeMessage(String msg) {
		Random negative = new Random();
		
		int negativeMessage =negative.nextInt(4);
		
		switch(negativeMessage) {
		case 0: 
			return msg = "Don't give up!";
		case 1:
			return msg = "Study more and try again!";
		case 2:
			return msg = "Not this time, keep trying!";
		case 3:
			return msg = "We learn from mistakes. Try again!";
		}
		return msg;
			
	}
	
	public void display() {
		
		double wrong = questions.length - score;
		double percentage = (score/questions.length) * 100;
		JOptionPane.showMessageDialog(
				null, "You got " + score + 
				" correct answers and " + wrong + " wrong answers.\n" +
				" The percentage of correct answers is: "
				+ percentage + "%."
		);
	}
	
	public void inputAnswer() {
		userAnswers = new int[questions.length];
		for(int i = 0; i < questions.length; i++) {
			userAnswer = simulateQuestion(i);
			checkAnswer(i);
			userAnswers[i] = userAnswer;
		}
		display();
	}
}
