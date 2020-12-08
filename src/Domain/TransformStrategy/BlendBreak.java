package Domain.TransformStrategy;

import Domain.CollisionStrategy.CollisionStrategy;
import Domain.Objects.GameObject;

import java.util.HashMap;

public class BlendBreak {
    private BlendBreakStrategy blendBreakStrategy;

    public BlendBreak(BlendBreakStrategy blendBreakStrategy){
        this.blendBreakStrategy=blendBreakStrategy;
    }

    public boolean executeBlend(HashMap<String,Integer> map){
        return blendBreakStrategy.Blend(map);
    }

    public boolean executeBreak(HashMap<String,Integer> map){
        return blendBreakStrategy.Break(map);
    }
}
