public class Learner {
    String userName;
    double highScore;
    double lastScore;


    public Learner(String username, double highscore, double lastscore){
        this.userName = username;
        this.highScore = highscore;
        this.lastScore = lastscore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getHighScore() {
        return highScore;
    }

    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }

    public double getLastScore() {
        return lastScore;
    }

    public void setLastScore(double lastScore) {
        this.lastScore = lastScore;
    }
}
