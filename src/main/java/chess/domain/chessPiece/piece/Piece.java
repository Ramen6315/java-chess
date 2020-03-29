package chess.domain.chessPiece.piece;

import chess.domain.Position;
import chess.domain.XAxis;
import chess.domain.chessPiece.team.TeamStrategy;
import chess.domain.chessboard.ChessBoard;
import chess.domain.move.MoveType;

public abstract class Piece implements PieceAbility {
    protected Position position;
    final TeamStrategy teamStrategy;

    public Piece(Position position, TeamStrategy teamStrategy) {
        this.position = position;
        this.teamStrategy = teamStrategy;
    }

    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
    }

    public void move(MoveType moveType, ChessBoard chessBoard) {
        position.move(moveType, chessBoard);
    }

    public boolean isSameTeam(Piece targetPiece) {
        return teamStrategy.equals(targetPiece.teamStrategy);
    }

    public boolean isSameFile(XAxis XAxis) {
        return this.position.isSameFile(XAxis);
    }
}

