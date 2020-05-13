package TLangJava.Math;

public class TwoNumberObject {
	public float i1;
	public float i2;
	
	public TwoNumberObject(float i1, float i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TwoNumberObject) {
			TwoNumberObject other = (TwoNumberObject) obj;
			return (((other.i1 == i1) && (other.i2 == i2)));
		}
		return super.equals(obj);
	}
}
