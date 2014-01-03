package demo;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Cruz extends AutoDrawnableObject{

	static double chao = 0.0;
	static double topo = 90.0;
	static double espessura = 10.0;
	static double larguraCruz = 10.0;
	static double tamanhoBracoCruz = 30.0;
	static double alturaBracoCruz = 60.0;
	
	static double vertices[][] = new double[][]{
	    {0.0,  topo, espessura}, /* 0 */
	    {20.0, topo, espessura}, /* 1 */
	    {larguraCruz, topo, espessura},  /* 2 */
	    {larguraCruz,  0.0, espessura}, /* 3 */
	    {0.0,   0.0, espessura}, /* 4 */
	    {0.0,  topo,  0.0}, /* 5 */
	    {larguraCruz, topo,  0.0}, /* 6 */
	    {larguraCruz,  0.0,  0.0}, /* 7 */
	    {0.0,   0.0,  0.0}, /* 8 */
	    {-tamanhoBracoCruz, alturaBracoCruz, espessura}, /* 9 */
	    {-tamanhoBracoCruz, alturaBracoCruz-espessura, espessura}, /* 10 */
	    {larguraCruz+tamanhoBracoCruz, alturaBracoCruz-espessura, espessura}, /* 11 */
	    {larguraCruz+tamanhoBracoCruz, alturaBracoCruz, espessura}, /* 12 */
	    {-tamanhoBracoCruz, alturaBracoCruz, 0.0}, /* 13 */
	    {larguraCruz+tamanhoBracoCruz, alturaBracoCruz, 0.0}, /* 14 */
	    {larguraCruz+tamanhoBracoCruz, alturaBracoCruz-espessura, 0.0}, /* 15 */
	    {-tamanhoBracoCruz, alturaBracoCruz-espessura, 0.0} /* 16 */
	};
	
	public Cruz(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "Tinta.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {	
		texture.enable(gl);
        texture.bind(gl);
		
		gl.glRotated(90, 1, 0, 0);
		
		
		gl.glTranslated(0, topo, espessura);
		gl.glScaled(0.03, 0.04, 0.04);
		gl.glTranslated(0, -topo, -espessura);
		
		gl.glTranslated(145, -1870, -240);
		
		paintFromArray(gl, 0,4,3,2); //frente
		paintFromArray(gl, 0,5,8,4); //esquerda
		paintFromArray(gl, 5,6,7,8); //tras
		paintFromArray(gl, 2,3,7,6); //direita
		paintFromArray(gl, 0,2,6,5); //topo
		paintFromArray(gl, 3,4,8,7); //fundo
		paintFromArray(gl, 9,10,11,12); //bracoTr
		paintFromArray(gl, 13,14,15,16); //bracoTr 
		paintFromArray(gl, 12,11,15,14); //bracoD //red ok
		paintFromArray(gl, 9,13,16,10); //bracoE
		paintFromArray(gl, 9,12,14,13); //bracoTopo ok
		paintFromArray(gl, 11,10,16,15); //bracoBaixo
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
