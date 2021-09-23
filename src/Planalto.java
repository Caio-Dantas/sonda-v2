public class Planalto {

    private final int[][] solo;

    public Planalto(Posicao posicaoLimite){
        this.solo = new int[posicaoLimite.getX()][posicaoLimite.getY()];
    }

    public boolean existeSonda(Posicao posicao){
        return this.solo[posicao.getX()][posicao.getY()] == 1;
    }

    public boolean estaNoPlanalto(Posicao posicao){
        boolean limiteSuperior = posicao.getX() < solo.length && posicao.getY() < solo[0].length;
        boolean limiteInferior = posicao.getX() > 0 && posicao.getY() > 0;
        return limiteInferior && limiteSuperior;
    }

    public void insereSonda(Posicao posicao){
        this.solo[posicao.getX()][posicao.getY()] = 1;
    }

    public void removeSonda(Posicao posicao){
        this.solo[posicao.getX()][posicao.getY()] = 0;
    }
}
