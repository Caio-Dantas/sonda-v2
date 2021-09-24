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
            Optional<Direcao> optionalDirecao = Tradutor.getDirecao(charDirecao);

            if(optionalDirecao.isEmpty()){
                Printer.print("Digite uma direção correta");
                continue;
            }

            Direcao direcao = optionalDirecao.get();

            Optional<Posicao> optionalPosicao = torreControle.posicionaSonda(posSonda, direcao);

            if(optionalPosicao.isEmpty()){
                Printer.print("Posição inválida");
                continue;
            }else{
                Printer.print("Sonda posicionada");
            }

            Printer.print("Digite os comandos para sua sonda");

            String command = scan.next();
            command.chars().mapToObj(c -> (char) c).forEach(cmd -> {
                Optional<Comando> optionalComando = Tradutor.getComandos(cmd);
                optionalComando.ifPresent(torreControle::executaComando);
            });

            Printer.print("Acabou? Y ou N");
            String res = scan.next();
            acabou = res.equals("Y") || res.equals("y");

        }
        torreControle.printPlanalto();
    }
}
