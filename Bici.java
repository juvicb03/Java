
public class Bici extends Veiculo {

    //metodo construtor de uma bicicleta
    public Bici(int aux) {
        super(aux);
    }

    //funçoes necessarias para mover, desenhar e imprimir especifica de uma bicicleta
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

        if (aux == true) {
            super.setDeslocamento(2);
        }
    }

    @Override
    public void desenhar() {
        String[] desenho = new String[3];
        String giro = "    ";
        desenho[0] = "   __o";
        desenho[1] = " _`\\<,_";
        desenho[2] = "(*)/ (*)\n";

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
    public String toString() {
        boolean[] aux;
        aux = super.getCalibragens();
        return "Bicicleta{" + "id=" + super.getId() + ", desloc=" + super.getDeslocamento()
                + ", Rodas 1-" + aux[0] + " 2-" + aux[1] + "}";
    }

}
