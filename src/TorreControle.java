public class TorreControle {
    private final Planalto planalto;
    private Sonda sonda;

    public TorreControle(Posicao posicaoLimite){
        this.planalto = new Planalto(posicaoLimite);
    }

    public void posicionaSonda(Posicao posicao, Direcao direcao){
        if(!this.planalto.estaNoPlanalto(posicao)) throw new IllegalArgumentException("Posição inválida");

        this.sonda = new Sonda(posicao, direcao);
        this.planalto.insereSonda(sonda);
    }

    public void executaComando(Comando comando){
        switch (comando){
            case L -> this.rotacionaSondaLeft();
            case R -> this.rotacionaSondaRight();
            case M -> this.moveSonda();
        }
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
        if(sonda.estaAtiva()){
            this.planalto.removeSondaDaPosicao(this.sonda.getPosicaoAtual());
            this.sonda.move();
            this.planalto.insereSonda(this.sonda);
        }
    }

}
