package dto;

public class InformeDTO {

    private String nombreCarrera;
    private long cantidadInscriptos;
    private long cantidadGraduados;
    private int anio;

    public InformeDTO(String nombreCarrera, long cantidadInscriptos, long cantidadGraduados, int anio) {
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

    public long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public long getCantidadGraduados() {
        return cantidadGraduados;
    }

    public void setCantidadGraduados(long cantidadGraduados) {
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
