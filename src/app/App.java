package app;

import circularList.CircularList;

public class App {

	public static void main(String[] args) {
		CircularList<String> listilla = new CircularList<String>();
		//listilla.addFirst("globos");
		listilla.addFirst("sus");
		//listilla.addFirst("y");
		//listilla.addFirst("Pepe");
		//listilla.addFirst("Don");
		listilla.remove("sus");
		listilla.print();
	}

}
