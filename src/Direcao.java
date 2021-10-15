public enum Direcao {

    N{
        @Override
        public Posicao getDelta() {
            return new Posicao(0,1);
        }

        @Override
        public Direcao right() {
            return Direcao.L;
        }

        @Override
        public Direcao left() {
            return Direcao.O;
        }
    },
    L {
        @Override
        public Posicao getDelta() {
            return new Posicao(1,0);
        }

        @Override
        public Direcao right() {
            return Direcao.S;
        }

        @Override
        public Direcao left() {
            return Direcao.N;
        }
    },
    S{
        @Override
        public Posicao getDelta() {
            return new Posicao(0,-1);
        }

        @Override
        public Direcao right() {
            return Direcao.O;
        }

        @Override
        public Direcao left() {
            return Direcao.L;
        }
    },
    O{
        @Override
        public Posicao getDelta() {
            return new Posicao(-1,0);
        }

        @Override
        public Direcao right() {
            return Direcao.N;
        }

        @Override
        public Direcao left() {
            return Direcao.S;
        }
    };

    public abstract Posicao getDelta();
    public abstract Direcao right();
    public abstract Direcao left();
}
