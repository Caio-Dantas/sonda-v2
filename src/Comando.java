public enum Comando {

    L{
        @Override
        public void executa(TorreControle torreControle) {
            torreControle.rotacionaSondaLeft();
        }
    },
    R{
        @Override
        public void executa(TorreControle torreControle) {
            torreControle.rotacionaSondaRight();
        }
    },
    M{
        @Override
        public void executa(TorreControle torreControle) {
            torreControle.moveSonda();
        }
    };

    public abstract void executa(TorreControle torreControle);
}
