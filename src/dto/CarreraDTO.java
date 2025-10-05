package dto;

import java.util.ArrayList;
import java.util.List;

public class CarreraDTO {

    private int id;
    private String nombre;
    private long cantInscriptos;


    public CarreraDTO() {
    }

    public CarreraDTO(int id, String nombre, long cantInscriptos) {
        this.id = id;
        this.nombre = nombre;
        this.cantInscriptos = cantInscriptos;
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

    public long getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(long cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantInscriptos=" + cantInscriptos +
                '}';
    }
}
