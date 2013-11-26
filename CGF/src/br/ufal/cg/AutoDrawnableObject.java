package br.ufal.cg;

import java.io.InputStream;

import javax.media.opengl.GL2;
import javax.media.opengl.GLProfile;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public abstract class AutoDrawnableObject {

	protected GL2 gl;

	protected Texture texture;

	public AutoDrawnableObject(GL2 gl) {
		this.gl = gl;
		loadTextures();
	}

	private void loadTextures() {
		try {
			InputStream stream = this.getClass().getClassLoader()
					.getResourceAsStream(getTextureImg());
			TextureData data = TextureIO.newTextureData(
					GLProfile.get(GLProfile.GL2), stream, false,
					getTextureExtension());
			texture = TextureIO.newTexture(data);
		} catch (Exception exc) {
			System.err
					.println("Nao foi possivel gerar as texturas para a Classe:"
							+ getTextureImg());
		}

	}

	/**
	 * Texture Extension.
	 * 
	 * E.g: "png" or "jpg"
	 * 
	 */
	protected abstract String getTextureExtension();

	/**
	 * Name of the image to be used for texture.
	 * 
	 * The Images must be in project classpath or sourcefolders
	 * 
	 * @return Name of image
	 */
	protected abstract String getTextureImg();

	/**
	 * Define here all JOGL commands for render this object.
	 * 
	 * E.g: gl.glVertex(); gl.glColor(); gl.glTexCoord() ...
	 * 
	 */
	public abstract void selfDraw(GL2 gl);

	void bindTexture() {
		if (texture == null)
			return;
		texture.bind(gl);
	}

	void unbindTexture() {
		if (texture == null)
			return;
		texture.disable(gl);
	}

}
