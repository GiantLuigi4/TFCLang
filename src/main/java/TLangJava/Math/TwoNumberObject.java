package TLangJava.Math;

public class TwoNumberObject {
	public float i1;
	public float i2;
	
	public TwoNumberObject(float i1, float i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	
	@Override
	public String toString() {
		return "TwoNumberObject{" +
				"i1=" + i1 +
				", i2=" + i2 +
				'}';
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
}
