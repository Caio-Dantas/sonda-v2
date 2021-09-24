import java.util.HashMap;
import java.util.Map;

public class Planalto {

    private final Posicao posicaoLimite;
    Map<Posicao, Sonda> sondasPosicionadas = new HashMap<>();

    public Planalto(Posicao posicaoLimite){
        this.posicaoLimite = posicaoLimite;
    }

    public boolean posicaoValida(Posicao posicao){
        return estaNoPlanalto(posicao) && !existeSondaNaPosicao(posicao);
    }

    public boolean existeSondaNaPosicao(Posicao posicao){
        return this.sondasPosicionadas.containsKey(posicao);
    }

    public boolean estaNoPlanalto(Posicao posicao){
        boolean limiteSuperior = posicao.getX() <= this.posicaoLimite.getX()
                && posicao.getY() <= this.posicaoLimite.getY();
        boolean limiteInferior = posicao.getX() >= 0 && posicao.getY() >= 0;
        return limiteInferior && limiteSuperior;
    }

    public void insereSonda(Sonda sonda){
        this.sondasPosicionadas.put(sonda.getPosicaoAtual(), sonda);
    }

    public void removeSonda(Sonda sonda){
        this.sondasPosicionadas.remove(sonda.getPosicaoAtual());
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        sondasPosicionadas.forEach((pos, sonda) -> {
            response.append(pos.toString());
            response.append(sonda.getDirecao().toString());
            response.append("\n");
        });
        return response.toString();
    }
}
