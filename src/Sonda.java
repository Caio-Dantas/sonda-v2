public class Sonda {

    private Posicao posicaoAtual;
    private Direcao direcao;

    public Sonda(Posicao posicaoInicial, Direcao direcaoInicial){
        this.posicaoAtual = posicaoInicial;
        this.direcao = direcaoInicial;
    }

    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    public void rotateLeft(){
        this.direcao = direcao.left();
    }

    public void rotateRight(){
        this.direcao = direcao.right();
    }

    public void move(){
        this.posicaoAtual = getPosicaoFutura();
    }

    public Posicao getPosicaoFutura(){
        return posicaoAtual.add(direcao.getDelta());
    }

    @Override
    public String toString() {
        return posicaoAtual + " " + direcao;
    }
}
