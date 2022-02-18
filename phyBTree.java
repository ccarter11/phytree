package project1;

public class BTree {

	// field
	private int size;
	private BTNode root;
	
	
	public BTree() {
		size = 0;
		root = null;
	}

	public BTree(BTNode r) {
		size = 1;
		root = r;
	}
	
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public int size() { return size; }
	
	public BTNode root() { return root;}
	
	public boolean isExternal(BTNode v) {
		return !(v.hasLeft() || v.hasRight());
	}
	
	public boolean isInternal(BTNode v) {
		return !isExternal(v);
	}
	
	public BTNode left(BTNode v) {
		return v.left();
	}
	
	public BTNode right(BTNode v) {
		return v.right();
	}
	
	public BTNode parent(BTNode v) {
		return v.parent();
	}
	
	public BTNode addRoot(String e) {
		// error condition?
		BTNode newroot = new BTNode(e, null, null, null);
		root = newroot;
		size++;
		return newroot;
	}
	
	public BTNode insertLeft(BTNode v, String e) {
		
		// care about error condition?
		BTNode newnode = new BTNode(e, v, null, null);
		v.setLeft(newnode);
		size++;
		return newnode;
	}

	public BTNode insertRight(BTNode v, String e) {
		
		// care about error condition?
		BTNode newnode = new BTNode(e, v, null, null);
		v.setRight(newnode);
		size++;
		return newnode;
	}


	public static BTree attach(BTNode v, BTree t1, BTree t2) {
		int newsize = t1.size() + t2.size() + 1;
		BTree returntree = new BTree(v);
		BTNode r1 = t1.root();
		BTNode r2 = t2.root();
		
		v.setLeft(r1);
		r1.setParent(v);
		v.setRight(r2);
		r2.setParent(v);
		
		returntree.size = newsize;
		
		return returntree;
	
	}


	public String printPostfix(BTNode v) {
	
		String str = "";
		
		// left, right, then self
		if (v.hasLeft())
			str += printPostfix(v.left());
		if (v.hasRight())
			str += printPostfix(v.right());
			
		str = str + v.element() + " ";
	
		return str;
	
	}
	
	public float evalPostfix(BTNode v) {
	
		if (v.isExternal())
			return Float.parseFloat(v.element().toString());
		else {
			// must have both children
			float a = evalPostfix(v.left());
			float b = evalPostfix(v.right());
			
			// operation
			String op = v.element().toString();
			if (op.compareTo("+")==0)
				return a + b;
			else if (op.compareTo("-")==0)
				return a - b;
			else if (op.compareTo("*")==0)
				return a * b;
			else
				return a / b;
		
		}
	}
}



