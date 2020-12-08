package Domain.TransformStrategy;

import java.util.HashMap;

public interface BlendBreakStrategy {
    boolean Blend(HashMap<String,Integer> atomMap);
    boolean Break(HashMap<String,Integer> atomMap);
}
