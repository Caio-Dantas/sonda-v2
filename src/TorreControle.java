public class TorreControle {
    private Planalto planalto;
    private Sonda sonda;

    public TorreControle(Posicao posicaoLimite){
        this.planalto = new Planalto(posicaoLimite);
    }

    public void posicionaSonda(Posicao posicao, Direcao direcao){
        this.sonda = new Sonda(posicao, direcao);
        this.planalto.insereSonda(posicao);
    }

    public void executaComando(Comando comando){
        comando.executa(this);
    }

    public boolean temNessaPosicao(Posicao posicao){
        return planalto.existeSonda(posicao);
    }

    // TODO arrumar esse nome
    public void rotacionaSondaLeft(){
        this.sonda.rotateLeft();
    }

    public void rotacionaSondaRight(){
        this.sonda.rotateRight();
    }

    public void moveSonda(){
        this.planalto.removeSonda(this.sonda.getPosicaoAtual());
        this.sonda.move();
        this.planalto.insereSonda(this.sonda.getPosicaoAtual());
    }

}
