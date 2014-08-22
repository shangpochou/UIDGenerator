import java.util.ArrayList;
/*
 * Generate UID based on the "big table"
 * 
 * The algorithm is as follows:
 * 
 * find the duplicated ID on the right most column, 
 * and base on the how many times it duplicated
 * adding prefix from lower case a to z.
 * 
 * So the duplicate number is at most 27.
 * If there are more than that,
 * we will add capital A, and print an error message.
 * */

public class UIDGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase myDB = DataBase.GetDataBase();
	
		myDB.SetPath(args[0], args[1]);
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
		ReadCSV myRCSV = new ReadCSV();
		myProcAL.add(myRCSV);
			
		GenerateUID myUIDG = new GenerateUID();
		myProcAL.add(myUIDG);
		
		WriteToCSV myWCSV = new WriteToCSV();
		myProcAL.add(myWCSV);
				
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
		
		
	}

}
