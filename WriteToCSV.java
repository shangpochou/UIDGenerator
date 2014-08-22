import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;


public class WriteToCSV extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputCSVPath)); 
		/*
		 * Generate title, and
		 * we assume that the latest year is year 103
		 * */
		String tmpTitle = new String();
		
		for(int i = 0; i < myDB.nOfYears; i++){
			tmpTitle += this.WarpWithComma("Year"+ String.valueOf(103-i));
		}
		tmpTitle += this.WarpWithoutComma("UID");
				
		bw.write(tmpTitle);
		bw.newLine();
		
		for(int i = 0; i < myDB.geoDataList.size(); i++){
			String tmpLine = new String();
			GeoData curTmpData = myDB.geoDataList.get(i);
			for(int j = 0; j < curTmpData.curDivisionList.size(); j++){
				tmpLine += this.WarpWithCommaTab(curTmpData.curDivisionList.get(j));					
			}
			/*
			 * the index of UID should be same as the geo Data list
			 * */
			tmpLine += this.WarpWithoutCommaTab(myDB.UIDArray.get(i));
			bw.write(tmpLine);
			bw.newLine();
		}	
		bw.close();
	}
	
}
