package repositories;

import entities.Estudiante;

public interface EstudianteRepository {
    Estudiante getEstudiante(int dni);
    void saveEstudiante(Estudiante estudiante);
    void deleteEstudiante(int dni);
}
