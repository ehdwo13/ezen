package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileRemoveHandler {
	//savePath, imageFileName
	private static final Logger log = LoggerFactory.getLogger(FileRemoveHandler.class);
	
	public int deleteFile(String savePath, String imageFileName) {
		//return type int => 삭제 여부 값을 리턴
		boolean isDel = false;	//삭제가 잘 되었는지 체크하는 변수
		log.info("del method 접근", imageFileName);
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThumbFile = new File(fileDir+File.separator+"_th_"+imageFileName);
		
		//파일이 존재해야 삭제
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
