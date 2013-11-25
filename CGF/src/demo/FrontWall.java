package demo;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellator;
import javax.media.opengl.glu.GLUtessellatorCallback;

import utils.GeometryUtils;
import br.ufal.cg.AutoDrawnableObject;

public class FrontWall extends AutoDrawnableObject {

	private GLU glu;
	private int startList;
	private double wall_Height = 8;
	private double wall_Width = 33;

	public FrontWall(GL2 gl) {
		super(gl);
		initData();
	}

	private void initData() {
		glu = new GLU();
	
		TessellCallBack tessCallback = new TessellCallBack(gl, glu);

		double wall_Height = 8;
		double wall_Width = 20;

		double rect[][] = new double[][] { // [4][3] in C; reverse here
		{ 0, 0, 0.0 }, { 10, 0, 0.0 },
				{ 10, 0.0, wall_Height }, { 0, 0.0, wall_Height } };
		double[] normal = GeometryUtils.calculateNormal(rect[0], rect[1],
				rect[2]);

		double door[][] = createPortalVertices(3f);
		
		startList = gl.glGenLists(3);

		GLUtessellator tobj = GLU.gluNewTess();

		GLU.gluTessCallback(tobj, GLU.GLU_TESS_VERTEX, tessCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_BEGIN, tessCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_END, tessCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_ERROR, tessCallback);

		gl.glNewList(startList, GL2.GL_COMPILE);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect.length; i++) {
			GLU.gluTessVertex(tobj, rect[i], 0, new double[] { rect[i][0],
					rect[i][1], rect[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		
		GLU.gluTessBeginContour(tobj);
			for (int i = 0; i < door.length; i++) {
	            GLU.gluTessVertex(tobj, door[i], 0, new double[] { door[i][0],
	            		door[i][1], door[i][2], normal[0], normal[1], normal[2] });
	    }
		GLU.gluTessEndContour(tobj);
		
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		gl.glNewList(startList + 1, GL2.GL_COMPILE);
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, 0.0f, 8f);
		gl.glRotatef(90f, 1f, 0f, 0f);
		gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glVertex3f(0, 0, 0);
				gl.glVertex3f(5, 4, 0);
				gl.glVertex3f(10, 0, 0);
				gl.glEnd();
			}
		gl.glPopMatrix();
	
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, 0.5f, 8f);
		gl.glRotatef(90f, 1f, 0f, 0f);
		gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glVertex3f(0, 0, 0);
				gl.glVertex3f(5, 4, 0);
				gl.glVertex3f(10, 0, 0);
				gl.glEnd();
			}
		gl.glPopMatrix();
	
		
		gl.glEndList();

		normal[1] = -normal[1];
		gl.glNewList(startList + 2, GL2.GL_COMPILE);
		GLU.gluTessBeginPolygon(tobj, null);

		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect.length; i++) {
			GLU.gluTessVertex(tobj, rect[i], 0, new double[] { rect[i][0],
					rect[i][1], rect[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);

		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < door.length; i++) {
            GLU.gluTessVertex(tobj, door[i], 0, new double[] { door[i][0],
            		door[i][1], door[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		GLU.gluDeleteTess(tobj);

	}


	@Override
	public void selfDraw(GL2 gl) {
		gl.glTranslatef(-0.5f, 0f, 0.2f);
		gl.glCallList(startList);
		
		gl.glPushMatrix();
		gl.glTranslated(0f, -0.5f, 0f);
		gl.glCallList(startList + 1);
		gl.glPopMatrix();

		gl.glTranslatef(0f, -0.5f, 0f);
		gl.glCallList(startList + 2);

	}

	@Override
	protected String getTextureImg() {
		return "FrontWall.jpg";
	}

	private double[] calculateTexturePoint(double[] vertice) {
		double d_x = vertice[0] / wall_Width;
		double d_z = vertice[2] / wall_Height;

		return new double[] { d_x, d_z };
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

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	private double[][] createPortalVertices(float x_init) {
		double[][] arr = new double[14][3];

		float x_width = 3.5f;
		double arc_center = x_init + x_width / 2f;
		double z_height = 3d;
		double z_init = 0;
		arr[0] = new double[] { x_init, 0.0, z_init };
		arr[1] = new double[] { x_init, 0.0, z_init + z_height };

		// Semi circulo
		int cur_angle = 180;
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
	
	
}
