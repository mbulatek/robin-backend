package com.robin.backend;

public class InsertingResult {
	boolean onTop;
	int place;
	
	public InsertingResult(boolean onTop, int place) {
		this.onTop = onTop;
		this.place = place;
	}
	
	public boolean getOnTop() {
		return onTop;
	}

	public void setOnTop(boolean onTop) {
		this.onTop = onTop;
	}
	
	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}
}
