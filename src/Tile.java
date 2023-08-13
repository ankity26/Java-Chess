public abstract class Tile {
//chess tile class.
    int tileCoordinate;
    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece isEmpty();

    public static final class EmptyTile extends Tile{

        EmptyTile(int tileCoordinate){
            super(tileCoordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece isEmpty() {
            return null;
        }
    }

    public static final class OccupiedTile extends Tile{

        Piece pieceOnTile;
        OccupiedTile(int tileCoordinate , Piece piece){
            super(tileCoordinate);
            this.pieceOnTile = piece;
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece isEmpty() {
            return null;
        }

        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
