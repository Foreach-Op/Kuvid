package Domain.TransformStrategy;

import Domain.CollisionStrategy.CollisionStrategy;
import Domain.Objects.GameObject;

import java.util.HashMap;

public class BlendBreak {
    private BlendBreakStrategy blendBreakStrategy;

    public BlendBreak(BlendBreakStrategy blendBreakStrategy){
        this.blendBreakStrategy=blendBreakStrategy;
    }

    public void executeBlend(HashMap<String,Integer> map){
        blendBreakStrategy.Blend(map);
    }

    public void executeBreak(HashMap<String,Integer> map){
        blendBreakStrategy.Break(map);
    }
}
