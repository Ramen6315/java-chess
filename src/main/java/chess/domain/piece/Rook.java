package chess.domain.piece;

import chess.domain.Position;
import chess.domain.move.MoveType;
import chess.domain.move.StraightType;
import chess.domain.team.TeamStrategy;

public class Rook extends Piece {
    private final double ROOK_SCORE = 5.0;

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
        return ROOK_SCORE;
    }
}
