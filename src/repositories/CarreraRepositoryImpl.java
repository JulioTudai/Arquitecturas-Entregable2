package repositories;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository{

    @PersistenceContext
    private EntityManager em;


    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional
    public List<Carrera> getCarrerasConInscriptos() {

        return em.createQuery("SELECT c, COUNT(ec)" +
                "FROM Carrera c" +
                "JOIN c.estudianteCarrera ec" +
                "GROUP BY c" +
                "ORDER BY COUNT(ec) DESC", Carrera.class)
                .getResultList();
    }


    @Transactional
    public void saveCarrera(Carrera carrera) {
       this.em.persist(carrera);
    }

}
