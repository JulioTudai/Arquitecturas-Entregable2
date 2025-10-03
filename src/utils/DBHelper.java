package utils;

import entities.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.csv.CSVRecord;
import repositories.EstudianteRepository;
import repositories.EstudianteRepositoryImpl;

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

}
