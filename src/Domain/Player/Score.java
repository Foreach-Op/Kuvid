package Domain.Player;

import Domain.Statistics.GameConfiguration;

public class Score {

    //Obviously we start from 0 score.
    private double totalScore;

    public Score(double scoreLevel){
        this.totalScore=scoreLevel;
    }

    // Total score formula. We add total collected molecules and (1/collection time in seconds)
    // so that faster player gets more score.

    //Collection time is the current Y / speed of the molecule

    public double updateTotalScore(int collection_time){
        //totalScore = totalScore + 1 + (1/collection_time); //for now collected time is not calculated.
        totalScore = totalScore + 1;
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getTotalScore() {
        return totalScore;
    }

}
