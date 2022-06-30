
public interface IPVA {

    //constantes e funçao abstrata de IPVA
    public static final double VALOR_BASE = 500, ALIQUOTA_MOTO = 0.75, ALIQUOTA_PASSEIO = 1.3, ALIQUOTA_ESPORTIVO = 3.15;
    
    public double calcularIPVA();

}
