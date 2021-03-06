import java.util.HashMap;
import java.util.Map;

public class Planalto {

    private final Posicao posicaoLimite;
    Map<Posicao, Sonda> sondasPosicionadas = new HashMap<>();

    public Planalto(Posicao posicaoLimite){
        this.posicaoLimite = posicaoLimite;
    }

    public boolean estaNoPlanalto(Posicao posicao){
        boolean limiteSuperior = posicao.getX() <= this.posicaoLimite.getX()
                && posicao.getY() <= this.posicaoLimite.getY();
        boolean limiteInferior = posicao.getX() >= 0 && posicao.getY() >= 0;
        return limiteInferior && limiteSuperior;
    }

    public void insereSonda(Sonda sonda){
        if(!estaNoPlanalto(sonda.getPosicaoAtual())){
            Printer.print("Comunicação com a sonda perdida, além dos limites: " + sonda);
            sonda.desativa();
            return;
        }
        if(this.sondasPosicionadas.containsKey(sonda.getPosicaoAtual())) {
            Printer.print("Removendo sonda " + this.sondasPosicionadas.get(sonda.getPosicaoAtual()).toString());
            this.sondasPosicionadas.get(sonda.getPosicaoAtual()).desativa();
            removeSondaDaPosicao(sonda.getPosicaoAtual());
        }
        this.sondasPosicionadas.put(sonda.getPosicaoAtual(), sonda);
    }

    public void removeSondaDaPosicao(Posicao posicao){
        this.sondasPosicionadas.remove(posicao);
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        sondasPosicionadas.forEach((pos, sonda) -> {
            response.append(sonda.toString());
            response.append("\n");
        });
        return response.toString();
    }
}
