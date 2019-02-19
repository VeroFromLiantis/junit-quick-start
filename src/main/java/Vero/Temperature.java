package Vero;

public class Temperature {
	float value;
	float t;
		
	public float temp() {
		return 20;
	}
	
	public float getTemperature() {
		return t;
	}
	public void setTemperature(float t) {
		this.t = t;
	}

	public boolean isBoiling(float t){
		if (t > 100) {
			return true;	
		}
		return false;
	}
	
	public boolean isFreezing(float t) {
		if (t < 0) {
			return true;	
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(t);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temperature other = (Temperature) obj;
		if (Float.floatToIntBits(t) != Float.floatToIntBits(other.t))
			return false;
		return true;
	}

	
	
	

}
