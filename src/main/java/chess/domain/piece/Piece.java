package chess.domain.piece;

import chess.domain.move.Move;
import chess.domain.piece.position.Position;
import chess.domain.piece.team.TeamStrategy;

import java.util.Optional;

public abstract class Piece implements PieceAbility {
    public static final String ERROR_MESSAGE_NOT_MOVABLE = "해당 말이 갈 수 없는 칸입니다";

    protected final String name;
    protected final TeamStrategy teamStrategy;
    protected Position position;

    public Piece(Position position, TeamStrategy teamStrategy) {
        this.position = position;
        this.teamStrategy = teamStrategy;
        this.name = this.getPieceName();
    }

    @Override
    public void validateMovePattern(Move move, Optional<Piece> targetPiece) {
        if (isMovablePattern(move, targetPiece)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MOVABLE);
    }

    protected abstract boolean isMovablePattern(Move move, Optional<Piece> targetPiece);

    @Override
    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean isBlackTeam() {
        return teamStrategy.isBlackTeam();
    }

    @Override
    public void move(Position position) {
        this.position = position;
    }

    @Override
    public boolean isNotKnight() {
        return !(this instanceof Knight);
    }

    public boolean isSameTeam(Piece targetPiece) {
        return teamStrategy.isSameTeam(targetPiece.teamStrategy);
    }

    public Position getPosition() {
        return position;
    }

    public TeamStrategy getTeamStrategy() {
        return teamStrategy;
    }

    public String getFile() {
        return position.getXPosition();
    }

    public String getRank() {
        return position.getYPosition();
    }
}

