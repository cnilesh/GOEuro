import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Iterator;
import java.util.List;


public class WriteToCSV {
	
	private static final String COMMA_DELIMITER = ",";
	
	private static final String NEW_LINE_SEPARATOR = "\n";

	 private static final String FILE_HEADER = "id,name,type,latitude,longitude";

	public boolean writeToCsv(List<LocationInfoDTO> location,List<Geoposition> geo_pos,String fileName){
		
		FileWriter fileWriter = null;
		
		try{
			
			fileWriter = new FileWriter(fileName);

			fileWriter.append(FILE_HEADER.toString());
			
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			Iterator it = location.iterator();
			
			while(it.hasNext()){
				LocationInfoDTO locParams = (LocationInfoDTO) it.next();
				
				fileWriter.append(String.valueOf(locParams.get_id()));
				
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append(locParams.getName());
				
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append(locParams.getType());
				
				fileWriter.append(COMMA_DELIMITER);
				
				Iterator it1 = geo_pos.iterator();
				
				while(it1.hasNext()){
				
					Geoposition geoParams = (Geoposition) it1.next();
					
					fileWriter.append(String.valueOf(geoParams.getLatitude()));
					
					fileWriter.append(COMMA_DELIMITER);
					
					fileWriter.append(String.valueOf(geoParams.getLongitude()));
					
					break;
				}
				
				fileWriter.append(NEW_LINE_SEPARATOR);
				
			}

			return true;
		}catch(Exception e){
			System.out.println("Some problem occured");
			e.printStackTrace();
			return false;
		}finally {
			try {
			
			                fileWriter.flush();
			
			                fileWriter.close();
			
			            } catch (IOException e) {
			
			                System.out.println("Error while flushing/closing fileWriter !!!");
			
			                e.printStackTrace();
			                
			                return false;
			
			            }

		
		
	}
	}
}

