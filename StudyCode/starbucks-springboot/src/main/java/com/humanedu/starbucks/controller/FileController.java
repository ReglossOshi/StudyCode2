package com.humanedu.starbucks.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FileController {
	@GetMapping("/fileDownload")
	public String adminNoticeFileDownload(Model model) {
		return "fileDownload";
	}
	
	@GetMapping("/fileDelete")
	public String adminNoticeFileDelete(Model model) {
		return "fileDelete";
	}
}
