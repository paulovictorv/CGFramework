package utils;

public class GeometryUtils {

	public static double[] calculateNormal(double[] p1, double[] p2, double[] p3) {
		double d = p2[0] - p1[0];
		double e = p2[1] - p1[1];
		double f = p2[2] - p1[2];

		double a = p3[0] - p1[0];
		double b = p3[1] - p1[1];
		double c = p3[2] - p1[2];

		double[] normal = { (b * f - c * e), (c * d - f * a), (a * e - d * b) };// 3

		double lenght = Math.pow(
				(normal[0] * normal[0] + normal[1] * normal[1] + normal[2]
						* normal[2]), 0.5);

		normal[0] = normal[0] / lenght;
		normal[1] = normal[1] / lenght;
		normal[2] = normal[2] / lenght;// Math.abs(normal[2] / lenght);

		return normal;
	}
}
