public class Player {
    private String name;
    private String team;

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setTeam(String t) {
        this.team = t;
    }

    public boolean isSameTeam(Player p) {
        return this.team.equals(p.team);
    }
}
