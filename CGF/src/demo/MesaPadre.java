package demo;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class MesaPadre extends AutoDrawnableObject {

	static double vertices[][] = new double[][]{
			  {10.0, 12.0, 10.0}, /* 0 */
			  {16.0, 12.0, 10.0}, /* 1 */
			  {16.0, 0.0, 10.0}, /* 2 */
			  {10.0, 0.0, 10.0}, /* 3 */
			  {8.0,  0.0, 3.0}, /* 4 */
			  {8.0,  30.0, 3.0}, /* 5 */
			  {10.0, 27.0, 10.0}, /* 6 */
			  {18.0, 0.0, 3.0}, /* 7 */
			  {18.0, 30.0, 3.0}, /* 8 */
			  {16.0, 27.0, 10.0}, /* 9 */
			  //costa apoio bilbia frente
			  {13.0, 22.0, 10.0}, /* 10 */
			  {22.0, 36.0, 10.0}, /* 11 */
			  {21.0, 37.0, 10.0}, /* 12 */
			  {13.0, 23.0, 10.0}, /* 13 */
			  {5.0, 37.0, 10.0}, /* 14 */
			  {4.0, 36.0, 10.0}, /* 15 */
			  //costa apoio bilbia costa
			  {13.0, 22.0, 3.0}, /* 16 */
			  {22.0, 36.0, 3.0}, /* 17 */
			  {21.0, 37.0, 3.0}, /* 18 */
			  {13.0, 23.0, 3.0}, /* 19 */
			  {5.0, 37.0, 3.0}, /* 20 */
			  {4.0, 36.0, 3.0}, /* 21 */
			  {10.0, 12.0, 3.0}, /* 22 */
			  {16.0, 12.0, 3.0}, /* 23 */
			  {16.0, 0.0, 3.0}, /* 24 */
			  {10.0, 0.0, 3.0}, /* 25 */
	};
	
	
	public MesaPadre(GL2 gl) {
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
		gl.glRotatef(90, 1, 0, 0);
		gl.glTranslatef(10, 12, 10);
		gl.glScalef(0.07f, 0.07f, 0.07f);
		gl.glTranslatef(-10, -62, -10);
		
		gl.glTranslated(-45, -106, 80);
		
		
		//FRENTE
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[0], 0);
			gl.glVertex3dv(vertices[3], 0);
			gl.glVertex3dv(vertices[2], 0);
			gl.glVertex3dv(vertices[1], 0);
		}
		gl.glEnd();
		
		//TRAS
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[22], 0);
			gl.glVertex3dv(vertices[25], 0);
			gl.glVertex3dv(vertices[24], 0);
			gl.glVertex3dv(vertices[23], 0);
		}
		gl.glEnd();
		 
		//ESQUERDA
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[5], 0);
			gl.glVertex3dv(vertices[4], 0);
			gl.glVertex3dv(vertices[3], 0);
			gl.glVertex3dv(vertices[6], 0);
		}
		gl.glEnd();
	
		//DIREITA
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[9], 0);
			gl.glVertex3dv(vertices[2], 0);
			gl.glVertex3dv(vertices[7], 0);
			gl.glVertex3dv(vertices[8], 0);
		}
		gl.glEnd();
		
		//APOIO BDF
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[10], 0);
			gl.glVertex3dv(vertices[11], 0);
			gl.glVertex3dv(vertices[12], 0);
			gl.glVertex3dv(vertices[13], 0);
		}
		gl.glEnd();
		
		//APOIO BEF
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[10], 0);
			gl.glVertex3dv(vertices[13], 0);
			gl.glVertex3dv(vertices[14], 0);
			gl.glVertex3dv(vertices[15], 0);
		}
		gl.glEnd();
		
		//APOIO BDC
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[16], 0);
			gl.glVertex3dv(vertices[17], 0);
			gl.glVertex3dv(vertices[18], 0);
			gl.glVertex3dv(vertices[19], 0);
		}
		gl.glEnd();
		
		//APOIO BEC
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[0], 0);
			gl.glVertex3dv(vertices[3], 0);
			gl.glVertex3dv(vertices[2], 0);
			gl.glVertex3dv(vertices[1], 0);
		}
		gl.glEnd();
		
		//APOIO BL1
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[10], 0);
			gl.glVertex3dv(vertices[15], 0);
			gl.glVertex3dv(vertices[21], 0);
			gl.glVertex3dv(vertices[16], 0);
		}
		gl.glEnd();

		//APOIO BL2
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[10], 0);
			gl.glVertex3dv(vertices[16], 0);
			gl.glVertex3dv(vertices[17], 0);
			gl.glVertex3dv(vertices[11], 0);
		}
		gl.glEnd();

		//APOIO BL3
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[13], 0);
			gl.glVertex3dv(vertices[19], 0);
			gl.glVertex3dv(vertices[20], 0);
			gl.glVertex3dv(vertices[14], 0);
		}
		gl.glEnd();

		//Apoio BL4
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[13], 0);
			gl.glVertex3dv(vertices[12], 0);
			gl.glVertex3dv(vertices[18], 0);
			gl.glVertex3dv(vertices[19], 0);
		}
		gl.glEnd();
		
		//BL5
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[15], 0);
			gl.glVertex3dv(vertices[14], 0);
			gl.glVertex3dv(vertices[20], 0);
			gl.glVertex3dv(vertices[21], 0);
		}
		gl.glEnd();
		
		//BL6
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glVertex3dv(vertices[11], 0);
			gl.glVertex3dv(vertices[17], 0);
			gl.glVertex3dv(vertices[18], 0);
			gl.glVertex3dv(vertices[12], 0);
		}
		gl.glEnd();
		
		gl.glPopMatrix();
	}
	


}
