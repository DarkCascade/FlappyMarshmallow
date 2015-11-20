package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.math.Vector2;

public class Scrollable {
    protected Vector2 _position, _velocity;
    protected int _width, _height;
    protected boolean _offLeftSide;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
        _position = new Vector2(x, y);
        _velocity = new Vector2(scrollSpeed, 0);

        _width = width;
        _height = height;

        _offLeftSide = false;
    }

    public void Update(float delta) {
        _position.add(_velocity.cpy().scl(delta));

        if (_position.x + _width < 0) _offLeftSide = true;
    }

    public void Reset(float newX) {
        _position.x = newX;
        _offLeftSide = false;
    }

    public boolean OffLeftSide() { return _offLeftSide; }

    public float GetX() { return _position.x; }
    public float GetTailX() { return _position.x + _width; }
}
