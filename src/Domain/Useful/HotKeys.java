package Domain.Useful;

import java.awt.event.KeyEvent;

public enum HotKeys {
    MOVE_RIGHT(KeyEvent.VK_D), // D
    MOVE_LEFT(KeyEvent.VK_A), // A
    ROTATE_RIGHT(KeyEvent.VK_E), // SCROLL WHEEL
    ROTATE_LEFT(KeyEvent.VK_Q), // SCROLL WHEEL
    SHOOT(KeyEvent.VK_SPACE), // LEFT CLICK
    PICK_ATOM(KeyEvent.VK_C), // SPACE
    BLEND(KeyEvent.VK_B), // ALT + ATOM TYPE
    ATOM_TYPE1(KeyEvent.VK_1),
    ATOM_TYPE2(KeyEvent.VK_2),
    ATOM_TYPE3(KeyEvent.VK_3),
    ATOM_TYPE4(KeyEvent.VK_4),
    PAUSE(KeyEvent.VK_P),
    RESUME(KeyEvent.VK_R),

    SAVE(KeyEvent.VK_S),
    LOAD(KeyEvent.VK_L);

    // PICKING POWERUP, ONLY 1 - 2 - 3 - 4

    private int id;

    HotKeys(int id) {
        this.id = id;
    }

    public int getValue(){
        return id;
    }
}
