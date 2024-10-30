package vttp.batch5.sdf.task01;

public class CsvEntry {
    private int season;
	private int month;
	private boolean holiday;
	private int weekday;
	private int weather;
	private int totalCyclists;

	public int getSeason() {return season;}
    public void setSeason(int season) {this.season = season;}

	public int getMonth() {return month;}
	public void setMonth(int month) {this.month = month;}

	public boolean isHoliday() {return holiday;}
	public void setHoliday(boolean holiday) {this.holiday = holiday;}

	public int getWeekday() {return weekday;}
	public void setWeekday(int weekday) {this.weekday = weekday;}

	public int getWeather() {return weather;}
	public void setWeather(int weather) {this.weather = weather;}

	public int getTotalCyclists() {return totalCyclists;}
	public void setTotalCyclists(int totalCyclists) {this.totalCyclists = totalCyclists;}
		
	public CsvEntry(int season, int month, boolean holiday, int weekday, int weather, int totalCyclists) {
		this.season = season;
		this.month = month;
		this.holiday = holiday;
		this.weekday = weekday;
		this.weather = weather;
		this.totalCyclists = totalCyclists;
	}
    public String toString() {
        return "CsvEntry [season=" + season + ", month=" + month + ", holiday=" + holiday + ", weekday=" + weekday
                + ", weather=" + weather + ", totalCyclists=" + totalCyclists + "]";
    }
}
