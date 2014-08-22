import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Read input geo code from a .csv file.
 * */
public class ReadCSV extends Procedure{

	
	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.inputPath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");   

                if(item.length > 0){
                	myDB.rightArray.add(this.ParseCSV(item[item.length-1]));
//                	myDB.leftArray.add(this.ParseCSV(item[item.length-2]));
                }else{
                	System.out.println("Error: have to have at least 1 col");
                }
                
                /*
                 * Read all current data (cells)
                 * */
                GeoData tmpGdata = new GeoData();
                for(int i = 0; i < item.length; i++){
                	tmpGdata.curDivisionList.add(this.ParseCSV(item[i]));
                }
                myDB.geoDataList.add(tmpGdata);
                /*
                 * Number of years is how many columns in the data sheet.
                 * */
                myDB.nOfYears = item.length;
                
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
