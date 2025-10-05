package repositories;

import dto.CarreraDTO;
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
    public List<CarreraDTO> getCarrerasConInscriptos() {
        return em.createQuery(
                "SELECT new dto.CarreraDTO(c.id, c.nombre, COUNT(ec)) " +
                        "FROM Carrera c " +
                        "JOIN c.estudianteCarrera ec " +
                        "GROUP BY c.id, c.nombre " +
                        "ORDER BY COUNT(ec) DESC",
                CarreraDTO.class
        ).getResultList();
    }



    @Transactional
    public void saveCarrera(Carrera carrera) {
       this.em.merge(carrera);
    }

}
