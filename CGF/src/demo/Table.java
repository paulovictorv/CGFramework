package demo;

import br.ufal.cg.AutoDrawnableObject;
import javax.media.opengl.GL2;

public class Table extends AutoDrawnableObject {

    public Table(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Granito.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {
    	texture.enable(gl);
        texture.bind(gl);
    	
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_POLYGON);
        {
        	gl.glTexCoord2f(1, 0);
            gl.glVertex3f(0, 0, 1.3f);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(0, 0.5f, 1.3f);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(0, 0.5f, 0);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(0, 0, 0);
        }
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_POLYGON);
        {
        	gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1.5f, 0, 1.3f);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1.5f, 0.5f, 1.3f);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(-1.5f, 0.5f, 0);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(-1.5f, 0, 0);
        }
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_POLYGON);
        {
        	gl.glTexCoord2f(0, 0);
            gl.glVertex3f(0.2f, -0.2f, 1.3f);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(0.2f, 0.7f, 1.3f);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(-1.7f, 0.7f, 1.3f);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1.7f, -0.2f, 1.3f);
        }
        gl.glEnd();
        gl.glPopMatrix();
    }
}
