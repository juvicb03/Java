
public final class Esportivo extends VeiculoMotor implements IPVA {

    private static final double GASTO = 2.3;

    //metodo construtor deu um carro esportivo
    public Esportivo(int aux) {
        super(aux);
    }

    //funçoes necessarias para mover, desenhar e imprimir especifica de um esportivo
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

        if (aux == true && super.getComb() >= Esportivo.GASTO && super.getPago()) {
            super.setDeslocamento(10);
            super.setComb(-Esportivo.GASTO);
        }
    }

    @Override
    public void desenhar() {
        String[] desenho = new String[6];
        String giro = "    ";
        desenho[0] = "        __";
        desenho[1] = "      ~( @\\ \\";
        desenho[2] = "   _____]_[_/_>__";
        desenho[3] = "  / __ \\<> |  __ \\";
        desenho[4] = "=\\_/__\\_\\__|_/__\\_D";
        desenho[5] = "   (__)      (__)\n";

        for (int a = 0; a < super.getDeslocamento(); a++) {
            desenho[0] = giro + desenho[0];
            desenho[1] = giro + desenho[1];
            desenho[2] = giro + desenho[2];
            desenho[3] = giro + desenho[3];
            desenho[4] = giro + desenho[4];
            desenho[5] = giro + desenho[5];
        }
        System.out.println(desenho[0]);
        System.out.println(desenho[1]);
        System.out.println(desenho[2]);
        System.out.println(desenho[3]);
        System.out.println(desenho[4]);
        System.out.println(desenho[5]);
    }

    @Override
    public double calcularIPVA() {
        return IPVA.VALOR_BASE * IPVA.ALIQUOTA_ESPORTIVO;
    }

    @Override
    public String toString() {
        boolean[] aux;
        aux = super.getCalibragens();
        return "Esportivo{" + "id=" + super.getId() + ", IPVA=" + super.getPago() + ", valor=" + this.calcularIPVA()
                + ", desloc=" + super.getDeslocamento() + ", comb=" + super.getComb() + ", Rodas 1-" + aux[0] + " 2-" + aux[1] + " 3-" + aux[2] + " 4-" + aux[3] + "}";
    }

}
