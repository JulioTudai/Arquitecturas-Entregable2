package repositories;

import entities.Carrera;

import java.util.List;

public interface CarreraRepository {
    List<Carrera> getCarrerasConInscriptos();

}
