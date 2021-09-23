
public class Main {

    public static void main(String[] args) {

        Posicao posicaoLimite = new Posicao(5,5);
        TorreControle torreControle = new TorreControle(posicaoLimite);

        Posicao posicaoSonda1 = new Posicao(1,2);
        torreControle.posicionaSonda(posicaoSonda1, Direcao.N);
//        LMLMLMLMM
        torreControle.executaComando(Comando.L);
        torreControle.executaComando(Comando.M);
        torreControle.executaComando(Comando.L);
        torreControle.executaComando(Comando.M);
        torreControle.executaComando(Comando.L);
        torreControle.executaComando(Comando.M);
        torreControle.executaComando(Comando.L);
        torreControle.executaComando(Comando.M);
        torreControle.executaComando(Comando.M);

        Posicao posicaoEsperadaSonda1 = new Posicao(1,3);
//        System.out.println(torreControle.temNessaPosicao(posicaoEsperadaSonda1));
        torreControle.printPlanalto();
    }
}
