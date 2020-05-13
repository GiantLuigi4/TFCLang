package TLangJava.Math;

import java.util.HashMap;

public class Trig {
	static HashMap<Float, Double> cosMemory = new HashMap<>();
	static HashMap<Float, Double> sinMemory = new HashMap<>();
	static float _360_AS_RADIANS = (float) Math.toRadians(360);
	
	public static void prepMemoryCos(float precision) {
		cosMemory = new HashMap<>();
		for (float f = 0; f < _360_AS_RADIANS; f += precision) {
			cosMemory.put(f, Math.cos(f));
		}
	}
	
	public static double cos(float f) {
		if (cosMemory.containsKey(f % _360_AS_RADIANS)) {
			return cosMemory.get(f % _360_AS_RADIANS);
		}
		return Math.cos(f);
	}
	
	public static double cos(float f, boolean addToMemory) {
		if (cosMemory.containsKey(f % _360_AS_RADIANS)) {
			return cosMemory.get(f % _360_AS_RADIANS);
		}
		if (addToMemory) {
			cosMemory.put(f % _360_AS_RADIANS, Math.cos(f % _360_AS_RADIANS));
			return cosMemory.get(f % _360_AS_RADIANS);
		}
		return Math.cos(f);
	}
	
	public static void prepMemorySin(float precision) {
		sinMemory = new HashMap<>();
		for (float f = 0; f < 3; f += precision) {
			sinMemory.put(f, Math.sin(f));
		}
	}
	
	public static double sin(float f) {
		if (sinMemory.containsKey(f % _360_AS_RADIANS)) {
			return sinMemory.get(f % _360_AS_RADIANS);
		}
		return Math.sin(f);
	}
	
	public static double sin(float f, boolean addToMemory) {
		if (sinMemory.containsKey(f % _360_AS_RADIANS)) {
			return sinMemory.get(f % _360_AS_RADIANS);
		}
		if (addToMemory) {
			sinMemory.put(f % _360_AS_RADIANS, Math.sin(f % _360_AS_RADIANS));
			return sinMemory.get(f % _360_AS_RADIANS);
		}
		return Math.sin(f);
	}
}
