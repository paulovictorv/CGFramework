package demo;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellator;
import javax.media.opengl.glu.GLUtessellatorCallback;

import utils.GeometryUtils;
import br.ufal.cg.AutoDrawnableObject;

public class L1Wall extends AutoDrawnableObject {

	private GLU glu;
	private int startList;
	private float[] color = new float[] { 232f / 235f, 255f / 255f, 160f / 255f };
	private double wall_Height = 8;
	private double wall_Width = 33;

	public L1Wall(GL2 gl) {
		super(gl);
		initData();
	}

	private void initData() {
		glu = new GLU();
		/*
		 * jogl specific addition for tessellation
		 */
		TessellCallBack tessCallback = new TessellCallBack(gl, glu);

		double wall_Height = 8;
		double wall_Width = 33;

		double rect[][] = new double[][] { // [4][3] in C; reverse here
		{ 0, 0, 0.0 }, { wall_Width, 0, 0.0 },
				{ wall_Width, 0.0, wall_Height }, { 0, 0.0, wall_Height } };
		double[] normal = GeometryUtils.calculateNormal(rect[0], rect[1],
				rect[2]);
		double tri[][] = createPortalVertices(2.0f);
		double tri2[][] = createPortalVertices(6.0f);
		double tri3[][] = createPortalVertices(10.0f);
		double tri4[][] = createPortalVertices(14.0f);
		// double tri5[][] = createPortalVertices(17.0f);
		double rect_inn[][] = new double[][] { { 24, 0, 0.0 }, { 24, 0, 3.0 },
				{ wall_Width, 0.0, 3 }, { wall_Width, 0.0, 0 } };

		float y_translate = 0.5f;

		// gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		startList = gl.glGenLists(3);

		GLUtessellator tobj = GLU.gluNewTess();

		GLU.gluTessCallback(tobj, GLU.GLU_TESS_VERTEX, tessCallback);// glVertex3dv);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_BEGIN, tessCallback);// beginCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_END, tessCallback);// endCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_ERROR, tessCallback);// errorCallback);

		/* rectangle with triangular hole inside */
		gl.glNewList(startList, GL2.GL_COMPILE);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect.length; i++) {
			GLU.gluTessVertex(tobj, rect[i], 0, new double[] { rect[i][0],
					rect[i][1], rect[i][2], normal[0], normal[1], normal[2] });
		}
		// GLU.gluTessNormal(tobj, 0f, 1f, 0f);
		// GLU.gluTessVertex(tobj, rect[0], 0, rect[0]);
		// GLU.gluTessVertex(tobj, rect[1], 0, rect[1]);
		// GLU.gluTessVertex(tobj, rect[2], 0, rect[2]);
		// GLU.gluTessVertex(tobj, rect[3], 0, rect[3]);
		GLU.gluTessEndContour(tobj);

		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect_inn.length; i++) {
			GLU.gluTessVertex(tobj, rect_inn[i], 0, new double[] {
					rect_inn[i][0], rect_inn[i][1], rect_inn[i][2], normal[0],
					normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);

		GLU.gluTessBeginContour(tobj);

		// Todas as 5 aberturas.
		for (int i = 0; i < tri.length; i++) {
			// GLU.gluTessVertex(tobj, tri[i], 0, tri[i]);
			GLU.gluTessVertex(tobj, tri[i], 0, new double[] { tri[i][0],
					tri[i][1], tri[i][2], normal[0], normal[1], normal[2] });
		}
		for (int i = 0; i < tri2.length; i++) {
			GLU.gluTessVertex(tobj, tri2[i], 0, new double[] { tri2[i][0],
					tri2[i][1], tri2[i][2], normal[0], normal[1], normal[2] });
			// GLU.gluTessVertex(tobj, tri2[i], 0, tri2[i]);
		}
		for (int i = 0; i < tri3.length; i++) {
			GLU.gluTessVertex(tobj, tri3[i], 0, new double[] { tri3[i][0],
					tri3[i][1], tri3[i][2], normal[0], normal[1], normal[2] });
			// GLU.gluTessVertex(tobj, tri3[i], 0, tri3[i]);
		}
		for (int i = 0; i < tri4.length; i++) {
			GLU.gluTessVertex(tobj, tri4[i], 0, new double[] { tri4[i][0],
					tri4[i][1], tri4[i][2], normal[0], normal[1], normal[2] });
		}

		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		gl.glNewList(startList + 1, GL2.GL_COMPILE);

//		GeometryUtils.calculatePortalInside(gl, tri, y_translate, true);
//		GeometryUtils.calculatePortalInside(gl, tri2, y_translate, true);
//		GeometryUtils.calculatePortalInside(gl, tri3, y_translate, true);
//		GeometryUtils.calculatePortalInside(gl, tri4, y_translate, true);

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
		for (int i = 0; i < rect_inn.length; i++) {
			GLU.gluTessVertex(tobj, rect_inn[i], 0, new double[] {
					rect_inn[i][0], rect_inn[i][1], rect_inn[i][2], normal[0],
					normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		// Todas as 5 aberturas.
		for (int i = 0; i < tri.length; i++) {
			GLU.gluTessVertex(tobj, tri[i], 0, new double[] { tri[i][0],
					tri[i][1], tri[i][2], normal[0], normal[1], normal[2] });
		}
		for (int i = 0; i < tri2.length; i++) {
			GLU.gluTessVertex(tobj, tri2[i], 0, new double[] { tri2[i][0],
					tri2[i][1], tri2[i][2], normal[0], normal[1], normal[2] });
		}
		for (int i = 0; i < tri3.length; i++) {
			GLU.gluTessVertex(tobj, tri3[i], 0, new double[] { tri3[i][0],
					tri3[i][1], tri3[i][2], normal[0], normal[1], normal[2] });
		}
		for (int i = 0; i < tri4.length; i++) {
			GLU.gluTessVertex(tobj, tri4[i], 0, new double[] { tri4[i][0],
					tri4[i][1], tri4[i][2], normal[0], normal[1], normal[2] });
		}
		// for (int i = 0; i < rect_inn.length; i++) {
		// GLU.gluTessVertex(tobj, rect_inn[i], 0, new double[] {
		// rect_inn[i][0],
		// rect_inn[i][1], rect_inn[i][2], normal[0], normal[1], normal[2] });
		// }

		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		GLU.gluDeleteTess(tobj);

	}

	private double[][] createPortalVertices(float x_init) {
		double[][] arr = new double[14][3];

		float x_width = 1.5f;
		double arc_center = x_init + x_width / 2f;
		double z_height = 2d;
		double z_init = 1.5;
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

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
		texture.bind(gl);

		gl.glTranslatef(13.5f, 0f, 0.2f);
		gl.glRotatef(-90, 0f, 0f, 1f);
		//
		gl.glColor3fv(color, 0);
		gl.glCallList(startList);
		gl.glPushMatrix();
		gl.glTranslated(0f, -0.5f, 0f);
		gl.glCallList(startList + 1);
		gl.glPopMatrix();

		//
		// gl.glRotatef(180, 0f, 0f, 1f);
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

}
