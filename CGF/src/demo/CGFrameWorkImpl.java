package demo;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import br.ufal.cg.AutoDrawnableObject;
import br.ufal.cg.CGTemplate;

public class CGFrameWorkImpl extends CGTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float[] ambientLightArray = { 1f, 1f, 1f, 1f };
	private float[] diffuseLightArray = { 1f, 1f, 1f, 1f };

	private Door doorToOpen;
	
	@Override
	protected List<AutoDrawnableObject> initObjects(GL2 gl) {
		List<AutoDrawnableObject> objets = new ArrayList<AutoDrawnableObject>();
		objets.add(new Banco(gl));
		gl.glColor3f(232f / 235f, 255f / 255f, 160f / 255f);
		objets.add(new L1Wall(gl));
		objets.add(new L2Wall(gl));
		objets.add(new FrontWall(gl));
		objets.add(new BackWall(gl));
		objets.add(new Roof(gl));
		objets.add(new Floor(gl));
        objets.add(new Table(gl));
		doorToOpen = new Door(gl);
		objets.add(doorToOpen);
		objets.add(new MesaPadre(gl));
		objets.add(new HasteCruz(gl));
		objets.add(new Cruz(gl));
		return objets;
	}

	@Override
	protected String getApplicationName() {
		return "Teste";
	}

	@Override
	protected float[] lightPosition() {
		return new float[] { 4, -10, 8, 1 };
	}

	@Override
	protected int getShadeModel() {
		return GL2.GL_SMOOTH;
	}

	@Override
	public void processKeyPressed(char c) {

	}

	@Override
	public void processButtonClickEvent(String eventCommand) {
		if (eventCommand.equals("ABRIR_PORTA")){
			doorToOpen.openDoor();
		} else {
			doorToOpen.closeDoor();
		}
	}
	
	@Override
	protected void initLight(GL2 gl) {
	  	gl.glEnable(GL2.GL_LIGHTING);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLightArray, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLightArray, 0);
		gl.glEnable(GL2.GL_LIGHT0);

		gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}
	
	public static void main(String[] args) {
		new CGFrameWorkImpl();
	}

}
