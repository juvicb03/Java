
public final class Moto extends VeiculoMotor implements IPVA {

    private static final double GASTO = 0.25;

    //metodo construtor de uma moto
    public Moto(int aux) {
        super(aux);
    }

    //funçoes necessarias para mover, desenhar e imprimir especifica de uma moto
    @Override
    public void mover() {
        boolean[] b;
        boolean aux = true;
        b = super.getCalibragens();

        for (int i = 0; i < super.getRodasLength(); i++) {
            if (b[i] == false) {
                aux = false;
                break;
            }
        }

        if (aux == true && super.getComb() >= Moto.GASTO && super.getPago()) {
            super.setDeslocamento(3);
            super.setComb(-Moto.GASTO);
        }
    }

    @Override
    public void desenhar() {
        String[] desenho = new String[3];
        String giro = "    ";
        desenho[0] = "   ,_oo";
        desenho[1] = ".-/c-//::";
        desenho[2] = "(_)'==(_)\n";

        for (int a = 0; a < super.getDeslocamento(); a++) {
            desenho[0] = giro + desenho[0];
            desenho[1] = giro + desenho[1];
            desenho[2] = giro + desenho[2];
        }
        System.out.println(desenho[0]);
        System.out.println(desenho[1]);
        System.out.println(desenho[2]);
    }

    @Override
    public double calcularIPVA() {
        return IPVA.VALOR_BASE * IPVA.ALIQUOTA_MOTO;
    }

    @Override
    public String toString() {
        boolean[] aux;
        aux = super.getCalibragens();
        return "Moto{" + "id=" + super.getId() + ", IPVA=" + super.getPago() + ", valor=" + this.calcularIPVA()
                + ", desloc=" + super.getDeslocamento() + ", comb=" + super.getComb() + ", Rodas 1-" + aux[0] + " 2-" + aux[1] + "}";
    }

}
