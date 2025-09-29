package repositories;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
    @PersistenceContext
    private EntityManager em;

    public EstudianteCarreraRepositoryImpl(EntityManager em) {
    }

    @Transactional
    @Override
    public void inscribirEstudiante(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad) {
        EstudianteCarrera EC = new EstudianteCarrera(estudiante,carrera,inscripcion,graduacion,antiguedad);
        em.persist(EC);
    }

    @Override
    public List<EstudianteCarrera> getByCarrera(Carrera carrera, String ciudad) {
        TypedQuery<EstudianteCarrera> query = em.createQuery(
                "SELECT ec " +
                        "FROM EstudianteCarrera ec " +
                        "WHERE ec.carrera = :carrera " +
                        "AND ec.estudiante.id IN (" +
                        "SELECT e.id " +
                        "FROM Estudiante e " +
                        "WHERE e.ciudad = :ciudad)", EstudianteCarrera.class);

        query.setParameter("carrera", carrera);
        query.setParameter("ciudad", ciudad);

        return query.getResultList();
    }

}
