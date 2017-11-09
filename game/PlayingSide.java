package kapka.thedrake.game;

public enum PlayingSide {
    BLUE, ORANGE {
        @Override
        public PlayingSide opposite() {
            return BLUE;
        }
    };

    public PlayingSide opposite() {
        return ORANGE;
    }
}
