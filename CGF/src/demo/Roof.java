package demo;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Roof extends AutoDrawnableObject {

	public Roof(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "Telhado.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
        texture.bind(gl);
		
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f, 0, 8.20f);
		gl.glRotatef(-38.66f, 0, 1, 0);
		
		gl.glColor3f(1, 1, 1);
		gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, -20.5f, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(6.40f, -20.5f, 0);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(6.40f, 0, 0);
			}
		gl.glEnd();
			
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(9.5f, 0, 8.20f);
		gl.glRotatef(-38.66f+257.36f, 0, 1, 0);
		
		gl.glColor3f(1, 1, 1);
		gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, -20.5f, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(6.40f, -20.5f, 0);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(6.40f, 0, 0);
			}
		gl.glEnd();
			
		gl.glPopMatrix();

	}

}
