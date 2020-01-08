package Data_Structures;

public class vertex {
	private String label;

	vertex() {

	}

	vertex(String label) {
		this.label = label;
	}

	public void setVertexName(String label) {
		this.label = label;
	}
	public String getVertexName() {
		return label;
	}
}