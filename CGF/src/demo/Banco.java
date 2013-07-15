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
//		gl.glColor3f(0.40f, 0.25f, 0f);
		
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
		
		//gl.glColor3f(0.60f, 0.30f, 0f);
		
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
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.8f, 4f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.8f, 4f, 2.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 4f, 2.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {
		
		gl.glScalef(0.4f, 0.4f, 0.5f);
		gl.glRotatef(-90, 0f, 0f, 1f);
		
		
		gl.glTranslatef(0f, 2f, 0.2f);
		gl.glPushMatrix();
		for (int i = 0; i <=13; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		gl.glTranslatef(2f, 12, 0f);
		gl.glPushMatrix();
		for (int i = 0; i <=16; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		gl.glTranslatef(0f, 10, 0f);
		for (int i = 0; i <=16; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		//Bancos L2
		gl.glRotatef(90, 0f, 0f, 1f);
		gl.glTranslatef(-35, -15, 1f);
		gl.glPushMatrix();
		for (int i = 0; i <=4; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		gl.glTranslatef(0, -9, 0f);
		gl.glPushMatrix();
		for (int i = 0; i <=4; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		//Bancos L1
		
		gl.glRotatef(180, 0f, 0f, 1f);
		gl.glTranslatef(-63.3f, -13f, 0f);
		gl.glPushMatrix();
		for (int i = 0; i <=4; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
		
		gl.glTranslatef(0, 9, 0f);
		gl.glPushMatrix();
		for (int i = 0; i <=4; i++) {
			gl.glTranslatef(3f, 0f, 0f);
			gl.glCallList(displayIndex);
		}
		gl.glPopMatrix();
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
