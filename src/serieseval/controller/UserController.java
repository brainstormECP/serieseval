/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.controller;

import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;
import serieseval.model.*;

/**
 *
 * @author Laura
 */
public class UserController {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "seriesevalPU" );   
    
    public void Create(String username, String nombres, String apellido1, String apellido2, String password, Role rolId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User usuario = new User(0, username, nombres, apellido1, apellido2,password, true);   
        
        usuario.setIdRole(rolId);        
        em.persist(usuario);        
        em.flush();
        em.getTransaction().commit();
        em.close();
    } 
    
    public void Editar(User usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = em.getReference(User.class, usuario.getIduser());
        
        u.setUsername(usuario.getUsername());
        u.setNombres(usuario.getNombres());
        u.setApellido1(usuario.getApellido1());
        u.setApellido2(usuario.getApellido2());
        u.setPassword(usuario.getPassword());
        u.setIdRole(usuario.getIdRole());        
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void Desactivar(User usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = em.getReference(User.class, usuario.getIduser());  
        if (u.getActivo()) {
            u.setActivo(false);
        }
        else{
            u.setActivo(true);
        }                 
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
