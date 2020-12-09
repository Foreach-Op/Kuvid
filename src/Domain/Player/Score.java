package Domain.Player;

import Domain.Statistics.GameConfiguration;

public class Score {

    //Obviously we start from 0 score.
    private double totalScore=0;

    public Score(){

    }

    // Total score formula. We add total collected molecules and (1/collection time in seconds)
    // so that faster player gets more score.

    public void updateTotalScore(int collected_molecules, int collection_time){
        totalScore = collected_molecules + (1/collection_time);
        GameConfiguration.getInstance().setScore(totalScore);
    }

    public void setTotalScore(double score){
        this.totalScore=score;
    }

    public double getTotalScore() {
        return totalScore;
    }

}
