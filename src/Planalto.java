import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Planalto {

    private final Posicao posicaoLimite;
    Set<Posicao> posicoesOcupadas = new HashSet<>();
    Map<Posicao, Direcao> direcoesSondas = new HashMap<>();

    public Planalto(Posicao posicaoLimite){
        this.posicaoLimite = posicaoLimite;
    }

    public boolean posicaoValida(Posicao posicao){
        return estaNoPlanalto(posicao) && !existeSondaNaPosicao(posicao);
    }

    public boolean existeSondaNaPosicao(Posicao posicao){
        return this.posicoesOcupadas.contains(posicao);
    }

    public boolean estaNoPlanalto(Posicao posicao){
        boolean limiteSuperior = posicao.getX() <= this.posicaoLimite.getX()
                && posicao.getY() <= this.posicaoLimite.getY();
        boolean limiteInferior = posicao.getX() >= 0 && posicao.getY() >= 0;
        return limiteInferior && limiteSuperior;
    }

    public void insereSonda(Sonda sonda){
        this.posicoesOcupadas.add(sonda.getPosicaoAtual());
        this.direcoesSondas.put(sonda.getPosicaoAtual(), sonda.getDirecao());
    }

    public void removeSonda(Sonda sonda){
        this.posicoesOcupadas.remove(sonda.getPosicaoAtual());
        this.direcoesSondas.remove(sonda.getPosicaoAtual());
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        posicoesOcupadas.forEach(pos -> {
            response.append(pos.toString());
            response.append(direcoesSondas.get(pos).toString());
            response.append("\n");
        });
        return response.toString();
    }
}
