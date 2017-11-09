package kapka.thedrake.game;

public enum TroopFace {
    FRONT, BACK {
        @Override
        public TroopFace flipped() {
            return FRONT;
        }
    };

    public TroopFace flipped() {
        return BACK;
    }
}
