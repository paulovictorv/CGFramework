package demo;

import br.ufal.cg.AutoDrawnableObject;
import javax.media.opengl.GL2;

public class Table extends AutoDrawnableObject {

    public Table(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return null;
    }

    @Override
    protected String getTextureImg() {
        return null;
    }

    @Override
    public void selfDraw(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(0.18f, 0.31f, 0.31f);
        gl.glBegin(GL2.GL_POLYGON);
        {
            gl.glVertex3f(0, 0, 1);
            gl.glVertex3f(0, 0.5f, 1);
            gl.glVertex3f(0, 0.5f, 0);
            gl.glVertex3f(0, 0, 0);
        }
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(0.18f, 0.31f, 0.31f);
        gl.glBegin(GL2.GL_POLYGON);
        {
            gl.glVertex3f(-1.5f, 0, 1);
            gl.glVertex3f(-1.5f, 0.5f, 1);
            gl.glVertex3f(-1.5f, 0.5f, 0);
            gl.glVertex3f(-1.5f, 0, 0);
        }
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(5, -15, 0.2f);
        gl.glColor3f(0.18f, 0.31f, 0.31f);
        gl.glBegin(GL2.GL_POLYGON);
        {
            gl.glVertex3f(0.2f, -0.2f, 1);
            gl.glVertex3f(0.2f, 0.7f, 1);
            gl.glVertex3f(-1.7f, 0.7f, 1);
            gl.glVertex3f(-1.7f, -0.2f, 1);
        }
        gl.glEnd();
        gl.glPopMatrix();
    }
}
