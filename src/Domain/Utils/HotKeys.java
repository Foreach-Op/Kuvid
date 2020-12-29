package Domain.Utils;

import java.awt.event.KeyEvent;

public enum HotKeys {
    MOVE_RIGHT(KeyEvent.VK_D),
    MOVE_LEFT(KeyEvent.VK_A),
    ROTATE_RIGHT(KeyEvent.VK_E), // SCROLL WHEEL
    ROTATE_LEFT(KeyEvent.VK_Q), // SCROLL WHEEL
    SHOOT(KeyEvent.VK_SPACE),
    PICK_ATOM(KeyEvent.VK_C),
    BLEND(KeyEvent.VK_B),
    ATOM_TYPE1(KeyEvent.VK_1),
    ATOM_TYPE2(KeyEvent.VK_2),
    ATOM_TYPE3(KeyEvent.VK_3),
    ATOM_TYPE4(KeyEvent.VK_4),
    // ALT + ATOM TYPE -> PICKING POWERUP
    // ALT + ATOM TYPE -> ADD SHIELD (1: Eta, 2: Lota, 3: Theta, 4: Zeta)

    PAUSE(KeyEvent.VK_ESCAPE);

    private int id;

    HotKeys(int id) {
        this.id = id;
    }

    public int getValue(){
        return id;
    }
}
