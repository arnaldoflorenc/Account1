package entities;

public class Date {
	private int month;
	private int day;
	private int year;

	
	public Date() {
	}

	public Date(int month, int day, int year) {
		if (12 <= month || month <= 1) {
			throw new IllegalArgumentException(
					"Data digitada não existe");
		}

		if (year < 0) {
			throw new IllegalArgumentException(
					"SE MATA!!!!");
		}
		int maxDays = 0;

		boolean leapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
		
		switch (month) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			maxDays = 31;
			break;
		case 4:case 6:case 9: case 11:
			maxDays = 30;
			break;
		case 2:
			if(leapYear) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
		default:
			if(maxDays != 30 || maxDays != 31|| maxDays != 29 || maxDays != 28)
			throw new IllegalArgumentException(
					"Data digitada não existe");	
		}

		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return day +
			   "/" +
			   month +
			   "/" +
			   year;
	}
}
