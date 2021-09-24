import java.util.Optional;

public class TorreControle {
    private final Planalto planalto;
    private Sonda sonda;

    public TorreControle(Posicao posicaoLimite){
        this.planalto = new Planalto(posicaoLimite);
    }

    public Optional<Posicao> posicionaSonda(Posicao posicao, Direcao direcao){
        if(!this.planalto.posicaoValida(posicao)) return Optional.empty();

        this.sonda = new Sonda(posicao, direcao);
        this.planalto.insereSonda(sonda);
        return Optional.of(posicao);
    }

    public void executaComando(Comando comando){
        comando.executa(this);
    }
    
    public void printPlanalto(){
        System.out.println(planalto.toString());
    }

    public void rotacionaSondaLeft(){
        this.sonda.rotateLeft();
    }

    public void rotacionaSondaRight(){
        this.sonda.rotateRight();
    }

    public void moveSonda(){
        if(this.planalto.posicaoValida(sonda.getPosicaoFutura())){
            this.planalto.removeSonda(this.sonda);
            this.sonda.move();
            this.planalto.insereSonda(this.sonda);
        }
    }

}
