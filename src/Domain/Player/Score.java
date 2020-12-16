package Domain.Player;

import Domain.Statistics.GameConfiguration;

public class Score {

    //Obviously we start from 0 score.
    private double totalScore=0;

    public Score(){

    }

    // Total score formula. We add total collected molecules and (1/collection time in seconds)
    // so that faster player gets more score.

    //Collection time is the current Y / speed of the molecule

    public double updateTotalScore(double current_score, int collection_time){
        totalScore = current_score + (1/collection_time);
        return totalScore;
    }

    public double getTotalScore() {
        return totalScore;
    }

}
