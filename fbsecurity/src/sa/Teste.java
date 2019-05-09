package sa;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Teste {
	public static void main(String[] args) throws Exception {
		//importa a base de dados ARFF utilizando classes da Weka
		DataSource source = new DataSource("teste.arff");
		Instances D = source.getDataSet();
		
		//imprime informações associadas à base de dados
		System.out.println("Num. instancias:" + D.numInstances());  
		System.out.println("Num. atributos:" + D.numAttributes());  
		//imprime o conteúdo da base   
		System.out.println("Base de Dados:");
		System.out.println(D.toString());
		
		
		
	}
}

