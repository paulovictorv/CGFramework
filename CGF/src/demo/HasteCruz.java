package demo;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class HasteCruz extends AutoDrawnableObject{

	static double vertices[][] = new double[][]{
		  {0.0,  0.0, 0.0}, /* 0 */
		  {30.0, 0.0, 0.0}, /* 1 */
		  {30.0, 0.0, 30.0}, /* 2 */
		  {0.0,  0.0, 30.0}, /* 3 */
		  
		  {0.0,  4.0, 0.0}, /* 4 */
		  {30.0, 4.0, 0.0}, /* 5 */
		  {30.0, 4.0, 30.0}, /* 6 */
		  {0.0,  4.0, 30.0}, /* 7 */

		  {12.0,  4.0, 12.0}, /* 8 */
		  {18.0, 4.0, 12.0}, /* 9 */
		  {18.0, 4.0, 18.0}, /* 10 */
		  {12.0,  4.0, 18.0}, /* 11 */

		  {12.0,  200.0, 12.0}, /* 12 */
		  {18.0, 200.0, 12.0}, /* 13 */
		  {18.0, 200.0, 18.0}, /* 14 */
		  {12.0,  200.0, 18.0}, /* 15 */

		  {9.0,  200.0, 9.0}, /* 16 */
		  {21.0, 200.0, 9.0}, /* 17 */
		  {21.0, 200.0, 21.0}, /* 18 */
		  {9.0,  200.0, 21.0}, /* 19 */

		  {7.0,  240.0, 7.0}, /* 20 */
		  {23.0, 240.0, 7.0}, /* 21 */
		  {23.0, 240.0, 23.0}, /* 22 */
		  {7.0,  240.0, 23.0}, /* 23 */  
		}; 
	
	public HasteCruz(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "Metal.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
        texture.bind(gl);
		
		gl.glScaled(0.01f, 0.01f, 0.01f);
		gl.glRotated(90, 1, 0, 0);
		
		gl.glTranslated(200, 20, 1900);
		
		paintFromArray(gl, 0, 3, 2, 1);
		paintFromArray(gl, 4, 7, 6, 5);
		paintFromArray(gl, 0,3,7,4);
		paintFromArray(gl, 0,1,5,4);
		paintFromArray(gl, 1,2,6,5);
		paintFromArray(gl, 2,3,7,6);
		paintFromArray(gl, 8,9,10,11);
		paintFromArray(gl, 9,10,14,13);
		paintFromArray(gl, 11,10,14,15);
		paintFromArray(gl, 8,9,13,12);
		paintFromArray(gl, 8,11,15,12);
		paintFromArray(gl, 16,17,18,19);
		paintFromArray(gl, 16,19,23,20);
		paintFromArray(gl, 17,18,22,21);
		paintFromArray(gl, 18,19,23,22);
		paintFromArray(gl, 16,17,21,20);
		
	}
	
	public void paintFromArray(GL2 gl, Integer... array){
		gl.glBegin(GL2.GL_POLYGON);
		for (int i = 0; i < array.length; i++){
			setTexture(i);
			gl.glVertex3dv(vertices[array[i]], 0);
		}
		gl.glEnd();
	}

	private void setTexture (int arrayIndex) {
		switch(arrayIndex) {
		case 0:
			gl.glTexCoord2f(1, 0);
			break;
		case 1:
			gl.glTexCoord2f(0, 1);
			break;
		case 2:
			gl.glTexCoord2f(1, 1);
			break;
		case 3:
			gl.glTexCoord2f(0, 0);
			break;
		}
	}
}
