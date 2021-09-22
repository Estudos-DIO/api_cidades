package controller;

import modelo.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositorio.RepositorioCidade;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private RepositorioCidade repositorioCidade;

    @GetMapping
    public Page<Cidade> obterTodasAsCidades(Pageable pagina ) {
        Page<Cidade> listaCidades = repositorioCidade.findAll( pagina );
        return listaCidades;
    }

}
