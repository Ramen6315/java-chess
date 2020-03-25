package chess.domain.chessPiece;

import chess.domain.Position;
import chess.domain.chessPiece.team.TeamStrategy;

public class King extends Piece {

    public King(Position position, TeamStrategy teamStrategy) {
        super(position, teamStrategy);
    }

    @Override
    public boolean isMovable(Position target, Piece targetPiece) {
        validSameTeam(targetPiece);
        return Math.abs(position.calculateFileDistance(target)) <= 1
                && Math.abs(position.calculateRankDistance(target)) <= 1;
    }

    @Override
    public String pieceName() {
        return teamStrategy.kingName();
    }
}
