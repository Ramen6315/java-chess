package chess.domain.piece;

import chess.domain.move.CrossMove;
import chess.domain.move.Move;
import chess.domain.move.StraightMove;
import chess.domain.piece.position.Position;
import chess.domain.piece.team.TeamStrategy;

import java.util.List;

public class Queen extends Piece {
    public Queen(Position position, TeamStrategy teamStrategy) {
        super(position, teamStrategy);
    }

    @Override
    protected boolean isMovablePattern(Move move, Position targetPosition, List<Piece> pieces) {
        return move instanceof StraightMove || move instanceof CrossMove;
    }

    @Override
    public String getPieceName() {
        return teamStrategy.queenName();
    }
}
