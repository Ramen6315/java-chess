package chess.domain.chessPiece.piece;

import chess.domain.Position;
import chess.domain.chessPiece.team.TeamStrategy;
import chess.domain.movefactory.MoveType;
import chess.domain.movefactory.StraightType;

public class Rook extends Piece {
    private final double score = 5;
    public Rook(Position position, TeamStrategy teamStrategy) {
        super(position, teamStrategy);
    }

    @Override
    public boolean isMovable(MoveType moveType) {
        return moveType instanceof StraightType;
    }

    @Override
    public String pieceName() {
        return teamStrategy.rookName();
    }

    @Override
    public double getScore() {
        return score;
    }
}
