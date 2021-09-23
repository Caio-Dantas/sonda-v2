import java.util.Optional;

public class Tradutor {

    public static Optional<Direcao> getDirecao(char direcao){
        direcao = Character.toUpperCase(direcao);
        return switch (direcao) {
            case 'N' -> Optional.of(Direcao.N);
            case 'E' -> Optional.of(Direcao.E);
            case 'S' -> Optional.of(Direcao.S);
            case 'O' -> Optional.of(Direcao.O);
            default -> Optional.empty();
        };
    }

    public static Optional<Comando> getComandos(char comando){
        comando = Character.toUpperCase(comando);
        return switch (comando) {
            case 'L' -> Optional.of(Comando.L);
            case 'R' -> Optional.of(Comando.R);
            case 'M' -> Optional.of(Comando.M);
            default -> Optional.empty();
        };
    }
}
