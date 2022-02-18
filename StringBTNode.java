package project1;

public class BTNode  {

	// fields
	private String element;
	private BTNode parent;
	private BTNode left, right;
	
	
	public BTNode(String e, BTNode p, BTNode l, BTNode r) {
	
		element = e;
		parent = p;
		left = l;
		right = r;
	}
	
	public boolean hasLeft() {
		return (left != null);
	}
	
	public boolean hasRight() {
		return (right != null);
	}
	
	public boolean isExternal() {
		return (right == null && left == null);
	}
	
	public boolean isInternal() {
		return !isExternal();
	}
	
	public String element() { return element;}
	
	public void setLeft(BTNode l) { left = l; }
	
	public void setRight(BTNode r) { right = r; }
	
	public void setParent(BTNode p) { parent = p; }
	
	
	public BTNode left() { return left; }
	
	public BTNode right() { return right; }
	
	public BTNode parent() { return parent; }
	
}


