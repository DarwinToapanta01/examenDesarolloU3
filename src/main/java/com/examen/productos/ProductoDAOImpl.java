package com.examen.productos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductoDAOImpl implements IProductoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("productosPU");

    @Override
    public void insertar(Producto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
