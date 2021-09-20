package controller;

import modelo.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositorio.RepositorioPais;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private RepositorioPais repositorioPais;

//    @GetMapping
//    public List<Pais> obterTodosOsPaises() {
//        List<Pais> listaPaises = new ArrayList<>();
//        listaPaises = repositorioPais.findAll();
//        return listaPaises;
//    }

    @GetMapping
    public Page<Pais> obterTodosOsPaisesComPaginacao( Pageable pagina ) {
        return repositorioPais.findAll( pagina );
    }

    @GetMapping("/{id}")
    public ResponseEntity obterPais( @PathVariable("id") Long id ) {
        Optional<Pais> pais = repositorioPais.findById( id );

        if( pais.isPresent() ) {
            return ResponseEntity.ok().body( pais.get() );
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
