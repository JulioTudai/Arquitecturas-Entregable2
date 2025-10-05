package repositories;

import dto.EstudianteDTO;
import dto.InformeDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {

    void inscribirEstudiante(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad);
    List<EstudianteDTO> getByCarrera(Carrera carrera, String ciudad);
    List<InformeDTO> getInformes();

}
