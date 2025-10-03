package dto;

public class InformeDTO {

    private String nombreCarrera;
    private int cantidadInscriptos;
    private int cantidadGraduados;
    private int anio;

    public InformeDTO(String nombreCarrera, int cantidadInscriptos, int cantidadGraduados, int anio){
        this.nombreCarrera = nombreCarrera;
        this.cantidadInscriptos = cantidadInscriptos;
        this.cantidadGraduados = cantidadGraduados;
        this.anio = anio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int getCantidadGraduados() {
        return cantidadGraduados;
    }

    public void setCantidadGraduados(int cantidadGraduados) {
        this.cantidadGraduados = cantidadGraduados;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "InformeDTO{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", cantidadInscriptos=" + cantidadInscriptos +
                ", cantidadGraduados=" + cantidadGraduados +
                ", anio=" + anio +
                '}';
    }
}
