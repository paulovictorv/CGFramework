package demo;

import javax.media.opengl.GL2;

public class Banco extends br.ufal.cg.AutoDrawnableObject {
	
	private int displayIndex = 3;
	
	public Banco(GL2 gl) {
		super(gl);
		compileGround(gl);
	}
	
	private void compileGround(GL2 gl) {
		gl.glNewList(displayIndex, GL2.GL_COMPILE);
		
		//horizontal meio
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(0, 0, 1f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(0, 4, 1f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1, 4, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(1, 0, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		//horizontal baixo
		
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(-0.5f, 0, 0.3f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.5f, 4, 0.3f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.8f, 4, 0.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.8f, 0, 0.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		//parte costas
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(-0.25f, 0, 1f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.25f, 4, 1f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.4f, 4, 2f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.4f, 0, 2f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		//vertical l1
		gl.glBegin(GL2.GL_QUADS);		
		gl.glVertex3f(0f, 0f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 0f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1f, 0f, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 0f, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		// vertical maior l1
		
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(-0.8f, 0f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(0f, 0f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(0f, 0f, 2.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.8f, 0f, 2.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		//vertical centro
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(0f, 2f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 2f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1f, 2f, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 2f, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		
		//vertical l2
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(0f, 4f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 4f, 0f);
		
		gl.glVertex3f(1f, 4f, 1f);
		
		gl.glVertex3f(0f, 4f, 1f);
		
		gl.glEnd();
		
		//vertical maior l2
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(0f, 4f, 0f);
//		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.8f, 4f, 0f);
//		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.8f, 4f, 2.3f);
//		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 4f, 2.3f);
//		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {
		
		gl.glScalef(0.4f, 0.4f, 0.5f);
		gl.glRotatef(-90, 0f, 0f, 1f);
		
		
		gl.glTranslatef(5f, 2f, 0.4f);
		
		gl.glPushMatrix();
		gl.glTranslatef(-0f, 15, 0f);
		for (int i = 0; i <=8; i++) {
			gl.glTranslatef(3f, 0f, 0f);
                        gl.glColor3f(0.54f,0.27f,0.07f); //marrom madeira banco
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		gl.glTranslatef(0f, 0, 0f);
		for (int i = 0; i <=8; i++) {
			gl.glTranslatef(3f, 0f, 0f);
                        gl.glColor3f(0.54f,0.27f,0.07f); //marrom madeira banco
			gl.glCallList(displayIndex);
		}

	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "Banco.jpg";
	}

}
