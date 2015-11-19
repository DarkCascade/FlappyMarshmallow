package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
    Bird _bird;

    public InputHandler(Bird bird) {
        _bird = bird;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        _bird.Tap();
        return true;
    }

    @Override public boolean keyDown(int i) { return false; }
    @Override public boolean keyUp(int i) { return false; }
    @Override public boolean keyTyped(char c) { return false; }
    @Override public boolean touchUp(int i, int i1, int i2, int i3) { return false; }
    @Override public boolean touchDragged(int i, int i1, int i2) { return false; }
    @Override public boolean mouseMoved(int i, int i1) { return false; }
    @Override public boolean scrolled(int i) { return false; }
}
