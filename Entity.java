import java.util.*;

public class Entity {
	protected String type, name, path;
	protected int size;
	protected String content;
	// this contains all of entities with path and type as a string array for an easier access. I did not make another implementation for this particular data set.
	protected static ArrayList<String[]> allPaths = new ArrayList<String[]>();
	

	
	public void create(String newType, String newName, String newParent){
		

		newPath = newParent + "\" + newName;
		
		//path not found
		String[] noPathCheck1 = {newParent, "drive"};
		String[] noPathCheck2 = {newParent, "folder");
		String[] noPathCheck3 = {newParent, "zip");
		if (!allPaths.contains(noPathCheck1)) System.out.println("Error: path not found");
		if (!allPaths.contains(noPathCheck2)) System.out.println("Error: path not found");
		if (!allPaths.contains(noPathCheck3)) System.out.println("Error: path not found");
		
		//path already exists
		String[] pathCheck = {newPath, newType};
		if (allPaths.contains(pathCheck)) System.out.println("Error: path already exists");
		

		//Illegal File System Operation
		
		//if the parent is a text file name
		String[] textCheck = {newParent, "text"};
		if (allPaths.contains(textCheck) System.out.println("Error: Illegal File System Operation");		
			
		//can't create drives with a parent
		if (newType.equals("drive") && !newParent.equals("")) System.out.println("Error: Illegal File System Operation");
		//can't create folders, text files, zip files without a parent 
		if ((newType.equals("folder") || newType.equals("text") || newType.equals("zip")) && newParent.equals("") System.out.println("Error: Illegal File System Operation");
		

		
		type = newType;
		name = newName;
		path = newPath;

		String[] newFile = {newPath, type};
		allPaths.add(newFile);
	}
	
	public void addContent(String c){
		if (this.getType().equals("text")) content = c;
		else System.out.println("Error: cannot add content to non-text file");
	}
	public String getContent(){
		if (this.getType().equals("text")) return content;
		else System.out.println("Error: cannont delete content to non-text file");
	}
	
	public void deleteContent(){
		if (this.getType().equals("text")) content = "";
		else System.out.println("Error: cannont delete content to non-text file");
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public void setPath(String sPath){
		path = sPath;
	}
	
	public void delete(String path){
		//find a matching path and delete all entities whose parent is the path
		//path not found
		String directory;
		int count = 0;
		for (String[] e : allPaths){
			directory = e[0];
		    if (directory.indexOf(path) != -1) {
				allPaths.remove(e);
				count++;
			}
		}
		if (count == 0) System.out.println("Error: path not found");
		
	}
	
	
	public void move(String sPath, String dPath){
		String directory;
		int lastIndex = -1;
		int coutn = 0;
		String newPath = "";
		for (String[] e : allPaths){
			directory = e[0];
			newPath = "";
			if (directory.indexOf(sPath) != -1){
				count ++;
				lastIndex = directory.indexOf(sPath) + sPath.length();
				// replace dPath with sPath
				newPath = dPath + directory.substring(lastIndex + 1); 
				// change the path property to the destination path
				path = newPath
				// update allPaths arrayList
				e[0] = newPath;
				
			}
		}
		if (count == 0) System.out.println("Error: path not found");
	}
	
	public int getSize(){
		String directory;
		int size = 0;
		switch (this.getType()){
			case "text": return this.getContent().length();
			case "drive":  for(String[] e : allPaths) {
							directory = e[0];
							if (directory.indexOf(this.getName()) != -1){
								if(e[1].equals("text")) sum += e.getContent().length();
							}
			              }
						  return size;
			case "file":  for(String[] e : allPaths) {
							directory = e.[0];
							if (directory.indexOf(this.getName()) != -1){
								if(e[1].equals("text")) sum += e.getContent().length();
							}
			              }
						  return size;
			case "zip":  for(String[] e : contents) {
							directory = e[0];
							if (directory.indexOf(this.getName()) != -1){
								if(e[1].equals("text")) sum += e.getContent().length();
							}
			              }
						  return (int) size/2; //truncate since size is an integer
		}
	}
	
	public void writeToFile(String path, String content){
		if (this.getType().equals("text"){
			this.deleteContent();
			this.addContent(content);
		} else System.out.println("Error: path not found")
	}
	


	
}