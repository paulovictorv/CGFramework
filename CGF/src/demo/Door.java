package demo;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellatorCallback;

import br.ufal.cg.AutoDrawnableObject;

public class Door extends AutoDrawnableObject{

	private int angle = 0;
	
	private int startList;
	
	public Door(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "Porta.jpg";
	}

	public void openDoor(){
		new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i<90; ++i){
					angle++; 
					try{
						Thread.sleep(100);
					}catch(Exception e){
					}
				}
			}
		}).start(); 
	}
	
	public void closeDoor() {
		new Thread(new Runnable(){
			public void run(){
				for(int i = 90; i>=0; --i){
					angle--; 
					try{
						Thread.sleep(100);
					}catch(Exception e){
					}
				}
			}
		}).start(); 
	}

	
	@Override
	public void selfDraw(GL2 gl) {
		GLU glu = new GLU();
		gl.glTranslatef(-.5f, 0, 0.2f);
		gl.glPushMatrix();
		gl.glColor3f(0.1f, 0.4f, 0.3f);
		gl.glTranslatef(6.5f, 0, 0);
		gl.glRotatef(-angle, 0, 0, 1);
		gl.glTranslatef(-6.5f, 0, 0);
		double door[][] = createPortalVertices(3f);
        gl.glColor3f(1f, 1f, 1f); //cinza porta
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glTexCoord3f(0, 0, 0);
			gl.glVertex3dv(door[0], 0);
			gl.glTexCoord3f(0, 1, 0);
			gl.glVertex3dv(door[1], 0);
			gl.glTexCoord3f(1, 1, 0);
			gl.glVertex3dv(door[12], 0);
			gl.glTexCoord3f(1, 0, 0);
			gl.glVertex3dv(door[13], 0);
		}
		gl.glEnd();
		
		gl.glColor3f(1f,1f,1f); //cinza porta
//		gl.glBegin(GL2.GL_TRIANGLE_FAN);
//		{
//			gl.glTexCoord3f(0, 0, 0);
//			gl.glVertex3dv(door[1], 0);
//			for (int i = 2; i < door.length - 2; i++){
//				gl.glTexCoord3f(i, i, 0);
//				gl.glVertex3dv(door[i], 0);
//			 }
//			gl.glTexCoord3f(1, 0, 0);
//			gl.glVertex3dv(door[12], 0);
//			
//		}
//		gl.glEnd();
		
		gl.glPopMatrix();
		gl.glTranslatef(9.5f, 0, 0);
		
		gl.glRotatef(180, 0, 0, 1);
		
		gl.glPushMatrix();
		gl.glColor3f(0.1f, 0.4f, 0.3f);
		gl.glTranslatef(6.5f, 0, 0);
		gl.glRotatef(angle, 0, 0, 1);
		gl.glTranslatef(-6.5f, 0, 0);
		
        gl.glColor3f(1f,1f,1f); //cinza porta
		gl.glBegin(GL2.GL_POLYGON);
		{
			gl.glTexCoord3f(0, 0, 0);
			gl.glVertex3dv(door[0], 0);
			gl.glTexCoord3f(0, 1, 0);
			gl.glVertex3dv(door[1], 0);
			gl.glTexCoord3f(1, 1, 0);
			gl.glVertex3dv(door[12], 0);
			gl.glTexCoord3f(1, 0, 0);
			gl.glVertex3dv(door[13], 0);
		}
		gl.glEnd();
		
//        gl.glColor3f(0.5f,0.5f,0.5f); //cinza porta
//		gl.glBegin(GL2.GL_TRIANGLE_FAN);
//		{
//			gl.glVertex3dv(door[1], 0);
//			for (int i = 2; i < door.length - 2; i++){
//				gl.glVertex3dv(door[i], 0);
//			 }
//			gl.glVertex3dv(door[12], 0);
//			
//		}
//		gl.glEnd();
		gl.glPopMatrix();
		
	}

	private double[][] createPortalVertices(float x_init) {
		double[][] arr = new double[14][3];

		float x_width = 3.5f;
		double arc_center = x_init + x_width / 2f;
		double z_height = 4d;
		double z_init = 0;
		arr[0] = new double[] { x_init + 1.75, 0.0, z_init };
		arr[1] = new double[] { x_init + 1.75, 0.0, z_init + z_height };

		// Semi circulo
		int cur_angle = 90;
		int num_vert = 10;
		float angleSum = cur_angle / num_vert;

		for (int i = 2; i < arr.length - 2; i++) {
			double x_pos = arc_center + x_width / 2f
					* Math.cos(Math.toRadians(cur_angle));
			double z_pos = z_init + z_height + x_width / 2f
					* Math.sin(Math.toRadians(cur_angle));

			arr[i] = new double[] { x_pos, 0.0, z_pos };
			cur_angle -= angleSum;
		}

		arr[12] = new double[] { x_init + x_width, 0.0, z_init + z_height };
		arr[13] = new double[] { x_init + x_width, 0.0, z_init };

		return arr;
	}
	class TessellCallBack implements GLUtessellatorCallback {
		private GL2 gl;
		private GLU glu;

		public TessellCallBack(GL2 gl, GLU glu) {
			this.gl = gl;
			this.glu = glu;
		}

		public void begin(int type) {
			gl.glBegin(type);
		}

		public void end() {
			gl.glEnd();
		}

		public void vertex(Object vertexData) {
			double[] pointer;
			if (vertexData instanceof double[]) {
				pointer = (double[]) vertexData;
				gl.glTexCoord2dv(calculateTexturePoint(pointer), 0);
				gl.glVertex3dv(pointer, 0);
				if (pointer.length == 6) {
					gl.glNormal3dv(pointer, 3);
				}
			}

		}

		public void vertexData(Object vertexData, Object polygonData) {
		}

		public void combine(double[] coords, Object[] data, //
				float[] weight, Object[] outData) {
		}

		public void combineData(double[] coords, Object[] data, //
				float[] weight, Object[] outData, Object polygonData) {
		}

		public void error(int errnum) {
			String estring;

			estring = glu.gluErrorString(errnum);
			System.err.println("Tessellation Error: " + estring);
			System.exit(0);
		}

		public void beginData(int type, Object polygonData) {
		}

		public void endData(Object polygonData) {
		}

		public void edgeFlag(boolean boundaryEdge) {
		}

		public void edgeFlagData(boolean boundaryEdge, Object polygonData) {
		}

		public void errorData(int errnum, Object polygonData) {
		}
	}
	
	private double[] calculateTexturePoint(double[] vertice) {
		double d_x = vertice[0] / 3.5;
		double d_z = vertice[2] / 3;

		return new double[] { d_x, d_z };
	}

}
