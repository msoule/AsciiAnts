package pokebowl.screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{Color, GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.{Rectangle, Vector3}
import com.badlogic.gdx.{Gdx, InputAdapter, Screen}

/**
  * Created by msoule on 1/26/16.
  */
class PlayScreen(width: Float, height: Float, background: Color=Color.WHITE) extends InputAdapter with Screen {

  var batch: SpriteBatch = _
  var shapeRenderer: ShapeRenderer = _
  var camera: OrthographicCamera = _
  var box: Rectangle = _
  var testSprite: Texture = _

  override def resize(width: Int, height: Int): Unit = {

  }

  override def hide(): Unit = {

  }

  override def dispose(): Unit = {

  }

  override def pause(): Unit = {

  }

  /**
    * Draw new screen and process user input.
    * @param delta Time in seconds since last render.
    */
  override def render(delta: Float): Unit = {
    // clear the screen with a dark blue color. The
    // arguments to glClearColor are the red, green
    // blue and alpha component in the range [0,1]
    // of the color to be used to clear the screen.
    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    // tell the camera to update its matrices.
    camera.update()

    // tell the SpriteBatch to render in the
    // coordinate system specified by the camera.
//    batch.setProjectionMatrix(camera.combined)
//    batch.begin()
//    batch.draw(testSprite, box.x, box.y)
//    batch.end()
    drawMenu()

    // process user input
    if(Gdx.input.isTouched()) {
      val touchPos: Vector3 = new Vector3()
      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0)
      camera.unproject(touchPos)
      box.x = touchPos.x - 64 / 2
    }

    // Check for user input and move the box as specified.
    if(Gdx.input.isKeyPressed(Keys.LEFT)) box.x -= 200 * Gdx.graphics.getDeltaTime
    if(Gdx.input.isKeyPressed(Keys.RIGHT)) box.x += 200 * Gdx.graphics.getDeltaTime
    if(Gdx.input.isKeyPressed(Keys.DOWN)) box.y -= 200 * Gdx.graphics.getDeltaTime
    if(Gdx.input.isKeyPressed(Keys.UP)) box.y += 200 * Gdx.graphics.getDeltaTime

    // Make sure the sprite stays within the screen bounds
    if(box.x < 0) box.x = 0
    if(box.x > width - 64) box.x = width - 64
    if(box.y < 0) box.y = 0
    if(box.y > height - 64) box.y = height - 64
  }

  private def drawMenu(): Unit = {
    val buffer = 40
    val menuBoxWidth = 160
    val menuBoxHeight = 90
    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeType.Line)
    shapeRenderer.setColor(0, 0, 0, 0)
    // bottom left
    shapeRenderer.rect(buffer, buffer, menuBoxWidth, menuBoxHeight)
    // top left
    shapeRenderer.rect(buffer, buffer + menuBoxHeight, menuBoxWidth, menuBoxHeight)
    // top right
    shapeRenderer.rect(buffer + menuBoxWidth, buffer + menuBoxHeight, menuBoxWidth, menuBoxHeight)
    // bottom right
    shapeRenderer.rect(buffer + menuBoxWidth, buffer, menuBoxWidth, menuBoxHeight)

    shapeRenderer.end()
  }

  /**
    * Initializes the screen at creation.
    */
  override def show(): Unit = {
    // create the camera and the SpriteBatch
    camera = new OrthographicCamera()
    camera.setToOrtho(false, width, height)
    batch = new SpriteBatch()
    shapeRenderer = new ShapeRenderer()

    testSprite = new Texture(Gdx.files.internal("sprites/bucket.png"));

    // create a Rectangle to logically represent the bucket
    box = new Rectangle()
    box.x = width / 2 - 64 / 2 // center the bucket horizontally
    box.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
    box.width = 64
    box.height = 64
  }

  override def resume(): Unit = {

  }
}
