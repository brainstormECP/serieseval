/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval;

import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.*;
import weka.classifiers.trees.DecisionStump;
import weka.core.*;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.core.converters.XRFFSaver;

/**
 *
 * @author Laura
 */
public class ProcessArff {

    public static ArrayList<Double[]> GenerateData(ArrayList<Double[]> data, Integer newSize) {
        ArrayList<Double> tempData = new ArrayList<>();
        Integer currentSize = data.get(0).length;
        Integer dataSize = data.size();
        for (int i = 0; i < currentSize; i++) {
            tempData.add(data.get(0)[i]);
        }
        for (int i = 1; i < dataSize; i++) {
            tempData.add(data.get(i)[currentSize - 1]);
        }

        ArrayList<Double[]> newData = new ArrayList<>();
        Integer j = 0;
        Double[] newRow = new Double[newSize];
        Integer tempDataSize = tempData.size();
        for (int i = 0; i < tempDataSize; i++) {
            Double element = tempData.get(i);
            if (j < newSize) {
                newRow[j] = element;
                if (j == newSize - 1) {
                    newData.add(newRow.clone());
                    i -= (newSize - 1);
                    j = -1;
                }
                j++;
            }
        }
        return newData;
    }

    public static void GenerateArffFile(ArrayList<Double[]> data, Integer size, File file) throws Exception {
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("@relation timeserie\n");
            for (int i = 1; i < size; i++) {
                writer.write("@attribute mes" + i + " real\n");
            }
            writer.write("@attribute actual real\n");
            writer.write("@data\n");
            for (Iterator<Double[]> row = data.iterator(); row.hasNext();) {
                Double[] doubles = row.next();
                String newLine = "";
                for (int i = 0; i < size; i++) {
                    newLine += doubles[i].toString() + ",";
                }
                newLine = newLine.substring(0, newLine.length() - 1);
                writer.write(newLine + "\n");
            }
            writer.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void TrainAndClassifyInstances(Classifier classifier, String trainFile, String testFile, String outputFile, Integer percent) {
        try {
            /*Cargar los datos para entrenar clasificador*/
            ConverterUtils.DataSource trainSource = new ConverterUtils.DataSource(trainFile);
            Instances trainInstances = trainSource.getDataSet();
            trainInstances.setClassIndex(trainInstances.numAttributes() - 1); /*Para indicar que el atributo a predicir es el ultimo*/

            /*Entrenar clasificador*/
            //classifier.setOptions(new String[]{"cx", "sdf"});
            classifier.buildClassifier(trainInstances);

            Evaluation eval = new Evaluation(trainInstances);
            eval.evaluateModel(classifier, trainInstances);

//            int trainSize = (int) Math.round(trainInstances.numInstances() * percent/ 100);
//            int testSize = trainInstances.numInstances() - trainSize;
//            Instances train = new Instances(trainInstances, 0, trainSize);
//            Instances test = new Instances(trainInstances, trainSize, testSize);            
//
//            classifier.buildClassifier(train);
            Double a = eval.correlationCoefficient();
            for (int i = 0; i < trainInstances.numInstances(); i++) {
                classifier.classifyInstance(trainInstances.instance(i));
            }

            /*Cargar los datos que se desean clasificar*/
            ConverterUtils.DataSource m_testSource = new ConverterUtils.DataSource(testFile);
            Instances m_testInstances = m_testSource.getDataSet();
            m_testInstances.setClassIndex(m_testInstances.numAttributes() - 1); /*Para indicar que el atributo a predicir es el ultimo*/


            /*Clasificar cada instancia nueva. Notar que no importa que en el fichero la columna correspondiente al
             atributo que se quiere predecir tenga algun valor, WEKA lo ignora en este caso, es decir se puede poner cualquier cosa, probar por ejemplo con
             segment-test_1.arff*/
//            ArrayList<String> m_clasificaciones=new ArrayList<String>(); /*Para guardar la clasificacion de cada instancia de prueba*/
//            for (int i = 0; i < m_testInstances.numInstances(); i++)
//            {
//              /*Notar que classifyInstance retorna un double, no obstante como el problema es de clasificacion
//               se puede utilizar int. Es importante que se utilice un fichero .arff en el entrenamiento pues de utilizar
//               un .csv weka asume que el problema es de regresion*/
//              int m_result=(int)classifier.classifyInstance(m_testInstances.instance(i));
//               m_testInstances.instance(i).setClassValue(m_result);
//              // m_clasificaciones.add(Num_to_Class(m_result));
//            }
            /*Imprimir los resultados, o si se quiere escribirlos para un fichero*/
            weka.core.converters.ArffSaver m_output = new ArffSaver();
            File m_outF = new File(outputFile);
            m_outF.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(m_outF));
            writer.write(classifier.toString());
            //writer.write(classifier.getCapabilities().toString());
            writer.close();
//            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(m_outF));
//            writer.writeObject(classifier.toString());            
//            m_output.setFile(m_outF);
//            m_output.setInstances(trainInstances);
//            m_output.writeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String TrainAndClassifyInstancesCrossValidation(String classifier, String trainFile, Integer numFolds) {
        String[] options = new String[4];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-x";
        options[3] = numFolds.toString();        
        return TrainInstances(classifier, options);
    }

    public static String TrainAndClassifyInstancesPercentageSplit(String classifier, String trainFile, Integer percent) {
        String[] options = new String[4];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-split-percentage";
        options[3] = percent.toString();
        return TrainInstances(classifier, options);
    }
    
    public static String TrainAndClassifyInstancesTestFile(String classifier, String trainFile,String testFile) {
        String[] options = new String[4];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-T";
        options[3] = testFile;         
        return TrainInstances(classifier, options);
    }

    public static String TrainInstances(String classifier, String[] options) {
        try {            
            return Evaluation.evaluateModel(classifier, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }
    
    public static Double EvaluarCrossValidation(String classifier, String trainFile, Integer numFolds, String range) {
        String[] options = new String[6];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-x";
        options[3] = numFolds.toString();        
        options[4] = "-p";
        options[5] = range; 
        return Evaluate(classifier, options);        
    }
    
    public static Double EvaluarPercentageSplit(String classifier, String trainFile, Integer percent, String range) {
        String[] options = new String[6];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-split-percentage";
        options[3] = percent.toString();
        options[4] = "-p";
        options[5] = range; 
        return Evaluate(classifier, options);   
    }
    
    public static Double EvaluarTestFile(String classifier, String trainFile,String testFile, String range) {
        String[] options = new String[6];
        options[0] = "-t";
        options[1] = trainFile;
        options[2] = "-T";
        options[3] = testFile; 
        options[4] = "-p";
        options[5] = range; 
        return Evaluate(classifier, options);
    }

    
    public static Double Evaluate(String classifier, String[] options){
        double pred = 0;
        try {            
            String ss = Evaluation.evaluateModel(classifier, options);
            
            String[] rr = ss.split("\n");
            String[] prediccion = rr[rr.length - 1].split(" ");

            
            int count = 0; 
            for (String string : prediccion) {
                if (!"".equals(string)) {
                    count ++;
                    if (count == 3) {
                       pred = Double.parseDouble(string);
                       break;
                    }
                }
            }
            
            String a = "stop";
            
        } catch (Exception ex) {
            /*Logger.getLogger(ProcessArff.class.getName()).log(Level.SEVERE, null, ex);*/
            ex.printStackTrace();
        }
        return pred;
    }
}
