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
		return "Piso.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
        texture.bind(gl);
		
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f, 0f, 0f);
                gl.glColor3f(0.96f,0.96f,0.86f);
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glTexCoord2f(0, 1);
			gl.glVertex3f(0, 0, 0.2f);
			gl.glTexCoord2f(0, 0);
			gl.glVertex3f(0, -20.5f, 0.2f);
			gl.glTexCoord2f(1, 0);
			gl.glVertex3f(10f, -20.5f, 0.2f);
			gl.glTexCoord2f(1, 1);
			gl.glVertex3f(10f, 0, 0.2f);
		}
		gl.glEnd();
		gl.glPopMatrix();
	}

}
