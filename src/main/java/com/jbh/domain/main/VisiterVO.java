package com.jbh.domain.main;

public class VisiterVO {

		private String status;
		private String country;
		private String countryCode;
		private String region;
		private String regionName;
		private String city;
		private float lat;
		private float lon;
		private String timezone;
		private String as;
		private String query;
		
		public void setStatus(String status) { this.status = status; }
		public void setCountry(String country) { this.country = country; }
		public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
		public void setRegion(String region) { this.region = region; }
		public void setCity(String city) { this.city = city; }
		public void setLat(float lat) { this.lat = lat; }
		public void setLon(float lon) { this.lon = lon; }
		public void setTimezone(String timezone) { this.timezone = timezone; }
		public void setRegionName(String regionName) { this.regionName = regionName; }
		public void setAs(String as) { this.as = as; }
		public void setQuery(String query) { this.query = query; }
		
		public String getStatus() { return this.status; }
		public String getCountry() { return this.country; }
		public String getCountryCode() { return this.countryCode; }
		public String getRegion() { return this.region; }
		public String getCity() { return this.city; }
		public float getLat() { return this.lat; }
		public float getLon() { return this.lon; }
		public float getLng() { return this.lon; }
		public String getTimezone() { return this.timezone; }
		public String getRegionName() { return this.regionName; }
		public String getAs() { return this.as; }
		public String getQuery() { return this.query; }
		
		public String toString() {
			return "VisiterVO [status="+this.status+", country="+this.country+", countryCode="+this.countryCode+
					", region="+this.region+", city="+this.city+", lat="+this.lat+", lon="+this.lon+
					", timezone="+this.timezone+", regionName="+this.regionName+", as="+this.as+", query="+this.query+"]";
		}

}
