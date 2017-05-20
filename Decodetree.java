
public class Decodetree {
	private String value;
	private String code;
	
	Decodetree leftchild;
	
	Decodetree rightchild;
	
	
	public Decodetree(String value, String code){
		this.value=value;
		this.code=code;
	}
	public Decodetree(){}
	public Decodetree getRightchild() {
		return rightchild;
	}

	public void setRightchild(Decodetree rightchild) {
		this.rightchild = rightchild;
	}


	public Decodetree getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(Decodetree leftchild) {
		this.leftchild = leftchild;
	}
	
	
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
