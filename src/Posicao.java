public class Posicao {

    private final int x;
    private final int y;

    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Posicao add(Posicao delta){
        int xFinal = this.x + delta.x;
        int yFinal = this.y + delta.y;
        return new Posicao(xFinal, yFinal);
    }
}
