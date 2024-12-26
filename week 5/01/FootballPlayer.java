
public class FootballPlayer extends Player {

    private int playerNumber;
    private String position;

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPlayerNumber(int n) {
        this.playerNumber = n;
    }

    public void setPosition(String p) {
        this.position = p;
    }

    public boolean isSamePosition(FootballPlayer p) {
        return this.position.equals(p.position);
    }

}
