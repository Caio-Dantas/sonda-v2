public class Planalto {

    private final int[][] solo;

    public Planalto(Posicao posicao){
        this.solo = new int[posicao.getX()][posicao.getY()];
    }

    public boolean existeSonda(Posicao posicao){
        return this.solo[posicao.getX()][posicao.getY()] == 1;
    }

    public void insereSonda(Posicao posicao){
        this.solo[posicao.getX()][posicao.getY()] = 1;
    }

    public void removeSonda(Posicao posicao){
        this.solo[posicao.getX()][posicao.getY()] = 0;
    }
}
