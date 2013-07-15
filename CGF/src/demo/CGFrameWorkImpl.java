package demo;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import br.ufal.cg.CGTemplate;
import br.ufal.cg.AutoDrawnableObject;

public class CGFrameWorkImpl extends CGTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float[] ambientLightArray = { 1f, 1f, 1f, 1f };
	private float[] diffuseLightArray = { 1f, 1f, 1f, 1f };

	@Override
	protected List<AutoDrawnableObject> initObjects(GL2 gl) {
		List<AutoDrawnableObject> objets = new ArrayList<>();
		objets.add(new Banco(gl));
		objets.add(new L1Wall(gl));
		return objets;
	}

	@Override
	protected String getApplicationName() {
		return "Teste";
	}

	@Override
	protected float[] lightPosition() {
		return new float[] { 10, -10, 8, 1 };
	}

	@Override
	protected int getShadeModel() {
		return GL2.GL_SMOOTH;
	}

	@Override
	public void processKeyPressed(char c) {

	}

	@Override
	protected void initLight(GL2 gl) {
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLightArray, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLightArray, 0);
//		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLightArray, 0);
		gl.glEnable(GL2.GL_LIGHT0);
//		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, specularLightArray, 0);
//		gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 10);
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}
	
	public static void main(String[] args) {
		new CGFrameWorkImpl();
	}
}
