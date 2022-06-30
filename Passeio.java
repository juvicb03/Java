
public final class Passeio extends VeiculoMotor implements IPVA {

    private static final double GASTO = 0.75;

    //metodo construtor de um carro passeio
    public Passeio(int aux) {
        super(aux);
    }

    //funçoes necessarias para mover, desenhar e imprimir especifica de um passeio
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

        if (aux == true && super.getComb() >= Passeio.GASTO && super.getPago()) {
            super.setDeslocamento(5);
            super.setComb(-Passeio.GASTO);
        }
    }

    @Override
    public void desenhar() {
        String[] desenho = new String[4];
        String giro = "    ";
        desenho[0] = "    ____";
        desenho[1] = " __/  |_ \\_";
        desenho[2] = "|  _     _``-.";
        desenho[3] = "'-(_)---(_)--'\n";

        for (int a = 0; a < super.getDeslocamento(); a++) {
            desenho[0] = giro + desenho[0];
            desenho[1] = giro + desenho[1];
            desenho[2] = giro + desenho[2];
            desenho[3] = giro + desenho[3];

        }
        System.out.println(desenho[0]);
        System.out.println(desenho[1]);
        System.out.println(desenho[2]);
        System.out.println(desenho[3]);

    }

    @Override
    public double calcularIPVA() {
        return IPVA.VALOR_BASE * IPVA.ALIQUOTA_PASSEIO;
    }

    @Override
    public String toString() {
        boolean[] aux;
        aux = super.getCalibragens();
        return "Passeio{" + "id=" + super.getId() + ", IPVA=" + super.getPago() + ", valor=" + this.calcularIPVA()
                + ", desloc=" + super.getDeslocamento() + ", comb=" + super.getComb() + ", Rodas 1-" + aux[0] + " 2-" + aux[1] + " 3-" + aux[2] + " 4-" + aux[3] + "}";
    }

}
