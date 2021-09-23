package servico;

import modelo.Cidade;
import modelo.RaioTerra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import repositorio.RepositorioCidade;
import util.LocalizacaoStringUtil;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

@Service
public class ServicoDistancia {

    @Autowired
    private RepositorioCidade repositorioCidade;

    Logger log = LoggerFactory.getLogger( ServicoDistancia.class );

    /**
     * Calcular a distância entre duas cidades através de cálculos matemáticos.
     */
    public Double distanciaUtilizandoMatematica( final Long cidadeOrigem, final Long cidadeDestino, final RaioTerra unidade ) {
        log.info( "distanciaUtilizandoMatematica({}, {}, {}) ", cidadeOrigem, cidadeDestino, unidade);
        final List<Cidade> listaCidades = repositorioCidade.findAllById( (Arrays.asList( cidadeOrigem, cidadeDestino )) );

        final Double[] localizacaoUm = LocalizacaoStringUtil.transformar( listaCidades.get(0).getGeoLocalizacao() );
        final Double[] localizacaoDois = LocalizacaoStringUtil.transformar( listaCidades.get(1).getGeoLocalizacao() );

        return realizarCalculo(localizacaoUm[0], localizacaoUm[1], localizacaoDois[0], localizacaoDois[1], unidade);
    }

    private double realizarCalculo(final double lat1, final double lon1, final double lat2,
                                   final double lng2, final RaioTerra raioTerra ) {
        double lat = toRadians(lat2 - lat1);
        double lon = toRadians(lng2 - lon1);
        double a = sin(lat / 2) * sin(lat / 2) +
                cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return raioTerra.getValor() * c;
    }

    /**
     * Calcular a distância das cidades em milhas.
     */
    public Double distanciaDosPontosEmMilhas( final Long cidade1, final Long cidade2 ) {
        log.info( " nativePostgresInMiles({}, {}) ", cidade1, cidade2);
        return repositorioCidade.distanciaPorPontos(cidade1, cidade2);
    }

    /**
     * Calcular a distâncias entre os pontos.
     */
    public Double distanceUsingPoints( final Long cidade1, final Long cidade2, final RaioTerra unidade ) {
        log.info( " distanceUsingPoints({}, {}, {}) ", cidade1, cidade2, unidade);
        final List<Cidade> listaCidades = repositorioCidade.findAllById( (Arrays.asList(cidade1, cidade2)) );

        Point p1 = listaCidades.get(0).getLocalizacao();
        Point p2 = listaCidades.get(1).getLocalizacao();

        return realizarCalculo( p1.getX(), p1.getY(), p2.getX(), p2.getY(), unidade );
    }

    public Double distanciaDoCuboEmMetros(Long city1, Long city2) {
        log.info( " distanceByCubeInMeters({}, {}) ", city1, city2 );
        final List<Cidade> cities = repositorioCidade.findAllById( (Arrays.asList(city1, city2)) );

        Point p1 = cities.get(0).getLocalizacao();
        Point p2 = cities.get(1).getLocalizacao();

        return repositorioCidade.distanciaPorCubo(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

}
