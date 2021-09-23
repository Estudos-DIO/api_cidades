package util;

public class LocalizacaoStringUtil {

    public static Double[] transformar( String geoLocalizacao ) {
        String resultado = geoLocalizacao.replace("(", "").replace(")", "");
        String[] strings = resultado.trim().split(",");
        return new Double[] { Double.valueOf(strings[0]), Double.valueOf(strings[1]) };
    }

}
