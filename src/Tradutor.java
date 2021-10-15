

public class Tradutor {

    public static Direcao getDirecao(char direcao){
        direcao = Character.toUpperCase(direcao);
        return switch (direcao) {
            case 'N' -> Direcao.N;
            case 'L' -> Direcao.L;
            case 'S' -> Direcao.S;
            case 'O' -> Direcao.O;
            default -> throw new IllegalArgumentException("Direção inválida");
        };
    }

    public static Comando getComandos(char comando){
        comando = Character.toUpperCase(comando);
        return switch (comando) {
            case 'L' -> Comando.L;
            case 'R' -> Comando.R;
            case 'M' -> Comando.M;
            default -> throw new IllegalArgumentException("Comando inválido");
        };
    }
}
