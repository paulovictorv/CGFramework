package demo;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Floor extends AutoDrawnableObject{

	public Floor(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		// TODO Auto-generated method stub
		return "FrontWall.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f, 0f, 0f);
                gl.glColor3f(0.66f,0.66f,0.66f);
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3f(0, 0, 0.2f);
			gl.glVertex3f(0, -20.5f, 0.2f);
			gl.glVertex3f(10f, -20.5f, 0.2f);
			gl.glVertex3f(10f, 0, 0.2f);
		}
		gl.glEnd();
		gl.glPopMatrix();
	}

}
