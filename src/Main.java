import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Planalto marte = new Planalto(5,5);
        System.out.println(marte.existeSonda(0,0));
        marte.insereSonda(0,0);
        System.out.println(marte.existeSonda(0,0));


    }
}
