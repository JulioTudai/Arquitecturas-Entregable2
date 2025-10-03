package utils;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.csv.CSVRecord;
import repositories.*;

public class DBHelper {
    @PersistenceContext
    private EntityManager em;

    public DBHelper(EntityManager em){
        this.em = em;
    }


    public void fillEstudiante(){
        EstudianteRepository repo = new EstudianteRepositoryImpl(em);

        String ruta = "src/data/estudiantes.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            Estudiante e = new Estudiante(
                    Integer.parseInt(record.get("DNI")),
                    record.get("nombre"),
                    record.get("apellido"),
                    Integer.parseInt(record.get("edad")),
                    record.get("genero"),
                    record.get("ciudad"),
                    Integer.parseInt(record.get("LU"))
            );

            repo.saveEstudiante(e);
        }

        System.out.println("Estudiantes insertados.");
    }

    public void fillCarrera(){
        CarreraRepository repo = new CarreraRepositoryImpl(em);

        String ruta = "src/data/carreras.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            Carrera c = new Carrera(
                    Integer.parseInt(record.get("id_carrera")),
                    record.get("carrera"),
                    Integer.parseInt(record.get("duracion"))
            );

            repo.saveCarrera(c);
        }

        System.out.println("Carreras insertadas.");
    }

    public void fillEstudianteCarrera(){
        EstudianteCarreraRepository repo = new EstudianteCarreraRepositoryImpl(em);

        String ruta = "src/data/estudianteCarrera.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            EstudianteCarrera ec = new EstudianteCarrera(
                    Integer.parseInt(record.get("id")),
                    Integer.parseInt(record.get("id_estudiante")),
                    Integer.parseInt(record.get("id_carrera")),
                    Integer.parseInt(record.get("inscripcion")),
                    Integer.parseInt(record.get("graduacion")),
                    Integer.parseInt(record.get("antiguedad"))
            );

            repo.inscribirEstudiante(ec);


        }

        System.out.println("Inscripciones insertadas.");
    }



}
