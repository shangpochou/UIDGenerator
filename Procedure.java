public class Procedure {
	
	protected DataBase myDB;
	
	public void GetData(DataBase inputDB){
		this.myDB = inputDB;
	}
	public void Task(){
		
	}
	
	protected String ParseCSV(String inputString){
		String newString = inputString.replace('\t', ' ');
		newString = newString.replace('"', ' ');
		newString = newString.replace('-', ' ');
		newString = newString.replace(" ", "");
		return newString;
	}
	/*
	 * for writing data to .CSV files.
	 * And we add a tab in order to make the
	 * number begin with 0 shows correctly.
	 * */
	protected String WarpWithComma(String inputString){
		return '"' + inputString + '"' + ",";
	}
	protected String WarpWithoutComma(String inputString){
		return '"' + inputString + '"';
	}
	protected String WarpWithCommaTab(String inputString){
		return '"' + "\t" + inputString + '"' + ",";
	}
	protected String WarpWithoutCommaTab(String inputString){
		return '"' + "\t" + inputString + '"';
	}
}
