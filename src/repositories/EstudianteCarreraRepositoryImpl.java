package repositories;

import dto.EstudianteDTO;
import dto.InformeDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
    @PersistenceContext
    private EntityManager em;

    public EstudianteCarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void inscribirEstudiante(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad) {
        EstudianteCarrera EC = new EstudianteCarrera(estudiante,carrera,inscripcion,graduacion,antiguedad);
        em.persist(EC);
    }

    @Override
    public List<EstudianteDTO> getByCarrera(Carrera carrera, String ciudad) {
        TypedQuery<EstudianteDTO> query = em.createQuery(
                "SELECT new dto.EstudianteDTO(e.dni, e.nombre, e.apellido, e.genero, e.LU) " +
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.estudiante e " +
                        "WHERE ec.carrera = :carrera " +
                        "AND e.ciudad = :ciudad",
                EstudianteDTO.class
        );

        query.setParameter("carrera", carrera);
        query.setParameter("ciudad", ciudad);

        return query.getResultList();
    }

    public List<InformeDTO> getInformes() {
        return em.createQuery(
                "SELECT new dto.InformeDTO(" +
                        "   c.nombre, " +
                        "   COUNT(ec.id), " +
                        "   SUM(CASE WHEN ec.graduacion IS NOT NULL AND ec.graduacion <> 0 THEN 1 ELSE 0 END), " +
                        "   ec.inscripcion" +
                        ") " +
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.carrera c " +
                        "GROUP BY c.nombre, ec.inscripcion " +
                        "ORDER BY c.nombre ASC, ec.inscripcion ASC",
                InformeDTO.class
        ).getResultList();

    }

}
