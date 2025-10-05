package repositories;

import dto.CarreraDTO;
import entities.Carrera;

import java.util.List;

public interface CarreraRepository {
    List<CarreraDTO> getCarrerasConInscriptos();
    void saveCarrera(Carrera carrera);
}
