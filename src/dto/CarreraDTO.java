package dto;

import java.util.ArrayList;
import java.util.List;

public class CarreraDTO {

    private int id;
    private String nombre;
    private String duracion;
    private List<String> estudianteCarrera; //todo : lista o de a un solo ? solo nombres?


    public CarreraDTO() {
    }

    public CarreraDTO(int id,String nombre, String duracion, List<String> estudianteCarrera) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudianteCarrera = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<String> getEstudianteCarrera() {
        return estudianteCarrera;
    }

    public void setEstudianteCarrera(List<String> estudianteCarrera) {
        this.estudianteCarrera = estudianteCarrera;
    }
}
