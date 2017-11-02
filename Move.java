package kapka.thedrake;

public abstract class Move {

    private final GameState initialState;
    private final TilePosition target;

    public Move(GameState initialState, TilePosition target) {
        this.initialState = initialState;
        this.target = target;
    }

    public GameState initialState() {
        return initialState;
    }

    public TilePosition target() {
        return target;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getClass().hashCode();
        result = prime * result + ((initialState == null) ? 0 : initialState.hashCode());
        result = prime * result + ((target == null) ? 0 : target.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Move other = (Move) obj;
        if (!(initialState == other.initialState)) {
            return false;
        }
        if (target == null) {
            if (other.target != null) {
                return false;
            }
        } else if (!target.equals(other.target)) {
            return false;
        }
        return true;
    }

    public abstract GameState resultState();

    public abstract boolean isWinning();
}
