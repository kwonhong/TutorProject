package com.springapp.mvc;

import lombok.Getter;

/**
 * Created by honkwon on 15-10-12.
 */
public enum SoccerEventType {
    MINI_SOCCER(0),
    FULL_GAME(1),
    HALF_GAME(2),
    HOUSE_LEAGUE(3);

    @Getter private int typeKey;
    SoccerEventType(int typeKey) {
        this.typeKey = typeKey;
    }
}
