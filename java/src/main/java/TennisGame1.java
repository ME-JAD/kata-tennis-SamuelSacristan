public class TennisGame1 implements TennisGame {

    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int GAME_POINT = 4;

    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        if (isEqualScore()) {
            return getEqualScoreDescription();
        }

        if (isEndgame()) {
            return getEndgameScoreDescription();
        }

        return getRegularScoreDescription();
    }

    private boolean isEqualScore() {
        return player1Score == player2Score;
    }

    private boolean isEndgame() {
        return player1Score >= GAME_POINT || player2Score >= GAME_POINT;
    }

    private String getEqualScoreDescription() {
        return switch (player1Score) {
            case LOVE -> "Love-All";
            case FIFTEEN -> "Fifteen-All";
            case THIRTY -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private String getEndgameScoreDescription() {
        int scoreDifference = player1Score - player2Score;

        if (scoreDifference == 1) {
            return "Advantage " + player1Name;
        } else if (scoreDifference == -1) {
            return "Advantage " + player2Name;
        } else if (scoreDifference >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    private String getRegularScoreDescription() {
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }
}