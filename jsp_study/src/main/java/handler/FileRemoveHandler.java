package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileRemoveHandler {
	private static final Logger log = LoggerFactory.getLogger(FileRemoveHandler.class);
	
	public int deleteFile(String savePath, String imageFileName) {
		boolean isDel = false;	
		log.info("del method 접근", imageFileName);
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThumbFile = new File(fileDir+File.separator+"_th_"+imageFileName);
		
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete();
			log.info("fileRemove > {}",isDel);
			if(isDel) {
				isDel = removeThumbFile.delete();
				log.info("fileThumbRemove > {}",isDel);
			}
		}
		return isDel? 1 : 0;
	}
}
