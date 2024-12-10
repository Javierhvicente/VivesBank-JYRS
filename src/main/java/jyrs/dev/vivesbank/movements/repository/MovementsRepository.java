package jyrs.dev.vivesbank.movements.repository;

import jyrs.dev.vivesbank.movements.models.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interfaz para el repositorio de movimientos bancarios.
 * Proporciona los métodos necesarios para acceder y manipular los datos de movimientos en la base de datos MongoDB.
 * Se extiende de {@link MongoRepository} para aprovechar las funcionalidades CRUD estándar proporcionadas por Spring Data MongoDB.
 * @author Raul Fernandez, Yahya El Hadri, Javier Ruiz, Javier Hernandez, Samuel Cortes
 * @since 1.0
 */

@Repository
public interface MovementsRepository extends MongoRepository<Movement, String> {

    List<Movement> findBySenderClient(String clientId);

    List<Movement> findByRecipientClient(String clientId);

    List<Movement> findBySenderClientAndRecipientClient(String clientId, String clientId1);
}

