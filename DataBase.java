import java.util.*;


public class DataBase {
	/*
	 * The most right ID arraylist, 
	 * we use it to generate UID
	 * */
	public ArrayList<String> rightArray;
	/*
	 * Generated UID, considered the blocking cases
	 * */
	public ArrayList<String> UIDArray;
	/*
	 * contains all current Data
	 * */
	public ArrayList<GeoData> geoDataList;
	
	public String inputPath;
	
	public String outputCSVPath;
	/*
	 * how many years of data we have.
	 * Which is how may columns in the sheet
	 * */
	public int nOfYears;
	//singulaton 
	private static DataBase myDataBase;
	
	/*
	 * Constructor, and config here.
	 */
	public DataBase(){	
		this.rightArray = new ArrayList<String>();
		this.UIDArray = new ArrayList<String>();
		this.geoDataList = new ArrayList<GeoData>();
	}
	/*
	 * pass parameters, which are the input and output paths.
	 * */
	public void SetPath(String inputPath, String outputPath){
		this.inputPath = inputPath;
		this.outputCSVPath = outputPath;
	}
	/*
	 * singulaton 
	 * */
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
	
}
