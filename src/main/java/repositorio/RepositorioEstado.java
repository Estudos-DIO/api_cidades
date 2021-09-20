package repositorio;

import modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstado extends JpaRepository<Estado, Long> {

}
