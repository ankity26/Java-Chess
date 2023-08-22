package com.chess.engine.board;
import com.chess.engine.piece.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
//chess tile class.
    protected final int tileCoordinate;

    private static final Map<Integer , EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer , EmptyTile> emptyTileMap = new HashMap<>();
        for(int i = 0; i < 64; i++){
            emptyTileMap.put(i , new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate , final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }


    public abstract boolean isTileOccupied();

    public abstract Piece isEmpty();

    public static final class EmptyTile extends Tile{

        EmptyTile(final int tileCoordinate){
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

        private Piece pieceOnTile;
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
