import java.util.*;

public class GenerateUID extends Procedure{

	public void Task(){
		
		/*
		 * ID, index of this ID in right array and left array
		 * */
		Hashtable<String, Integer> IDHashTable = new Hashtable<String, Integer>();
		
		
		
		for(int i = 0; i < myDB.rightArray.size(); i++){
			/*
			 * already contains this ID
			 * */
			String curID = myDB.rightArray.get(i);
			if(IDHashTable.containsKey(curID)){
				/*
				 * the second ID should be 9 + the previous year's ID
				 * */
				/*
				 * Cast and make the prefix, which is as follows
				 * duplicate number 1, prefix = a
				 *                  2,          b
				 * and so on
				 * */
				char prefix;
				int dupNumber = IDHashTable.get(curID);
				/*
				 * if the duplicate number is greater than 26,
				 * we don't have enough lower case letter for prefix.
				 * So we will use 'A', and pop an error msg.
				 * */
				if(dupNumber < 27){
					prefix = (char)(dupNumber + 96);
				}else{
					prefix = 'A';
					System.out.println("duplicate number is greater than 26");
				}
				String tmp = prefix + myDB.rightArray.get(i);
				/*
				 * increment the duplicate number
				 * */
				IDHashTable.put(curID, IDHashTable.get(curID)+1);
//				System.out.println(curID + " " + IDHashTable.get(curID));
				myDB.UIDArray.add(tmp);
			}else{
				IDHashTable.put(curID, 1);
				myDB.UIDArray.add(curID);
			}
		}
		
	}
}
