package repositories;

import entities.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class EstudianteRepositoryImpl implements EstudianteRepository{

    @PersistenceContext
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
    }

    public Estudiante getEstudiante(int dni) {
        return em.find(Estudiante.class, dni);
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
}
