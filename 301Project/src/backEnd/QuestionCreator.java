package backEnd;

import java.util.Random;

import javax.xml.xpath.*;

import org.w3c.dom.*;

public class QuestionCreator {
	
	Document doc;
	
	
	public QuestionCreator(Document doc) {
		this.doc = doc;
	}


	public Question getRandomQuestion(XPathExpression expr) {
		
		Question q = null;
		try {
			// Get the list of nodes satisfying expr
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

}
