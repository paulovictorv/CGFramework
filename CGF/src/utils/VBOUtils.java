package utils;

import java.nio.FloatBuffer;

public class VBOUtils {
	public static FloatBuffer fromArray(float... fs){
		FloatBuffer fb = FloatBuffer.allocate(fs.length);
		
		for (int i = 0; i < fs.length; i++){
			fb.put(fs[i]);
		}
		
		return fb;
	}
}
