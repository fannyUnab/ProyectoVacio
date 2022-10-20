/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.p7.Controllers;

import com.api.p7.Controllers.exceptions.NonexistentEntityException;
import com.api.p7.Models.Comprarproducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author fannycc
 */
public class ComprarproductoJpaController implements Serializable {

    public ComprarproductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comprarproducto comprarproducto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comprarproducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comprarproducto comprarproducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comprarproducto = em.merge(comprarproducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comprarproducto.getId();
                if (findComprarproducto(id) == null) {
                    throw new NonexistentEntityException("The comprarproducto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comprarproducto comprarproducto;
            try {
                comprarproducto = em.getReference(Comprarproducto.class, id);
                comprarproducto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comprarproducto with id " + id + " no longer exists.", enfe);
            }
            em.remove(comprarproducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comprarproducto> findComprarproductoEntities() {
        return findComprarproductoEntities(true, -1, -1);
    }

    public List<Comprarproducto> findComprarproductoEntities(int maxResults, int firstResult) {
        return findComprarproductoEntities(false, maxResults, firstResult);
    }

    private List<Comprarproducto> findComprarproductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comprarproducto.class));
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

    public Comprarproducto findComprarproducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comprarproducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprarproductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comprarproducto> rt = cq.from(Comprarproducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
