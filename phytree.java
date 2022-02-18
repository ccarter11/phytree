package project1;

//creates a phylogenetic tree based on an array of species labels and 2d array of genetic differences
//species of interest(soi) 1 , 2 : a quick way to refer to each of the species being merged. Determined by lowest genetic difference. 
public class phytree{
	//private new String[] names;  
	

	int d1;  //soi 1 index
	int d2;  //soi 2 index
	double a1;  // soi 1 value 
	double a2;  // soi 2 value 
	double avg; // average a1,a2
	String stor; // temporary storage when switching elements in a string array 
	double dstor;// temporary storage when switching elements in a double array
	BTree tstor; // temporary storage when switching elements in a BTree array
	 
	
	
	public String createtree(String[]names , double[][]distances ){ 
		
		
		
		int n = names.length;  //n starts at number of species 
	
		 BTree[]leaves = new BTree[n]; 
	
	
		for(int i=0; i<n; i++ ) {   // for value in names 
							     //create tree 
			String T = names[i];
			BTNode tnode = new BTNode(T,null,null,null);
			leaves[i] = new BTree( tnode); 
			
		}
	
		while (n > 1){
			
			
	
			//find min/max distance
			double min = 100;  //averages wont always be int even if initial values are  
			for (int i = 0; i<n; i++){
				for(int j= 0 ; j <n; j++){
					if(distances[i][j] < min){ 
						min = distances[i][j];
						d1 = i   ; //d2<d1 
						d2 = j ;
					}
				}
			}
					
					
				
			// merge trees d1 and d2 from tree array
			
			String merged = names[d2] + names[d1];
			
			names[d2] = merged;
			int key = n - d1-1;   // the length from d1 to the end of names array 
			//String stor; 
			int x = 0;
			while (key>0) {    
				stor = names[d1 + x];
				names[d1+x] = names[d1+x+1];
				names[d1+x+1] = stor;
				key-- ;
				x++;
			}
			BTNode parent = new BTNode(merged, null  ,null, null);  //create parent node for tree attach
			leaves[d2] = BTree.attach(  parent,  leaves[d2], leaves[d1]);  //  need n-1 nodes that arent leaves
			
			//now leaves[d2] is merged tree of d2 and d1 
			
			//"remove" d1 from leaves,,, shift everything after one spot to the left
			
			int key1 = n - d1-1 ;  // the length from d1 to the end of leaves array 
			//String stor; 
			int y = 0;
			while (key1>0) {    
				tstor = leaves[d1 + y];
				leaves[d1+y] = leaves[d1+y+1];
				leaves[d1+y+1] = tstor;
				key1-- ;
				y++;
			}    //d1 now at end of array, order maintained
		 
		 
			// average values belonging to d1 and d2 
			int count = 0 ; 
			while (count<n){ 
				if(count != d1 && count != d2){ //for each species not an soi, average its differences compared to soi 1 and 2
					if (count< d1)  // d2<d1 for current input format
						a1 = distances[d1][count];
					else 
						a1 = distances[count][d1]; 
			
					if (count < d2)
						a2 = distances[d2][count];
					else 
						a2 = distances[count][d2];
				
					avg = (a1 + a2) / 2 ;
				
					if (count < d2)
						distances[d2][count] = avg ; 
					else 
						distances[count][d2] = avg ;
				}
			
			
			
				count++ ;
			} 
		
			// shrink distances array
			int key2 = n - d1-1;
			x = 0;
			while (key2>0) {
				for( int i = 0 ; i<n ; i++){  // shift d1 down row down one each iteration 
					dstor = distances[d1 + x][i];
					distances[d1+x][i] = distances[d1+x+1][i];
					distances[d1+x+1][i] = dstor;
				}
			 
			 
				for( int i = 0 ; i<n ; i++){  // shift d1 right column right 1 each iteration 
					dstor = distances[i][d1+x];
					distances[i][d1+x] = distances[i][d1+x+1];
					distances[i][d1+x+1] = dstor; 
				}
			
				key2-- ;
				x++;
			}
			n--;   // two species have been merged, number of species to be worked with decreased by 1 
		}
		return leaves[0].printPostfix(leaves[0].root());
	
		
	}
	
} 


	
	
	