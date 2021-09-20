package repositorio;

import modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPais extends JpaRepository<Pais, Long> {

}
