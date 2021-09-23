package controller;

import modelo.RaioTerra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servico.ServicoDistancia;

@RestController
@RequestMapping("/distancias")
public class DistanciaController {

    @Autowired
    private ServicoDistancia servicoDistancia;

    Logger log = LoggerFactory.getLogger( DistanciaController.class );

    @GetMapping("/porPontos")
    public Double porPontos( @RequestParam(name = "de") final Long cidade1,
                             @RequestParam(name = "para") final Long cidade2 ) {
        log.info( "-> porPontos: " );
        return servicoDistancia.distanciaDosPontosEmMilhas( cidade1, cidade2 );
    }

    @GetMapping("/porCubo")
    public Double porCubo( @RequestParam(name = "de") final Long cidade1,
                           @RequestParam(name = "para") final Long cidade2 ) {
        log.info( "-> porCubo: " );
        return servicoDistancia.distanciaDoCuboEmMetros( cidade1, cidade2 );
    }

    @GetMapping("/porMatematica")
    public Double porMatematica( @RequestParam(name = "de") final Long cidade1,
                                 @RequestParam(name = "para") final Long cidade2,
                                 @RequestParam final RaioTerra unidade ) {
        log.info("-> porMatemática: ");
        return servicoDistancia.distanciaUtilizandoMatematica( cidade1, cidade2, unidade );
    }

}
