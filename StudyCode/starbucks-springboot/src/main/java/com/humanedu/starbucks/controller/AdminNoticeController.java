package com.humanedu.starbucks.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humanedu.starbucks.domain.FreeBoardVO;
import com.humanedu.starbucks.service.FreeBoardService;

import java.io.File;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j
public class AdminNoticeController {
	
	@Autowired
	private FreeBoardService freeBoardService;

	@GetMapping("/adminNoticeList")
	public String adminNoticeList(
			@RequestParam(value = "search", required = false) String search,
			Model model) {
		List<FreeBoardVO> freeBoardVOList = freeBoardService.getFreeBoardList(search);
		
		model.addAttribute("freeBoardVOList", freeBoardVOList);
		model.addAttribute("search", search);
		return "adminNotice";
	}
	
	@GetMapping("/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "adminNoticeInsertForm";
	}
	
	@PostMapping("/adminNoticeInsert")
	public String adminNoticeInsert(
			MultipartFile[] fileContent, 
			@RequestParam("korname") String korname, 
			@RequestParam("title") String title, 
			@RequestParam("content") String content, 
			RedirectAttributes rttr) {
		// 파일 업로드 추가 처리
		String uploadFolder="C:\\Users\\human-01\\Desktop\\StudyCode\\starbucks-springboot\\src\\main\\resources\\static\\upload-files";
		
		
		List<String> fileNameArray = new ArrayList<>();
		for (MultipartFile multipartFile : fileContent) {
			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
			
			fileNameArray.add(multipartFile.getOriginalFilename());
			
			// 실제 위의 uploadFolder위치에 파일 저장
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for
		//실제 DB에 텍스트 데이터 저장
		int rtn = freeBoardService.insertFreeBoard(korname, title, content, fileNameArray);
		rttr.addFlashAttribute("insertSuccessCount",rtn);
		
		return "redirect:/adminNoticeList";
	}
	
	@GetMapping("/adminNoticeUpdateForm")
	public String adminNoticeUpdateForm(@RequestParam("num") int num, Model model) {
		List<FreeBoardVO> freeBoardVOList = freeBoardService.getUpdateFreeBoard(num);
		model.addAttribute("freeBoardVO", freeBoardVOList);
		model.addAttribute("num", num);
		return "adminNoticeUpdateForm";
	}
	
//	@PostMapping("/adminNoticeUpdate")
//	public String adminNoticeUpdate() {
//		// 파일 업로드 수정 처리
//		
//		return "adminNoticeUpdate";
//	}
	
	@PostMapping("/adminNoticeUpdate")
	public String adminNoticeUpdate(
			MultipartFile[] fileContent, 
			Model model,
			@RequestParam("num") int num,
			@RequestParam("korname") String korname, 
			@RequestParam("title") String title, 
			@RequestParam("content") String content,
			@RequestParam("filePrev1") String filePrev1,
			@RequestParam("filePrev2") String filePrev2,
			RedirectAttributes rttr) {
		// 파일 업로드 추가 처리
		String uploadFolder="C:\\Users\\human-01\\Desktop\\StudyCode\\starbucks-springboot\\src\\main\\resources\\static\\upload-files";
		
		
		
		if (filePrev1 != null) {
			// 실제 첨부파일1 삭제
			File file = new File(uploadFolder + "\\" + filePrev1);
			if (file.exists()) {
				file.delete();
			}
		}
		if (filePrev2 != null) {
			// 실제 첨부파일2 삭제
			File file = new File(uploadFolder + "\\" + filePrev2);
			if (file.exists()) {
				file.delete();
			}
		}
		List<String> fileNameArray = new ArrayList<>();
		for (MultipartFile multipartFile : fileContent) {
//			log.info("-------------------------------------");
//			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//			log.info("Upload File Size: " + multipartFile.getSize());
			
			fileNameArray.add(multipartFile.getOriginalFilename());
			
			// 실제 위의 uploadFolder위치에 파일 저장
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} // end for
		
		System.out.println(fileNameArray.get(0));
		
		int rtn = freeBoardService.updateFreeBoard(num, korname, title, content, fileNameArray);
		
		model.addAttribute("fileContentArray",fileNameArray);
		rttr.addFlashAttribute("updateSuccess",rtn);
		
		return "redirect:/adminNoticeList";
	}
	
	
	@PostMapping("/adminNoticeDelete")
	public String adminNoticeDelete(
			@RequestParam("num") int num,
			@RequestParam("file1") String file1Path,
			@RequestParam("file2") String file2Path,
			RedirectAttributes rttr) {
		
		String uploadFolder="C:\\Users\\human-01\\Desktop\\StudyCode\\starbucks-springboot\\src\\main\\resources\\static\\upload-files";
		List<FreeBoardVO> freeBoardVOList = freeBoardService.getFreeBoardList(null);
		
		int file1sum = 0;
		int file2sum = 0;
		
		for(int i=0;i<freeBoardVOList.size();i++) {
			if(file1Path.equals(freeBoardVOList.get(i).getFile1Path())) {
				System.out.println((i+1)+"번 파일 1번 같음");
				file1sum++;
			}
			if(file2Path.equals(freeBoardVOList.get(i).getFile2Path())) {
				System.out.println("파일 2번 같음");
				file2sum++;
			}
		}
		
		if (file1Path != null && file1sum>1) {
			// 실제 첨부파일1 삭제
			File file = new File(uploadFolder + "\\" + file1Path);
			if (file.exists()) {
				file.delete();
			}
		}
		if (file2Path != null && file2sum>1) {
			// 실제 첨부파일2 삭제
			File file = new File(uploadFolder + "\\" + file2Path);
			if (file.exists()) {
				file.delete();
			}
		}
//		
//		
//		int rtn = freeBoardService.deleteFreeBoard(num);
//		rttr.addFlashAttribute("num",rtn);
		
		return "redirect:/adminNoticeList";
	}
	
//	//GET, POST 다 쓰기
//	@RequestMapping(value = "/adminNoticeDelete", method = {RequestMethod.GET, RequestMethod.POST})
//	public String adminNoticeDeleteTest(@RequestParam("num") int num, RedirectAttributes rttr) {
//		int rtn = freeBoardService.deleteFreeBoard(num);
//
//		rttr.addFlashAttribute("deleteSuccessCount", rtn);
//
//		return "redirect:/adminNoticeList";
//	}
}
