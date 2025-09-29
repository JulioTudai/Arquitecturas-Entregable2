package repositories;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {

    void inscribirEstudiante(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad);
    List<EstudianteCarrera> getByCarrera(Carrera carrera, String ciudad);

}
