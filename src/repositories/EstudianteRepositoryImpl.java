package repositories;

import entities.Estudiante;
import entities.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository{

    @PersistenceContext
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public Estudiante getEstudiantePorLU(int LU) {
        return em.find(Estudiante.class, LU);
    }

    @Override
    @Transactional
    public void saveEstudiante(Estudiante estudiante) {
        if (estudiante.getNombre() == null){
            em.persist(estudiante);
        }else {
            em.merge(estudiante);
        }
    }

    @Override
    @Transactional
    public void deleteEstudiante(int dni) {
        Estudiante estudiante = em.find(Estudiante.class, dni);
        if (estudiante != null) {
            em.remove(estudiante);
        }
    }

    @Override
    @Transactional
    public List<Estudiante> getEstudiantes() {
        return em.createQuery(
                        "SELECT e FROM Estudiante e ORDER BY e.apellido DESC",
                        Estudiante.class)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Estudiante> getEstudiantesGenero(String genero) {
        return em.createQuery(
                        "SELECT e FROM Estudiante e WHERE e.genero = :genero",
                        Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
    }

}
