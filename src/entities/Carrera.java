package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {

    @Id
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private int duracion;

    @OneToMany(mappedBy = "id_carrera")
    private List<EstudianteCarrera>  estudianteCarrera;

    public Carrera() {}


    public Carrera(int id, String nombre, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudianteCarrera = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { //todo : preguntar si deberia estar
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<EstudianteCarrera> getEstudianteCarrera() {
        return estudianteCarrera;
    }

    public void setEstudianteCarrera(List<EstudianteCarrera> estudianteCarrera) {
        this.estudianteCarrera = estudianteCarrera;
    }
}
