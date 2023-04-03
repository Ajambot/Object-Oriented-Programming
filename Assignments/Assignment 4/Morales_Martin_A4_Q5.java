/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 4, Q5

The program implements team and competition classes used to represent a team participating in
programming competitions. The program implements a deep copy constructor to easily copy information
over to another class since most information stays the same every year.
*/
class Team{
    private String teamName;
    private String[] members = new String[4];
    private Competition[] competitions = new Competition[2];

    // Initialized constructor
    public Team(String teamName, String[] members, Competition[] competitions) {
        this.teamName = teamName;
        this.members = members;
        this.competitions = competitions;
    }

    // Copy constructor
    public Team(Team t2){
        // Primitive data types. No need to create a new object. String are immutable so no need either
        this.teamName = t2.teamName;
        for(int i=0; i<4; i++){
            members[i] = t2.members[i];
        }

        // Copy each competition
        for(int i=0; i<2; i++){
            competitions[i] = new Competition(t2.competitions[i]);
        }
    }

    // Getter and setter for team name
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Getter and setter for members
    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }

    // getter for competition
    public Competition[] getCompetitions() {
        return competitions;
    }

    // Setter for competitions
    public void setCompetitions(String[] name, String[] winner, String[] runnerUp, int[] year) {
        competitions[0] = new Competition(name[0], winner[0], runnerUp[0], year[0]);
        competitions[1] = new Competition(name[1], winner[1], runnerUp[1], year[1]);
    }

    // Converts class info to string
    public String toString(){
        return "Team Name: " + teamName + "\nMembers: " + members[0] + ", " + members[1] + ", " +
                members[2] + ", " + members[3] + "\nCompetitions:\n\n" + competitions[0].toString() + "\n" + competitions[1].toString() + "\n";
    }
}

// Competition class. Aggregation relation to Team class
class Competition{
    private String nameOfCompetition, winners, runnerUp;
    private int year;

    // Initialized constructor
    public Competition(String nameOfCompetition, String winners, String runnerUp, int year) {
        this.nameOfCompetition = nameOfCompetition;
        this.winners = winners;
        this.runnerUp = runnerUp;
        this.year = year;
    }

    // Copy constructor
    public Competition(Competition c2) {
        nameOfCompetition = c2.nameOfCompetition;
        winners = c2.winners;
        runnerUp = c2.runnerUp;
        year = c2.year;
    }

    // Getter and setter for name of competition
    public String getNameOfCompetition() {
        return nameOfCompetition;
    }

    public void setNameOfCompetition(String nameOfCompetition) {
        this.nameOfCompetition = nameOfCompetition;
    }

    // Getter and setter for winners
    public String getWinners() {
        return winners;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }

    // Getter adn setter for runnerUp
    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    // Getter and setter for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Converts class info to string
    public String toString(){
        return "Competition: " + nameOfCompetition + "\nWinner: " + winners + "\nRunner Up: " + runnerUp + "\nYear: " + year + "\n";
    }
}

public class Morales_Martin_A4_Q5 {
    public static void main(String[] args) {
        Team t1 = new Team("Backyardigans", new String[]{"Pablo", "Uniqua", "Tasha", "Austin"},
                new Competition[]{new Competition("Hackathon", "Team 10", "Team 7", 2017),
                new Competition("IOI", "Team China", "Team US", 2022)});
        Team t2 = new Team(t1);
        System.out.println(t1);
        System.out.println(t2);
        int [] newYear = {2004, 2008};
        t2.setCompetitions(new String[]{"ICPC", "OCC"}, new String[]{"Team 19", "Team 1"}, new String[]{"Team 2", "Team 6"}, newYear);
        System.out.println(t1);
        System.out.println(t2);
    }
}