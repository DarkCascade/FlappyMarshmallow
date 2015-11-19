package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {
    private GameWorld _world;
    private OrthographicCamera _camera;

    private ShapeRenderer _shapeRender;
    private SpriteBatch _sb;

    private float _runTime;
    private int _midY;
    private int _gameHeight;

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

        _shapeRender.setColor(111/255.0f, 186/255.0f, 45/255.0f, 1);
        _shapeRender.rect(0, _midY+66, 136, 11);

        _shapeRender.setColor(147/255.0f, 80/255.0f, 27/255.0f, 1);
        _shapeRender.rect(0, _midY+77, 136, 52);

        _shapeRender.end();

        _sb.begin();

        _sb.disableBlending();
        _sb.draw(AssetLoader.bg, 0, _midY+23, 136, 43);

        _sb.enableBlending();
        _sb.draw(AssetLoader.birdAnimation.getKeyFrame(_runTime), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        _sb.end();
    }
}
