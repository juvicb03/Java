
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

//o programa foi escrito e compilado com a IDE NetBeans 12.6
/*as funçoes procuram o veiculo por um id passado pelo usuario,
  e se nao encontrado informa que o id é invalido e termina a funçao*/
public class Main {

    //função para escrever as opções do sistema
    private static void imprimirMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static void main(String[] args) {

        Veiculo[] v = new Veiculo[20];

        String[] menu = {"1- Inserir veículo", "2- Remover veículo", "3- Abastecer veículo", "4- Movimentar um veículo", "5- Movimentar por tipo de veículos",
            "6- Movimentar todos veículos", "7- Imprimir todos veículos", "8- Imprimir por tipo de veículo", "9- Calibrar um pneu", "10- Calibrar por tipo todos pneus",
            "11- Imprimir pista", "12 - Gravar em arquivo", "13 - Ler em arquivo", "14 - Sair da aplicação"};

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            imprimirMenu(menu);
            System.out.println("Escolha a opçao:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    inserirVeiculo(v);
                    break;
                case 2:
                    removerVeiculo(v);
                    break;
                case 3:
                    abastecerVeiculo(v);
                    break;
                case 4:
                    movimentarVeiculo(v);
                    break;
                case 5:
                    movimentarTipoVeiculo(v);
                    break;
                case 6:
                    movimentarTodosVeiculo(v);
                    break;
                case 7:
                    imprimirTodosVeiculo(v);
                    break;
                case 8:
                    imprimirTipoVeiculo(v);
                    break;
                case 9:
                    calibrarPneu(v);
                    break;
                case 10:
                    calibrarTipoPneu(v);
                    break;
                case 11:
                    imprimirPista(v);
                    break;
                case 12:
                    gravarArquivo(v);
                    break;
                case 13:
                    lerArquivo(v);
                    break;
                case 14:
                    break;
                default:
                    System.out.println("Opçao invalida");
            }
        } while (option != 14);

    }

    //funçao que inclui um veiculo de tipo escolhido no final da array v
    private static void inserirVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        char t;
        System.out.println("Tipo (B, M, P, E): ");
        t = scanner.next().charAt(0);
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }
        if (x < 20) {
            switch (t) {
                case 'M':
                    v[x] = new Moto(2);
                    break;
                case 'P':
                    v[x] = new Passeio(4);
                    break;
                case 'E':
                    v[x] = new Esportivo(4);
                    break;
                case 'B':
                    v[x] = new Bici(2);
                    break;
                default:
                    System.out.println("Impossivel incluir");
                    break;
            }

        } else {
            System.out.println("Impossivel incluir");
        }
    }

    //funçao que excluiu um veiculo de id escolhido e substituiu na array pelo ultimo, se necessario
    private static void removerVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int id, i = 0, x = 0;
        System.out.println("Qual id:");
        id = scanner.nextInt();
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }
        while (i < x) {
            if (id == v[i].getId()) {
                Veiculo.setCont();
                break;
            }
            i++;
        }
        if (i < x) {
            v[i] = v[x - 1];
            v[x - 1] = null;

        } else {
            System.out.println("Id nao existe");
        }
    }

    //funçao que abastece o combustivel de um determinado veiculo motor
    private static void abastecerVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int id, i, x = 0;
        double comb;
        System.out.println("Qual id: ");
        id = scanner.nextInt();
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }
        for (i = 0; i < x; i++) {
            if (id == v[i].getId()) {
                break;
            }
        }
        if (i < x) {
            if (v[i] instanceof VeiculoMotor) {
                System.out.println("Combustivel: ");
                comb = scanner.nextDouble();
                VeiculoMotor aux = (VeiculoMotor) v[i];
                aux.setComb(comb);
            } else {
                System.out.println("Nao abastece");
            }
        } else {
            System.out.println("Id nao existe");
        }
    }

    //funçao que calibra ou esvazia um pneu de um veiculo, ambos informados pelo usuario
    private static void calibrarPneu(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int id, i, x = 0, a;
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        do {
            System.out.println("Qual id: ");
            id = scanner.nextInt();
            for (i = 0; i < x; i++) {
                if (id == v[i].getId()) {
                    break;
                }
            }
        } while (i >= x);

        int calibrar;
        boolean b;
        do {
            System.out.println("1- Calibrar / 2- Esvaziar: ");
            calibrar = scanner.nextInt();
        } while (calibrar < 1 || calibrar > 2);

        b = calibrar == 1;
        x = v[i].getRodasLength();

        do {
            System.out.println("Qual roda: ");
            a = scanner.nextInt();
        } while (a < x || a > x);
        v[i].setRodas(a, b);
    }

    //funçao que calibra ou esvazia todos os pneus de um tipo de veiculo informado pelo usuario
    private static void calibrarTipoPneu(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int i, x = 0;
        char t;
        System.out.println("Tipo (B, M, P, E): ");
        t = scanner.next().charAt(0);
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        int calibrar;
        boolean b;
        do {
            System.out.println("1- Calibrar / 2- Esvaziar: ");
            calibrar = scanner.nextInt();
        } while (calibrar < 1 || calibrar > 2);

        b = calibrar == 1;

        for (i = 0; i < x; i++) {
            if (t == 'M') {
                if (v[i] instanceof Moto) {
                    v[i].setRodas(b);
                }
            } else if (t == 'P') {
                if (v[i] instanceof Passeio) {
                    v[i].setRodas(b);
                }
            } else if (t == 'E') {
                if (v[i] instanceof Esportivo) {
                    v[i].setRodas(b);
                }
            } else if (t == 'B') {
                if (v[i] instanceof Bici) {
                    v[i].setRodas(b);
                }
            } else {
                System.out.println("Tipo invalido");
                break;
            }
        }
    }

    //funçao que movimenta um determinado veiculo, se o mesmo estiver apto a se movimentar
    private static void movimentarVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int id, i, x = 0;
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        do {
            System.out.println("Qual id: ");
            id = scanner.nextInt();
            for (i = 0; i < x; i++) {
                if (id == v[i].getId()) {
                    break;
                }
            }
        } while (i >= x);

        v[i].mover();
    }

    //funçao que movimenta um tipo determinado de veiculo, se os mesmos estiverem apto a se movimentar
    private static void movimentarTipoVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int i, x = 0;
        char t;
        System.out.println("Tipo (B, M, P, E): ");
        t = scanner.next().charAt(0);
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        for (i = 0; i < x; i++) {
            if (t == 'M') {
                if (v[i] instanceof Moto) {
                    v[i].mover();
                }
            } else if (t == 'P') {
                if (v[i] instanceof Passeio) {
                    v[i].mover();
                }
            } else if (t == 'E') {
                if (v[i] instanceof Esportivo) {
                    v[i].mover();
                }
            } else if (t == 'B') {
                if (v[i] instanceof Bici) {
                    v[i].mover();
                }
            } else {
                System.out.println("Tipo invalido");
                break;
            }
        }
    }

    //funçao que movimenta todos os veiculos aptos que estao na array
    private static void movimentarTodosVeiculo(Veiculo[] v) {
        int i, x = 0;
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        for (i = 0; i < x; i++) {
            v[i].mover();
        }
    }

    //funçao que funciona com a toString para imprimir os dados de um tipo de veiculo
    private static void imprimirTipoVeiculo(Veiculo[] v) {
        Scanner scanner = new Scanner(System.in);
        int i, x = 0;
        char t;
        System.out.println("Tipo (B, M, P, E): ");
        t = scanner.next().charAt(0);
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        for (i = 0; i < x; i++) {
            if (t == 'M') {
                if (v[i] instanceof Moto) {
                    v[i].toString();
                }
            } else if (t == 'P') {
                if (v[i] instanceof Passeio) {
                    v[i].toString();
                }
            } else if (t == 'E') {
                if (v[i] instanceof Esportivo) {
                    v[i].toString();
                }
            } else if (t == 'B') {
                if (v[i] instanceof Bici) {
                    v[i].toString();
                }
            } else {
                System.out.println("Tipo invalido");
                break;
            }
        }
    }

    //funçao que imprime os dados de todos os veiculos
    private static void imprimirTodosVeiculo(Veiculo[] v) {
        int i, x = 0;
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }

        for (i = 0; i < x; i++) {
            System.out.println(v[i].toString());
        }
    }

    //funçao que imprime a pista com todos os veiculos e seus respectivos movimentos
    private static void imprimirPista(Veiculo[] v) {
        int i, x = 0;
        for (Veiculo aux : v) {
            if (aux != null) {
                x = Veiculo.getCont();
                break;
            }
            break;
        }
        for (i = 0; i < x; i++) {
            v[i].desenhar();
        }
    }

    //grava a array com os dados em um arquivo .txt
    private static void gravarArquivo(Veiculo[] v) {
        File arquivo = new File("arq.dat");
        try {
            try ( FileOutputStream fout = new FileOutputStream(arquivo)) {
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(v);
                oos.flush();
                oos.close();
            }
        } catch (IOException ex) {
            System.err.println("erro:" + ex.toString());
        }
    }

    //le de um arquivo .txt os dados e recorda no programa em uso
    private static void lerArquivo(Veiculo[] v) {
        File arquivo = new File("arq.dat");
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            int i = 0, maior = 0;
            Veiculo[] vArq = (Veiculo[]) oin.readObject();
            for (Veiculo aux : vArq) {
                if (aux != null) {
                    if (aux.getId() > maior) {
                        maior = aux.getId();
                    }
                    v[i] = aux;
                    i++;
                }
            }
            Veiculo.setCont(i);
            Veiculo.setContId(maior);
            oin.close();
            fin.close();

        } catch (IOException ex) {
            System.err.println("erro:" + ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
