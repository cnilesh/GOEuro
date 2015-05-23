import java.util.List;


public class LocationInfoDTO{
	private int _id;
	private String name;
	private String type;
	private String fullName;
	private int location_id;
	private boolean isEurope;
	private String countryCode;
	private boolean coreCountry;
	private int iataAirportCode;
	
	private Geoposition geo_position;

	public Geoposition getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(Geoposition geo_position) {
		this.geo_position = geo_position;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public boolean isEurope() {
		return isEurope;
	}

	public void setEurope(boolean isEurope) {
		this.isEurope = isEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public int getIataAirportCode() {
		return iataAirportCode;
	}

	public void getIataAirportCode(int iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	@Override
	public String toString() {
		return "LocationInfoDTO [_id=" + _id + ", name=" + name + ", type="
				+ type + ", fullName=" + fullName + ", location_id="
				+ location_id + ", isEurope=" + isEurope + ", countryCode="
				+ countryCode + ", coreCountry=" + coreCountry
				+ ", iataAirportCode=" + iataAirportCode + "]";
	}

}
