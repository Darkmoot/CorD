package backEnd;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class Test {

	public static void main(String[] args) {
		
		
		try {
			File input = new File("src\\recources\\questions.xml");
//			System.out.println(input.getAbsolutePath());
//			System.out.println(input.exists());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(input);
			doc.getDocumentElement().normalize();
			// Gets root element
			System.out.println("root: " + doc.getDocumentElement().getNodeName());
			
			// Get all question elements
			NodeList nList = doc.getElementsByTagName("question");
			System.out.println(nList.getLength());
			
			System.out.println("------------------------");
			
			int i;
			for (i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				
				// Print out the type of question
//				System.out.println("type: " + node.getParentNode().getNodeName());
				
				// Get all the children elements
				NodeList childs = node.getChildNodes();
				
				// Even indexes are the element names, odd indices are the text of the previous element
				// So based on current xml, childs[1] gets the question, and childs[3] gets the answer
				String question = childs.item(1).getTextContent().replace("\\n", "\n");
				String answer = childs.item(3).getTextContent().replace("\\n", "\n");
				int difficulty = Integer.parseInt(node.getAttributes().getNamedItem("difficulty").getNodeValue());
				
				Question q;
				
				if (node.getParentNode().getNodeName() == "true-false-questions") {
					q = new TrueFalseQuestion(question, answer, difficulty);
					
					System.out.println(q);
					System.out.println("answer: " + q.getAnswer());
					System.out.println("difficulty: " + q.getDifficulty());
				}
				
				else if (node.getParentNode().getNodeName() == "return-value-questions") {
					q = new ReturnValueQuestion(question, answer, difficulty);
					
					System.out.println(q);
					System.out.println("answer: " + q.getAnswer());
					System.out.println("difficulty: " + q.getDifficulty());
				}
				
				System.out.println("\n");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
