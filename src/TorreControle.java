public class TorreControle {
    private final Planalto planalto;
    private Sonda sonda;

    public TorreControle(Posicao posicaoLimite){
        this.planalto = new Planalto(posicaoLimite);
    }

    public void posicionaSonda(Posicao posicao, Direcao direcao){
        this.sonda = new Sonda(posicao, direcao);
        this.planalto.insereSonda(sonda);
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
