package com.darkcascade.flappymarshmallow;

public class GameWorld {
    private Bird _bird;

    public GameWorld(int midY) {
        _bird = new Bird(33, midY - 5, 17, 12);
    }
    public void Update(float delta) {
        _bird.Update(delta);
    }

    public Bird GetBird() { return _bird; }
}
