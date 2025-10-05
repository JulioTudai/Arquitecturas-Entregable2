package repositories;

import dto.EstudianteDTO;
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
    public EstudianteDTO getEstudiantePorLU(int LU) {
        TypedQuery<EstudianteDTO> query = em.createQuery(
                "SELECT new dto.EstudianteDTO(e.dni, e.nombre, e.apellido, e.genero, e.LU) " +
                        "FROM Estudiante e " +
                        "WHERE e.LU = :LU",
                EstudianteDTO.class
        ).setParameter("LU", LU);
        return query.getSingleResult();
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
    public List<EstudianteDTO> getEstudiantes() {
        return em.createQuery(
                "SELECT new dto.EstudianteDTO(e.dni, e.nombre, e.apellido, e.genero, e.LU) " +
                        "FROM Estudiante e " +
                        "ORDER BY e.apellido DESC",
                EstudianteDTO.class
        ).getResultList();
    }


    @Override
    @Transactional
    public List<EstudianteDTO> getEstudiantesGenero(String genero) {
        return em.createQuery(
                        "SELECT new dto.EstudianteDTO(e.dni, e.nombre, e.apellido, e.genero, e.LU)" +
                                " FROM Estudiante e"+
                                " WHERE e.genero = :genero",
                        EstudianteDTO.class)
                .setParameter("genero", genero)
                .getResultList();
    }

}
