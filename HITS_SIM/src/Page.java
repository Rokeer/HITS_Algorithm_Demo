import java.util.ArrayList;


public class Page {

	/**
	 * @param args
	 */
	String name = "";
	double auth = 1;
	double hub = 1;
	ArrayList<Page> incomingNeighbors = new ArrayList<Page>();
	ArrayList<Page> outgoingNeighbors = new ArrayList<Page>();
	
	
	
	public Page(String name, double auth, double hub) {
		super();
		this.name = name;
		this.auth = auth;
		this.hub = hub;
	}
	public double getAuth() {
		return auth;
	}
	public void setAuth(double auth) {
		this.auth = auth;
	}
	public double getHub() {
		return hub;
	}
	public void setHub(double hub) {
		this.hub = hub;
	}
	public ArrayList<Page> getIncomingNeighbors() {
		return incomingNeighbors;
	}
	public void setIncomingNeighbors(ArrayList<Page> incomingNeighbors) {
		this.incomingNeighbors = incomingNeighbors;
	}
	public ArrayList<Page> getOutgoingNeighbors() {
		return outgoingNeighbors;
	}
	public void setOutgoingNeighbors(ArrayList<Page> outgoingNeighbors) {
		this.outgoingNeighbors = outgoingNeighbors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
