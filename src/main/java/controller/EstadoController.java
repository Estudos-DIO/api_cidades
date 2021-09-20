package controller;

import modelo.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositorio.RepositorioEstado;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private RepositorioEstado repositorioEstado;

    @GetMapping
    public List<Estado> obterTodosOsEstados() {
        List<Estado> listaEstados = new ArrayList<>();
        listaEstados = repositorioEstado.findAll();
        return listaEstados;
    }

}
