package com.darkcascade.flappymarshmallow;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;

public class MyGdxGame implements ApplicationListener
{
	Texture texture;
	SpriteBatch batch;

	OrthographicCamera _camera;

	private GameRenderer _renderer;

	@Override
	public void create()
	{
		texture = new Texture(Gdx.files.internal("android.jpg"));
		batch = new SpriteBatch();

		_camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		_camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		_camera.update();

		float sWidth = Gdx.graphics.getWidth();
		float sHeight = Gdx.graphics.getHeight();
		float gWidth = 136;
		float gHeight = sHeight / (sWidth / gWidth);

		int midY = (int)(gHeight / 2);

		GameWorld world = new GameWorld(midY);
		_renderer = new GameRenderer();
		_renderer.Initialize(world, (int)gHeight, midY);

		Gdx.input.setInputProcessor(new InputHandler(world.GetBird()));
	}

	@Override
	public void render()
	{
		_renderer.Render(Gdx.graphics.getDeltaTime());
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
