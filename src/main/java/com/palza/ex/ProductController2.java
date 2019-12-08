package com.palza.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.palza.ex.dao.IDao;
import com.palza.ex.dto.productDto;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ProductController2 {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping( "/form" )
	public String form() {
		return "form";
	}
	
	@RequestMapping( "/additemed" )
//	@ResponseBody
	public String upload(HttpServletRequest request,
			HttpSession session,
			Model model,			
			@RequestParam("file1") MultipartFile file,
			productDto dto) {
		dto.setImg(file.getOriginalFilename());
		dto.setRg_id((String) session.getAttribute("mId"));
		String url = fileUploadService.restore(file);
		dto.setImg(url);
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.additemDao(dto);
		
//		for(String str : dto.getHashtag().split(",")) {
//			dao.addTag(dto.getPd_id(), str);	
//		}
		return "redirect:main";
	}	
}