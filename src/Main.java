
import entities.Carrera;
import entities.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repositories.*;
import utils.DBHelper;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Crear el EntityManagerFactory y el EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        // Comenzar la transacción
        em.getTransaction().begin();

        DBHelper helper = new DBHelper(em);
        helper.fillEstudiante();
        helper.fillCarrera();
        helper.fillEstudianteCarrera();


        System.out.println();
        System.out.println("recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple");
        EstudianteRepository estudianteRepository = new EstudianteRepositoryImpl(em);
        estudianteRepository.getEstudiantes().forEach(System.out::println);

        System.out.println();
        System.out.println("recuperar un estudiante, en base a su número de libreta universitaria");
        System.out.println(estudianteRepository.getEstudiantePorLU(34978));

        System.out.println();
        System.out.println("recuperar todos los estudiantes, en base a su género");
        estudianteRepository.getEstudiantesGenero("Male").forEach(System.out::println);

        System.out.println();
        System.out.println("recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.");
        CarreraRepository carreraRepository = new CarreraRepositoryImpl(em);
        carreraRepository.getCarrerasConInscriptos().forEach(System.out::println);

        System.out.println();
        System.out.println("recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia");
        EstudianteCarreraRepository estudianteCarreraRepository = new EstudianteCarreraRepositoryImpl(em);
        Carrera carrera = em.find(Carrera.class, 1);
        estudianteCarreraRepository.getByCarrera(carrera, "Paquera").forEach(System.out::println);

        System.out.println();
        System.out.println("Generar un reporte de las carreras, que para cada carrera incluya información de los\n" +
                "inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\n" +
                "los años de manera cronológica");
        estudianteCarreraRepository.getInformes().forEach(System.out::println);


        // Commit y cerrar EntityManager
        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}
