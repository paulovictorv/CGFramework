package br.ufal.cg;

import java.awt.Dimension;
import java.util.List;

import javax.media.opengl.DebugGL2;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;




import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;


/**
 * 
 * 
 * @author Andrey Rodrigues
 */

public abstract class CGTemplate extends MovableCamera {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float[] lightPos;

	private List<AutoDrawnableObject> objects;
	private GLUT glut;

	public CGTemplate() {

		glut = new GLUT();

		// Definição do método template
		init_and_show_GUI();

	}

	// Hotspots

	/**
	 * Define here objects to be rendered
	 * 
	 * @return
	 */
	protected abstract List<AutoDrawnableObject> initObjects(GL2 gl);

	/**
Já que eu quero estigar a discussão técnica no grupo, abrirei uma pra ver o que acontece: O que ac
	 * 
	 * @return String to be placed on JFrame
	 */
	protected abstract String getApplicationName();

	
	/**
	 * Init method for GL_LIGHT0.
	 * 
	 * A sample for this method is:
	 * 
	 * 	gl.glEnable(GL2.GL_LIGHTING);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLightArray, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLightArray, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLightArray, 0);
		gl.glEnable(GL2.GL_LIGHT0);

		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, specularLightArray, 0);
		gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);

		gl.glEnable(GL2.GL_COLOR_MATERIAL);
	 * 
	 * @param gl
	 */
	protected abstract void initLight(GL2 gl);

	/**
	 * 
	 * @return light position e.g: new float[]{x,y,z,1}
	 */
	protected abstract float[] lightPosition();

	/**
	 * 
	 * @return GL2.GL_SMOOTH or GL2.GL_FLAT
	 */
	protected abstract int getShadeModel();

	/**
	 * All pressed keys, will call this method. It can be useful for moving
	 * objects or turn on/off lights
	 * 
	 */
	public abstract void processKeyPressed(final char c);

	// Template Method
	private void init_and_show_GUI() {

		lightPos = lightPosition();

		GLCanvas canvas;

		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilites = new GLCapabilities(profile);
		capabilites.setDoubleBuffered(true);

		canvas = new GLCanvas(capabilites);
		Animator animator = new Animator(canvas);

		JFrame frame = new JFrame(getApplicationName());
		frame.getContentPane().add(canvas);

		canvas.addGLEventListener(this);
		UserKeyBoardListener listener = new UserKeyBoardListener(this);
		UserMouseEventListener mouseListener = new UserMouseEventListener(this);

		canvas.addKeyListener(listener);
		canvas.addMouseListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);

		frame.getContentPane().add(canvas);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 400));
		frame.setVisible(true);

		canvas.requestFocus();
		animator.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();
		// Clear the drawing area
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		// Reset the current matrix to the "identity"
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		setCameraPos();

		
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPos, 0);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		for (AutoDrawnableObject obj : objects) {
			gl.glPushMatrix();
			obj.bindTexture();
			obj.selfDraw(gl);
			obj.unbindTexture();
			gl.glPopMatrix();
		}

		gl.glTranslatef(lightPos[0], lightPos[1], lightPos[2]);
		gl.glColor3f(1f, 1f, 1f);
		glut.glutSolidSphere(0.2f, 30, 30);

		gl.glFlush();

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));
		objects = initObjects(gl);
		initLight(gl);
		gl.setSwapInterval(1);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glClearColor(.2f, .2f, .5f, 0);
		gl.glShadeModel(getShadeModel()); 
											

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		GL2 gl = drawable.getGL().getGL2();

		GLU glu = new GLU();

		if (height <= 0) {
			height = 1;
		}
		final float h = (float) width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 200.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}

}
