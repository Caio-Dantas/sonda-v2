import java.util.HashSet;
import java.util.Set;

public class Planalto {

    private final Posicao posicaoLimite;
    Set<Posicao> posicoesOcupadas = new HashSet<>();

    public Planalto(Posicao posicaoLimite){
        this.posicaoLimite = posicaoLimite;
    }

    public boolean existeSonda(Posicao posicao){
        return this.posicoesOcupadas.contains(posicao);
    }

    public boolean estaNoPlanalto(Posicao posicao){
        boolean limiteSuperior = posicao.getX() <= this.posicaoLimite.getX()
                && posicao.getY() <= this.posicaoLimite.getY();
        boolean limiteInferior = posicao.getX() > 0 && posicao.getY() > 0;
        return limiteInferior && limiteSuperior;
    }

    public void insereSonda(Posicao posicao){
        this.posicoesOcupadas.add(posicao);
    }

    public void removeSonda(Posicao posicao){
        this.posicoesOcupadas.remove(posicao);
    }
}
