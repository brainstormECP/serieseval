/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import serieseval.ProcessArff;
import serieseval.Seguridad;
import serieseval.model.*;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.DecisionStump;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Laura
 */
public class ArffController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("seriesevalPU");

    public void ExecuteExperiment(List<Algorithm> algoritmos, String arffFilePath, Integer from, Integer to, String testFilePath, Experimentgroup experiment) {

        String dirList = "C:\\experimentos\\" + experiment.getDescription() + "\\";
        SaveTestFiles(dirList + "\\test\\", testFilePath, from, to);
        ExecuteExperimentToLocal(algoritmos, arffFilePath, dirList, from, to, 0, "Test", experiment);
    }

    public void ExecuteExperiment(List<Algorithm> algoritmos, String arffFilePath, Integer from, Integer to, Integer paramentro, String opcion, Experimentgroup experiment) {
        String dirList = "C:\\experimentos\\" + experiment.getDescription() + "\\";
        ExecuteExperimentToLocal(algoritmos, arffFilePath, dirList, from, to, paramentro, opcion, experiment);
    }

    public Double[] Evaluar(Integer cantMeses) {
        Double[] result = new Double[cantMeses];

        return result;
    }

    public void SaveTestFiles(String destinationPath, String testFileDir, Integer from, Integer to) {
        ArrayList<Double[]> data = GetDataFromFile(testFileDir);
        File f = new File(destinationPath);
        f.mkdirs();
        for (int i = from; i <= to; i++) {
            SaveNewArrfFiles(data, i, destinationPath);
        }
    }

    public void ExecuteExperimentToLocal(List<Algorithm> algoritmos, String arffFilePath, String destinationPath, Integer from, Integer to, Integer paramentro, String opcion, Experimentgroup experiment) {
        ArrayList<Double[]> data = GetDataFromFile(arffFilePath);
        File f = new File(destinationPath + "data\\");
        File fr = new File(destinationPath + "resultados\\");
        f.mkdirs();
        fr.mkdirs();
        for (int i = from; i <= to; i++) {
            SaveNewArrfFiles(data, i, destinationPath + "data\\");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Datasource newDatasource = new Datasource(0, "k" + i + "N.arff");
            newDatasource.setIdexperimentgroup(experiment);
            experiment.getDatasourceCollection().add(newDatasource);
            em.persist(newDatasource);
            em.flush();
            em.getTransaction().commit();
            em.close();
            if (opcion.equals("CrossValidation")) {
                for (Algorithm algorithm : algoritmos) {
                    String result = ProcessArff.TrainAndClassifyInstancesCrossValidation(algorithm.getName(), destinationPath + "data\\k" + i + "N.arff", paramentro);
                    SaveResult(result, destinationPath + "resultados\\resultado_k" + i + "N (" + algorithm.getName() + ").txt", newDatasource, algorithm, 1, paramentro);
                }
            }
            if (opcion.equals("PercentageSplit")) {
                for (Algorithm algorithm : algoritmos) {
                    String result = ProcessArff.TrainAndClassifyInstancesPercentageSplit(algorithm.getName(), destinationPath + "data\\k" + i + "N.arff", paramentro);
                    SaveResult(result, destinationPath + "resultados\\resultado_k" + i + "N (" + algorithm.getName() + ").txt", newDatasource, algorithm, 2, paramentro);
                }
            }
            if (opcion.equals("Test")) {
                for (Algorithm algorithm : algoritmos) {
                    String result = ProcessArff.TrainAndClassifyInstancesTestFile(algorithm.getName(), destinationPath + "data\\k" + i + "N.arff", destinationPath + "test\\k" + i + "N.arff");
                    SaveResult(result, destinationPath + "resultados\\resultado_k" + i + "N (" + algorithm.getName() + ").txt", newDatasource, algorithm, 3, paramentro);
                }
            }

        }
    }

    public void SaveResult(String data, String destinationPath, Datasource datasource, Algorithm algorithm, Integer testOption, Integer parametro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = Seguridad.UsuarioActual();
        Testoption option = em.find(Testoption.class, testOption);

        Dmresult result = new Dmresult(datasource.getIddatasource(), algorithm.getIdalgorithm(), 1, option.getIdtestoption());
        result.setTestoptionparam(parametro);

        String[] rr = data.split("\n");

        for (String string : rr) {
            string = string.trim();
            if (string.contains("Correlation coefficient".subSequence(0, 22))) {
                String value = string.substring(string.lastIndexOf(" "), string.length());
                result.setCorrelationCoefficient(Double.parseDouble(value));
            }
            if (string.contains("Mean absolute error".subSequence(0, 18))) {
                String value = string.substring(string.lastIndexOf(" "), string.length());
                result.setMeanAbsoluteError(Double.parseDouble(value));
            }
            if (string.contains("Root mean squared error".subSequence(0, 22))) {
                String value = string.substring(string.lastIndexOf(" "), string.length());
                result.setRootMeanSquaredError(Double.parseDouble(value));
            }
            if (string.contains("Relative absolute error".subSequence(0, 22))) {
                String temp = string.substring(0, string.lastIndexOf(" ")).trim();
                String value = temp.substring(temp.lastIndexOf(" "), temp.length());
                result.setRelativeAbsoluteError(Double.parseDouble(value));
            }
            if (string.contains("Root relative squared error".subSequence(0, 26))) {
                String temp = string.substring(0, string.lastIndexOf(" ")).trim();
                String value = temp.substring(temp.lastIndexOf(" "), temp.length());
                result.setRootRelativeSquareError(Double.parseDouble(value));
            }
        }
        em.persist(result);
        em.flush();
        em.getTransaction().commit();
        em.close();
        try {
            //weka.core.converters.ArffSaver m_output = new ArffSaver();
            File m_outF = new File(destinationPath);
            m_outF.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(m_outF));
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ArffController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Double[] GetDataParaGrafico(Dmresult result, Integer cantMeses) {
        Double prediccion = 0.0;

        String range = result.getDatasource().getName().substring(1, 2);
        String dataSourceFile = "C:\\experimentos\\" + result.getDatasource().getIdexperimentgroup().getDescription() + "\\data\\" + result.getDatasource().getName();
        switch (result.getTestoption().getName()) {
            case "Cross validation":
                prediccion = ProcessArff.EvaluarCrossValidation(result.getAlgorithm().getName(), dataSourceFile, result.getTestoptionparam(), range);

                break;
            case "Split percentage":
                prediccion = ProcessArff.EvaluarPercentageSplit(result.getAlgorithm().getName(), dataSourceFile, result.getTestoptionparam(), range);

                break;
            case "Test":
                String testDir = "C:\\experimentos\\" + result.getDatasource().getIdexperimentgroup().getDescription() + "\\test\\" + result.getDatasource().getName();
                prediccion = ProcessArff.EvaluarTestFile(result.getAlgorithm().getName(), dataSourceFile, testDir, range);

                break;
        }

        Double[] data = new Double[cantMeses];
        data[data.length - 1] = prediccion;

        ArrayList<Double[]> instacias = GetDataFromFile(dataSourceFile);

        if (cantMeses <= instacias.size() + instacias.get(0).length) {

            Integer j = cantMeses - 2;

            Integer indexArrayList = instacias.size() - 1;
            Integer indexArray = instacias.get(indexArrayList).length - 1;
            Integer k = indexArray;
            while (j >= 0) {
                if (k < 0) {
                    indexArrayList--;
                    k = 0;
                }
                data[j] = instacias.get(indexArrayList)[k];
                k--;
                j--;
            }
            return data;
        }
        return null;
    }

    public ArrayList<Double[]> GetDataFromFile(String arffFilePath) {
        File arffFile = new File(arffFilePath);
        ArrayList<Double[]> data = new ArrayList<>();
        Integer count = 0;
        try {
            FileReader t = new FileReader(arffFile);
            BufferedReader reader = new BufferedReader(t);
            String line = reader.readLine();
            if (line != null) {
                String[] ent = line.split(" ");
                if (!ent[1].equals("timeserie")) {
                    throw new Exception("El fichero no es una serie temporal");
                }
                line = reader.readLine();
            }
            count = 0;
            while (!line.equals("@data")) {
                count++;
                line = reader.readLine();
            }
            line = reader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    String[] ent = line.split(",");
                    Double[] row = new Double[count];
                    for (int i = 0; i < count; i++) {
                        row[i] = Double.parseDouble(ent[i]);
                    }
                    data.add(row);
                }
                //System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error leyendo el fichero ARFF: " + e.getMessage());
        }
        return null;
    }

    public void SaveNewArrfFiles(ArrayList<Double[]> data, Integer count, String destinationPath) {
        try {
            ArrayList<Double[]> newData = ProcessArff.GenerateData(data, count + 1);
            for (Double[] doubles : newData) {
                String newLine = "";
                for (int j = 0; j < count; j++) {
                    newLine += doubles[j].toString() + ",";
                }
                newLine = newLine.substring(0, newLine.length() - 1);
                System.out.println(newLine);
            }
            File newFile = new File(destinationPath + "k" + count + "N.arff");
            ProcessArff.GenerateArffFile(newData, count + 1, newFile);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
