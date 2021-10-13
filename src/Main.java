import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x, y, sondaX, sondaY;
        char charDirecao;
        boolean acabou = false;
        Scanner scan = new Scanner(System.in);
        Printer.print("Digite as coordenadas do limite do planalto");
        x = scan.nextInt();
        y = scan.nextInt();
        Posicao posicaoLimite = new Posicao(x,y);
        TorreControle torreControle = new TorreControle(posicaoLimite);

        while (!acabou){
            Printer.print("Digite as coordenadas iniciais e a direção da sonda");
            sondaX = scan.nextInt();
            sondaY = scan.nextInt();
            Posicao posSonda = new Posicao(sondaX,sondaY);

            charDirecao = scan.next().charAt(0);
            Direcao direcao = Tradutor.getDirecao(charDirecao);

            torreControle.posicionaSonda(posSonda, direcao);

            Printer.print("Digite os comandos para sua sonda");

            String command = scan.next();
            command.chars().mapToObj(c -> (char) c).forEach(cmd -> {
                Comando comando = Tradutor.getComandos(cmd);
                torreControle.executaComando(comando);
            });

            Printer.print("Acabou? Y ou N");
            String res = scan.next();
            acabou = res.equals("Y") || res.equals("y");

        }
        torreControle.printPlanalto();
    }
}
