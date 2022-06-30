
import java.io.Serializable;


public abstract class Veiculo implements Serializable {

    private int deslocamento = 0;
    private static int cont = 0, contId = 0;
    private final int id;
    private Roda[] rodas;

    /*metodo construtor que incrementa o contador e o id da classe veiculo,
     e determina todas as variaveis de um veiculo*/
    public Veiculo(int aux) {
        this.id = Veiculo.contId + 1;
        Veiculo.cont++;
        Veiculo.contId++;
        
        rodas=new Roda[aux];

        for (int i = 0; i < aux; i++) {
            this.rodas[i] = new Roda();
        }
    }

    //funçoes getters e setters necessarias para o um veiculo
    public boolean[] getCalibragens() {
        boolean[] aux = new boolean[this.rodas.length];
        for (int i = 0; i < this.rodas.length; i++) {
            aux[i] = this.rodas[i].getCalibragem();
        }
        return aux;
    }

    public void setRodas(boolean t) {
        for (int i = 0; i < rodas.length; i++) {
            this.rodas[i].setCalibragem(t);
        }
    }
    
    public int getRodasLength() {
        return this.rodas.length;
    }

    public void setRodas(int aux, boolean t) {
        this.rodas[aux].setCalibragem(t);
    }

    public int getId() {
        return this.id;
    }

    public int getDeslocamento() {
        return this.deslocamento;
    }

    public void setDeslocamento(int aux) {
        this.deslocamento = this.deslocamento + aux;
    }

    public static int getCont() {
        return Veiculo.cont;
    }

    public static void setCont() {
        Veiculo.cont = Veiculo.cont - 1;
    }

    public static void setCont(int aux) {
        Veiculo.cont = aux;
    }

    public static void setContId(int aux) {
        Veiculo.contId = aux;
    }

    public abstract void mover();

    public abstract void desenhar();

    @Override
    public abstract String toString();

}
