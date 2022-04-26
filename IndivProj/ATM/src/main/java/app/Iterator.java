package app;

public interface Iterator {
	//This is the interface for the app.Iterator pattern.
		boolean hasNext(int position);
		Object next(int position);
		boolean hasPrev(int position);
	
}
