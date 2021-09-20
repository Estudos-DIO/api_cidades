package modelo;

/**
 * Enumerador para representar o raio da Terra.
 */
public enum RaioTerra {

    METROS( "m",  6378168 ),
    QUILOMETROS( "km", 6378.168f ),
    MILHAS( "mi", 3958.747716f );

    private final String unidade;
    private final float valor;

    RaioTerra( final String unidade, final float valor ) {
        this.unidade = unidade;
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public float getValor() {
        return valor;
    }
}
