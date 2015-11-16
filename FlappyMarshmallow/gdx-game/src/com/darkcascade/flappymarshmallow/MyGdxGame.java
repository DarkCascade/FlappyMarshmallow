package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame implements ApplicationListener
{
	Texture texture;
	SpriteBatch batch;

	ShapeRenderer _shapeRender;
	OrthographicCamera _camera;

	@Override
	public void create()
	{
		texture = new Texture(Gdx.files.internal("android.jpg"));
		batch = new SpriteBatch();

		_camera = new OrthographicCamera(Gdx.graphics.getWidth, Gdx.graphics.getHeight);
		_camera.position.set(Gdx.graphics.getWidth/2, Gdx.graphics.getHeight/2, 0);
		_camera.update();

		_shapeRender = new ShapeRenderer();
		_shapeRender.setProjectionMatrix(_camera.combined);
	}

	@Override
	public void render()
	{        
		Gdx.gl.glClearColor(1, 1, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glLineWidth(20);

		batch.begin();

		_shapeRender.begin(ShapeType.Line);
		_shapeRender.setColor(0, 0, 0, 1);
		_shapeRender.circle(160, 284, 100);
		_shapeRender.circle(120, 314, 18);
		_shapeRender.circle(200, 314, 18);
		_shapeRender.polyline(Array(100, 260, 160, 220, 220, 260.0f));
		_shapeRender.end();

		batch.end();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
