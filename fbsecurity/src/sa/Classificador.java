package sa;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Classificador {
	static void Classificador() throws Exception {
		DataSource source = new DataSource("classes-exp1.arff");
		Instances data = source.getDataSet();
		
		data.setClass(data.attribute("@@class@@"));
		
		 SMO smo = new SMO();
	     smo.buildClassifier(data);
	     
	     Evaluation evaluation = new Evaluation(data);
	     
	     evaluation.evaluateModel(smo, data);
	     
	     System.out.println(smo.toString());
	     
	     System.out.println(evaluation.toSummaryString());
	     
	     System.out.println(evaluation.numTruePositives(1));
	     
	}
	
	
	
	public static void main(String[] args) {
		try {
			Classificador();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
