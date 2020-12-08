package Domain.Statistics;

import java.util.HashMap;

public interface StaticWindowListener {
    void onTimeChange(double time);
    void onHealthChange(int health);
    void onScoreChange(double score);
    void onAmmunitionChange(HashMap<String,HashMap<String,Integer>> map);
}
