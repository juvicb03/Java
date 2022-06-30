
import java.io.Serializable;
import java.util.Random;

public class Roda implements Serializable{

    private boolean calibragem;

    //metodo construtor que gera a calbragem aleatoriamente
    public Roda() {
        Random x = new Random();
        int aux = x.nextInt(101);

        this.calibragem = (aux % 2 == 0);

    }

    //funçoes getter e setter necessarias
    public void setCalibragem(boolean aux) {
        this.calibragem = aux;
    }

    public boolean getCalibragem() {
        return this.calibragem;
    }

}
