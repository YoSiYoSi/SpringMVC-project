package com.palza.ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
	// 由щ늼�뒪 湲곗��쑝濡� �뙆�씪 寃쎈줈瑜� �옉�꽦 ( 猷⑦듃 寃쎈줈�씤 /�쑝濡� �떆�옉�븳�떎. )
public class FileUploadService {
	// �쐢�룄�슦�씪硫� workspace�쓽 �뱶�씪�씠釉뚮�� �뙆�븙�븯�뿬 JVM�씠 �븣�븘�꽌 泥섎━�빐以��떎.
	// �뵲�씪�꽌 workspace媛� C�뱶�씪�씠釉뚯뿉 �엳�떎硫� C�뱶�씪�씠釉뚯뿉 upload �뤃�뜑瑜� �깮�꽦�빐 �넃�븘�빞 �븳�떎.
	private static final String SAVE_PATH = "C:/Users/YooSiYeon/eclipse-workspace2/palzaProject/src/main/webapp/resources/";
	private static final String PREFIX_URL = "C:/Users/YooSiYeon/eclipse-workspace2/palzaProject/src/main/webapp/resources/";
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			// �뙆�씪 �젙蹂�
			String originFilename = multipartFile.getOriginalFilename();
			String extName
				= originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			// �꽌踰꾩뿉�꽌 ���옣 �븷 �뙆�씪 �씠由�
			String saveFileName = genSaveFileName(extName);
			
			System.out.println("originFilename : " + originFilename);
			System.out.println("extensionName : " + extName);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		}
		catch (IOException e) {
			// �썝�옒�씪硫� RuntimeException �쓣 �긽�냽諛쏆� �삁�쇅媛� 泥섎━�릺�뼱�빞 �븯吏�留�
			// �렪�쓽�긽 RuntimeException�쓣 �뜕吏꾨떎.
			// throw new FileUploadException();	
			throw new RuntimeException(e);
		}
		return url;
	}
	
	
	// �쁽�옱 �떆媛꾩쓣 湲곗��쑝濡� �뙆�씪 �씠由� �깮�꽦
	private String genSaveFileName(String extName) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;
		
		return fileName;
	}
	
	
	// �뙆�씪�쓣 �떎�젣濡� write �븯�뒗 硫붿꽌�뱶
	private boolean writeFile(MultipartFile multipartFile, String saveFileName)
								throws IOException{
		boolean result = false;

		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.close();
		
		return result;
	}
}