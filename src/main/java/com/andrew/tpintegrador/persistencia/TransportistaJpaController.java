/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrew.tpintegrador.persistencia;

import com.andrew.tpintegrador.modelo.Transportista;
import com.andrew.tpintegrador.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author andre
 */
public class TransportistaJpaController implements Serializable {

    public TransportistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
        public TransportistaJpaController(){
        emf = Persistence.createEntityManagerFactory("pruebaPU");
    }

    public void create(Transportista transportista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transportista transportista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transportista = em.merge(transportista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = transportista.getId();
                if (findTransportista(id) == null) {
                    throw new NonexistentEntityException("The transportista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transportista transportista;
            try {
                transportista = em.getReference(Transportista.class, id);
                transportista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportista with id " + id + " no longer exists.", enfe);
            }
            em.remove(transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transportista> findTransportistaEntities() {
        return findTransportistaEntities(true, -1, -1);
    }

    public List<Transportista> findTransportistaEntities(int maxResults, int firstResult) {
        return findTransportistaEntities(false, maxResults, firstResult);
    }

    private List<Transportista> findTransportistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transportista.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Transportista findTransportista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transportista.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transportista> rt = cq.from(Transportista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
