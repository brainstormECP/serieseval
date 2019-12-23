/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;
import serieseval.model.*;

/**
 *
 * @author Laura
 */
public class ExperimentController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("seriesevalPU");

    public void Create(String descripcion, Date fecha) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Experimentgroup experiment = new Experimentgroup(0, descripcion, fecha);
        em.persist(experiment);
        em.flush();
        em.getTransaction().commit();
        em.close();
        File file = new File("C:\\experimentos\\" + descripcion + "\\");
        if (!file.exists()) {
            file.mkdir();
        }

    }

    public Experimentgroup AddDatasource(String path, Experimentgroup experiment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String[] dir;
        dir = path.split("\\\\");
        String name = dir[dir.length - 1];
        Datasource data = new Datasource(0, name);
        data.setIdexperimentgroup(experiment);
        experiment.getDatasourceCollection().add(data);
        //Experimentgroup experiment = em.find(Experimentgroup.class , experimentId);
        em.persist(data);
        em.flush();
        em.getTransaction().commit();
        em.close();
//        String[] nameSplit = name.split(".");
//        String nameFull = "";
//        for(int i = 0; i < nameSplit.length ; i++) {
//            nameFull += nameSplit[i];
//        }
        File file = new File(path);
        File newFile = new File("C:\\experimentos\\" + experiment.getDescription() + "\\" + name + "\\" + name);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ExperimentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return experiment;
    }

    public void Editar(Experimentgroup experiment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Experimentgroup u = em.getReference(Experimentgroup.class, experiment.getIdexperimentgroup());
        u.setDescription(experiment.getDescription());
        u.setFecha(experiment.getFecha());
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void SetMejorResultado(Experimentgroup experiment, Dmresult result) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Experimentgroup u = em.getReference(Experimentgroup.class, experiment.getIdexperimentgroup());
        Dmresult res = em.getReference(Dmresult.class, result.getId());
        u.setResultseleccionado(res);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void Borrar(Experimentgroup experiment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Experimentgroup u = em.getReference(Experimentgroup.class, experiment.getIdexperimentgroup());
        em.remove(u);
        em.flush();
        em.getTransaction().commit();
        em.close();
        File newFile = new File("C:\\experimentos\\" + experiment.getDescription() + "\\");
        deleteDirectory(newFile);
    }

    public static boolean deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
        return (directory.delete());
    }
}
