package Domain.TransformStrategy;

import java.util.HashMap;

public interface BlendBreakStrategy {
    void Blend(HashMap<String,Integer> atomMap);
    void Break(HashMap<String,Integer> atomMap);
}
