
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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

        // Commit y cerrar EntityManager
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
