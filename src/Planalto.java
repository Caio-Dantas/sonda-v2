public class Planalto {

    private final int[][] solo;

    public Planalto(int limiteHorizontal, int limiteVertical){
        this.solo = new int[limiteHorizontal][limiteVertical];
    }

    public boolean existeSonda(int posicaoX, int posicaoY){
        return this.solo[posicaoX][posicaoY] == 1;
    }

    public void insereSonda(int posicaoX, int posicaoY){
        this.solo[posicaoX][posicaoY] = 1;
    }
}
