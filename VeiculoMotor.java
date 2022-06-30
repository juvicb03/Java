
import java.util.Random;

public abstract class VeiculoMotor extends Veiculo {

    private double comb;
    private final boolean pago;

    
     /*metodo construtor que determina todas as variaveis de um veiculo motor*/
    public VeiculoMotor(int aux) {
        super(aux);
        this.comb = 3.5;

        Random num = new Random();
        int x = num.nextInt(101);
        this.pago = (x % 2 == 0);
    }

    //funçoes getters e setters necessarias para o um veiculo
    public double getComb() {
        return this.comb;
    }

    public void setComb(double aux) {
        this.comb = this.comb + aux;
    }

    public boolean getPago() {
        return this.pago;
    }

    @Override
    public abstract void mover();

    @Override
    public abstract void desenhar();

    @Override
    public abstract String toString();
    
    public abstract double calcularIPVA();

}
