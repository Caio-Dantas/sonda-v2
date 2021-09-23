public class TorreControle {
    private Planalto planalto;
    private Sonda sonda;

    public TorreControle(Posicao posicaoLimite){
        this.planalto = new Planalto(posicaoLimite);
    }

    public void posicionaSonda(Posicao posicao, Direcao direcao){
        this.sonda = new Sonda(posicao, direcao);
    }

    // TODO arrumar esse nome
    public void rotacionaSondaLeft(){
        this.sonda.rotateLeft();
    }

    public void rotacionaSondaRight(){
        this.sonda.rotateRight();
    }

    public void moveSonda(){
        this.sonda.move();
    }

}
