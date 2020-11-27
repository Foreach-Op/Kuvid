package Domain.Useful;

public class Score {

    //Obviously we start from 0 score.
    private double totalScore=0;

    public Score(){

    }

    // Total score formula. We add total collected molecules and (1/collection time in seconds)
    // so that faster player gets more score.

    public void updateTotalScore(int collected_molecules, int collection_time){
        totalScore = collected_molecules + (1/collection_time);
    }

    public double getTotalScore() {
        return totalScore;
    }

    // Unnecessary at the moment
   /* public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    } */
}
