package repositories;

import dto.EstudianteDTO;
import entities.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    EstudianteDTO getEstudiantePorLU(int LU);
    void saveEstudiante(Estudiante estudiante);
    void deleteEstudiante(int dni);
    List<EstudianteDTO> getEstudiantes();
    List<EstudianteDTO>getEstudiantesGenero(String genero);

}
