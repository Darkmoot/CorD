package backEnd;

import java.util.Random;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class QuestionCreator {
	
	Document doc;
	XPath xpath;
	
	
	public QuestionCreator(Document doc, XPath xpath) {
		this.doc = doc;
		this.xpath = xpath;
	}

		
	/**
	 * Parses doc and gets a random question, then creates the Question object and returns it
	 * @return Question - return a Question object
	 */
	public Question getRandomQuestion() {
		
		Question q = null;
		try {
			// Get the list of nodes satisfying the expression
			XPathExpression expr = xpath.compile("//question");
			NodeList nl = (NodeList) expr.evaluate(this.doc, XPathConstants.NODESET);
			Random r = new Random();
			int index = r.nextInt(nl.getLength());
			
			// pull a random question out
			Element e = (Element) nl.item(index);
			// Get all the children elements
			NodeList childs = e.getChildNodes();
			
			// Even indexes are the element names, odd indices are the text of the previous element
			// So based on current xml, childs[1] gets the question, and childs[3] gets the answer
			
			// TODO: get hints as well
			String question = childs.item(1).getTextContent().replace("\\n", "\n").replace("\\t", "\t");
			String answer = childs.item(3).getTextContent().replace("\\n", "\n").replace("\\t", "\t");
			int difficulty = Integer.parseInt(e.getAttributes().getNamedItem("difficulty").getNodeValue());
			
			
			// TODO: find reason to have different question implementations, as currently no reason
			if (e.getParentNode().getNodeName() == "true-false-questions") {
				q = new TrueFalseQuestion(question, answer, difficulty);
			}
			
			else if (e.getParentNode().getNodeName() == "return-value-questions") {
				q = new ReturnValueQuestion(question, answer, difficulty);
			}
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	
	/**
	 * Parses doc and gets a random question with difficulty: difficulty,
	 * then creates the Question object and returns it
	 * @param difficulty of the question to retrieve
	 * @return a Question object
	 */
	public Question getRandomQuestion(int difficulty) {
		
		Question q = null;
		try {
			// Get the list of nodes satisfying expr
			String strepr = "//question[@difficulty=" + difficulty + "]";
			XPathExpression expr = xpath.compile(strepr);
			NodeList nl = (NodeList) expr.evaluate(this.doc, XPathConstants.NODESET);
			Random r = new Random();
			int index = r.nextInt(nl.getLength());
			
			// pull a random question out
			Element e = (Element) nl.item(index);
			// Get all the children elements
			NodeList childs = e.getChildNodes();
			
			// Even indexes are the element names, odd indices are the text of the previous element
			// So based on current xml, childs[1] gets the question, and childs[3] gets the answer
			
			// TODO: get hints as well
			String question = childs.item(1).getTextContent().replace("\\n", "\n").replace("\\t", "\t");
			String answer = childs.item(3).getTextContent().replace("\\n", "\n").replace("\\t", "\t");
			
			
			// TODO: find reason to have different question implementations, as currently no reason
			if (e.getParentNode().getNodeName() == "true-false-questions") {
				q = new TrueFalseQuestion(question, answer, difficulty);
			}
			
			else if (e.getParentNode().getNodeName() == "return-value-questions") {
				q = new ReturnValueQuestion(question, answer, difficulty);
			}
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
		
	}

}
