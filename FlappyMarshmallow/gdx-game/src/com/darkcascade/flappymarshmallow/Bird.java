package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 _position, _velocity, _acceleration;
    private float _rotation;
    private int _width, _height;

    public Bird(float x, float y, int width, int height) {
        this._width = width;
        this._height = height;

        _position = new Vector2(x, y);
        _velocity = Vector2.Zero;
        _acceleration = new Vector2(0, 460);
    }

    public void Update(float delta) {
        _velocity.add(_acceleration.cpy().scl(delta));

        if (_velocity.y > 200) _velocity.y = 200;

        _position.add(_velocity.cpy().scl(delta));

        if (_velocity.y < 0) {
            _rotation -= 600 * delta;

            if (_rotation < -20) _rotation = -20;
        }

        if (isFalling()) {
            _rotation += 480 * delta;
            if (_rotation > 90) _rotation = 90;
        }
    }

    public void Tap() {
        _velocity.y = -140;
    }

    public boolean isFalling() {
        return _velocity.y > 110;
    }

    public boolean shouldFlap() {
        return _velocity.y <= 70;
    }

    public float getX() { return _position.x; }
    public float getY() { return _position.y; }

    public float getWidth() { return _width; }
    public float getHeight() { return _height; }

    public float getRotation() { return _rotation; }
}
