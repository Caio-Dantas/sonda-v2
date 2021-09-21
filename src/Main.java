
public class Main {

    public static void main(String[] args) {
        Posicao pos1 = new Posicao(5,5);
        Posicao pos2 = new Posicao(0,0);
        Planalto marte = new Planalto(pos1);
        System.out.println(marte.existeSonda(pos2));
        marte.insereSonda(pos2);
        System.out.println(marte.existeSonda(pos2));


    }
}
