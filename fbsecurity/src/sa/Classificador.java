package sa;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.functions.SMO;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Classificador {
	static void Classificador() throws Exception {
		
		DataSource source = new DataSource("classes-exp.arff");
		Instances data = source.getDataSet();
		
		DataSource teste = new DataSource("teste_class.arff");
		Instances testes = teste.getDataSet();

		data.setClass(data.attribute("@@class@@"));
		
		testes.setClass(testes.attribute("@@class@@"));

		SMO smo = new SMO();
		smo.buildClassifier(data);

	
		Evaluation evaluation = new Evaluation(testes);

		evaluation.evaluateModel(smo, testes);

		
		
		for (int i = 0; i < evaluation.predictions().size(); i++) {
			Prediction ev = evaluation.predictions().get(i);
			
			NominalPrediction np = (NominalPrediction) ev;
			
			System.out.println(ev.actual() + " " + ev.predicted());
			
		}

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
