package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {
    private GameWorld _world;
    private OrthographicCamera _camera;

    private ShapeRenderer _shapeRender;
    private SpriteBatch _sb;

    private float _runTime;
    private int _midY;
    private int _gameHeight;

    private Bird _bird;

    private TextureRegion _bg, _grass;
    private Animation _birdAnimation;
    private TextureRegion _birdMid, _birdDown, _birdUp;
    private TextureRegion _skullUp, _skullDown, _bar;

    public void Initialize(GameWorld w, int gameHeight, int midY) {
        _world = w;

        _camera = new OrthographicCamera();
        _camera.setToOrtho(true, 136, gameHeight);

        _shapeRender = new ShapeRenderer();
        _shapeRender.setProjectionMatrix(_camera.combined);

        _sb = new SpriteBatch();
        _sb.setProjectionMatrix(_camera.combined);

        _runTime = 0;
        _midY = midY;
        _gameHeight = gameHeight;

        AssetLoader.Load();
        initializeGameObjects();
        initializeGraphicAssets();
    }

    public void Render(float delta) {
        _runTime += delta;

        _world.Update(delta);

        Bird bird = _world.GetBird();

        Gdx.gl.glClearColor((0 / 255.0f), (0 / 255.0f), (0 / 255.0f), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _shapeRender.begin(ShapeRenderer.ShapeType.Filled);

        _shapeRender.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        _shapeRender.rect(0, 0, 136, _midY + 66);

        _shapeRender.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        _shapeRender.rect(0, _midY + 66, 136, 11);

        _shapeRender.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        _shapeRender.rect(0, _midY + 77, 136, 52);

        _shapeRender.end();

        _sb.begin();

        _sb.disableBlending();
        _sb.draw(_bg, 0, _midY + 23, 136, 43);

        _sb.enableBlending();

        if (_bird.shouldFlap()) {
            _sb.draw(_birdAnimation.getKeyFrame(_runTime),
                    bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
        } else {
            _sb.draw(_birdMid, _bird.getX(), _bird.getY(), _bird.getWidth() / 2.0f, _bird.getHeight() / 2.0f, _bird.getWidth(), _bird.getHeight(), 1, 1, _bird.getRotation());
        }

        _sb.end();
    }

    private void initializeGameObjects() {
        _bird = _world.GetBird();
    }

    private void initializeGraphicAssets() {
        _bg = AssetLoader.bg;
        _grass = AssetLoader.grass;

        _birdAnimation = AssetLoader.birdAnimation;
        _birdMid = AssetLoader.bird;
        _birdDown = AssetLoader.birdDown;
        _birdUp = AssetLoader.birdUp;

        _skullDown = AssetLoader.skullDown;
        _skullUp = AssetLoader.skullUp;

        _bar = AssetLoader.bar;
    }
}
