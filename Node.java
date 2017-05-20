


public class Node {
	
	private String value;
	private String encode_value;
	public String getEncode_value() {
		return encode_value;
	}

	public void setEncode_value(String encode_value) {
		this.encode_value = encode_value;
	}

	private Integer frequency;
	Node leftchild;
	Node rightchild;
	
	public Node(){}
	
	public Node(String value, Integer frequency){
		this.value = value;
		this.frequency = frequency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public void setleftchild(Node node){
		this.leftchild=node;
	}
	public void setrightchild(Node node){
		this.rightchild = node;
	}
	public Node getrightchild(){
		return rightchild;
	}
	public Node getleftchild(){
		return leftchild;
	}
	
	@Override
	public String toString(){
		return "value " + value + " Frequency" + frequency + "\n";
	}
	
}

