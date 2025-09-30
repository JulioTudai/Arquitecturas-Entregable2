package repositories;

import entities.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    Estudiante getEstudiantePorLU(int LU);
    void saveEstudiante(Estudiante estudiante);
    void deleteEstudiante(int dni);
    List<Estudiante> getEstudiantes();
    List<Estudiante>getEstudiantesGenero(String genero);

}
