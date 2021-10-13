import java.util.Objects;

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

    @Override
    public String toString() {
        return String.format("%d %d", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicao posicao = (Posicao) o;
        return this.x == posicao.x && this.y == posicao.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
