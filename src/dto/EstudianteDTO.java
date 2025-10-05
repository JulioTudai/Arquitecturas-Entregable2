package dto;

import jakarta.persistence.Column;

public class EstudianteDTO {
    private int dni;
    private String nombre;
    private String apellido;
    private String genero;
    private int LU;

    public EstudianteDTO() {}

    public EstudianteDTO(int dni, String nombre, String apellido, String genero, int LU) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.LU = LU;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getLU() {
        return LU;
    }

    public void setLU(int LU) {
        this.LU = LU;
    }
}
