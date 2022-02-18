package project1;

public class PhytreeTest {
	public  static void main (String [] args) {
		
		String[]labelsa = {"A","B","C","D","E","F","G"};
		double[][]distancesa = {{100,100,100,100,100,100,100},
		                        {19,100,100,100,100,100,100},
		                        {27,31,100,100,100,100,100},
		                        {8,18,26,100,100,100,100},
		                        {33,36,41,31,100,100,100},
		                        {18,1,32,17,35,100,100},
		                        {13,13,29,14,28,12,100}};
		
		String[]labelsb = {"A","B","C","D","E"};
		double[][]distancesb = {{100,100,100,100,100},
								{.55,100,100,100,100},
								{.54,.43,100,100,100},
								{.87,.81,.80,100,100},
								{.91,.85,.84,.45,100} };
		
		phytree testtree = new phytree();
		String view = testtree.createtree(labelsa, distancesa);
		System.out.print(view);
	}

	
	}

