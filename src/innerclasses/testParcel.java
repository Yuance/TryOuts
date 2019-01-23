package innerclasses;

public class testParcel {
	private class PDestination implements Destination {
		private String label;
		PDestination(String s) {
			label = s;
		}
		public String readLabel() {
			return label;
		}
	}
	public Destination returnRef() {
		return (Destination) new PDestination("JE");
	}
	public PDestination downcast(Destination d) {
		return (PDestination) d;
	}
	
}