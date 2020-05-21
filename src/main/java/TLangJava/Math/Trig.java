package TLangJava.Math;

import TLangJava.Lists.HashList;

import java.util.HashMap;

public class Trig {
	static HashMap<Float, Double> cosMemory = new HashMap<>();
	static HashMap<Float, Double> sinMemory = new HashMap<>();
	static HashList<TwoNumberObject, Double> atan2Memory = new HashList<>();
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
	
	public static void prepMemoryAtan2(float precision) {
		atan2Memory = new HashList<>();
//		for (float f = 0; f < 1; f += precision) {
//			for (float f2 = 0; f < 1; f += precision) {
//				atan2Memory.put(new TwoNumberObject(f,f2), Math.atan2(f,f2));
//			}
//		}
	}
	
	public static double atan2(float f, float f2) {
		if (atan2Memory.containsKey(new TwoNumberObject(f, f2))) {
			return atan2Memory.get(new TwoNumberObject(f, f2));
		}
		return Math.atan2(f, f2);
	}
	
	public static double atan2(float f, float f2, boolean addToMemory) {
		TwoNumberObject obj = new TwoNumberObject(f, f2);
		if (atan2Memory.containsKey(obj)) {
//			Main.TLangDebug.print(LogLevel.WARN,"Key:"+obj);
//			Main.TLangDebug.print(LogLevel.WARN,"Result:"+atan2Memory.get(obj));
//			Main.TLangDebug.print(LogLevel.WARN,"Correct:"+Math.atan2(obj.i1,obj.i2));
			return atan2Memory.get(obj);
		}
		if (addToMemory) {
			atan2Memory.put(obj, Math.atan2(f, f2));
			try {
				return atan2Memory.get(obj);
			} catch (Exception err) {
//				Main.TLangDebug.print(LogLevel.WARN,"Size:"+atan2Memory.size());
//				Main.TLangDebug.print(LogLevel.WARN,"NewestKey:"+atan2Memory.keySet().get(atan2Memory.keySet().size()-1));
//				Main.TLangDebug.print(LogLevel.WARN,"LatestKey"+(new TwoNumberObject(f,f2)));
			}
		}
		return Math.atan2(f, f2);
	}
}
