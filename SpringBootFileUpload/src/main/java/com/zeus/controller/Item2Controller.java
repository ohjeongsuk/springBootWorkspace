package com.zeus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item2;
import com.zeus.service.Item2Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Item2Controller {

	@Autowired
	private Item2Service service;

	@Value("${upload.path}")
	private String uploadPath;

	// File upload 화면 요청
	@RequestMapping(value = "/item2/insertForm", method = RequestMethod.GET)
	public String item2InsertForm(Item2 item, Model model) throws Exception {
		model.addAttribute("item",item);
		return "item2/insertForm";
	}

	// File upload 데이터베이스에 저장요청
	// File을 어떻게 저장할것인가?
	@RequestMapping(value = "/item2/insert", method = RequestMethod.POST)
	public String item2Insert(Item2 item, Model model) throws Exception {
		
		// 1. fileupload, 파일을 가져온다.
		List<MultipartFile> fileList = item.getPictures();
		
		int count = 0;
		for (MultipartFile file : fileList) {
			// 2. upload한 파일정보를 로그에 출력한다.
			log.info("원래파일명: " + file.getOriginalFilename());
			log.info("파일크기: " + file.getSize());
			log.info("파일타입: " + file.getContentType());

			// 파일명에 중복되지 않는 파일명을 만들고, 그 파일에 원본파일 내용을 복사하고, 중복되지 않는 파일명을 리턴받음
			String createFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			if (count == 0) {
				// 7c547e42-3079-4b58-bf91-33fc7d139cfc_홍길동.jpg
				item.setPictureUrl(createFileName);
			}else {
				// 7c547e42-3079-4b58-bf91-33fc7d139cfc_홍길동.jpg
				item.setPictureUrl2(createFileName);
			}
			count++;
			
		}

		// item 테이블에 업로드 정보를 저장
		boolean result = service.insert(item);
		if (result == false) {
			return "item2/fail";
		}
		return "item2/success";
	}

	// File upload list 요청
	@RequestMapping(value = "/item2/list", method = RequestMethod.GET)
	public String item2List(Item2 item, Model model) throws Exception {
		List<Item2> list = service.list();
		model.addAttribute("list", list);
		return "item2/list";
	}

	// File upload 삭제화면 요청
	@RequestMapping(value = "/item2/deleteForm", method = RequestMethod.GET)
	public String item2DeleteForm(Item2 item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item2/deleteForm";
	}

	// File upload 삭제 요청
	@RequestMapping(value = "/item2/delete", method = RequestMethod.POST)
	public String item2Delete(Item2 item, Model model) throws Exception {
		// 1. 삭제할 외장스토리지 저장되어 있는 테이블에서 가져온다.
		item = service.select(item);
		
		// 2. 테이블에 저장된 두개이미지 파일명을 가져와서 스토리지 삭제하는 기능
		for (int i = 0; i < 2; i++) {
			String createFileName = (i == 0) ? item.getPictureUrl() : item.getPictureUrl2();
			if (createFileName != null) {
				File file = new File(uploadPath + File.separator + createFileName);
				if (file.exists() == true) {
					file.delete();
				}
			}
		}

		boolean result = service.delete(item);
		if (result == true) {
			return "item2/success";
		} else {
			return "item2/fail";
		}

	}

	@RequestMapping(value = "/item2/updateForm", method = RequestMethod.GET)
	public String item2UpdateForm(Item2 item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item2/updateForm";
	}

	@RequestMapping(value = "/item2/update", method = RequestMethod.POST)
	public String item2Update(Item2 item, Model model) throws Exception {
		// 1. 사용자가 선택한 파일객체를 가져오고, 기존에 있는 중복되지않는 이미지파일명을 가져온다.
		List<MultipartFile> fileList = item.getPictures();
		String oldFileName = null;
		
		int count = 0;
		for (MultipartFile file : fileList) {
			if (file != null && file.getSize() > 0) {
				// 파일명에 중복되지 않는 파일명을 만들고, 그 파일에 원본파일 내용을 복사하고, 중복되지 않는 파일명을 리턴받음
				String createFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
				// 2. 사용자가 새로운 파일을 선택했는지 점검(기존의 파일을 스토리지에서 제거)
				// 7c547e42-3079-4b58-bf91-33fc7d139cfc_홍길동.jpg
				if (count == 0) {
					oldFileName = item.getPictureUrl();
					item.setPictureUrl(createFileName);
				}else if (count == 1) {
					oldFileName = item.getPictureUrl2();
					item.setPictureUrl2(createFileName);
				}
				
				// 옛날파일 삭제
				if (oldFileName != null) {
					File _file = new File(uploadPath + File.separator + oldFileName);
					if (_file.exists()) {
						_file.delete();
					}
				}
			}
			count++;
		}


		// 3. 업데이트
		boolean result = service.update(item);
		if (result == true) {
			return "item2/success";
		} else {
			return "item2/fail";
		}

	}

	// 요청한 상품이미지를 @ResponseBody 형식으로 전송요청
	@RequestMapping(value = "/item2/display", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> item2Display(Item2 item, int no, Model model) throws Exception {
		// 이미지 파일을 -> byte[] 클라로 전송 => File => byte[] => InputStream 변수선언
		InputStream in = null;
		// ResponseEntity<byte[]> 변수선언
		ResponseEntity<byte[]> entity = null;
		// 외장하드에 있는 이미지파일명을 가져온다
		item = service.select(item);
		String createFileName = no == 1 ? item.getPictureUrl() : item.getPictureUrl2();
		
		// 이미지 확장자 정보가 필요함(Media type)
		int index = createFileName.lastIndexOf(".");

		try {
			String formatName = createFileName.substring(index + 1);
			// 1. 미디어 타입을 결정
			MediaType mediaType = null;
			switch (formatName.toUpperCase()) {
			case "JPG":
				mediaType = mediaType.IMAGE_JPEG;
				break;
			case "GIF":
				mediaType = mediaType.IMAGE_GIF;
				break;
			case "PNG":
				mediaType = mediaType.IMAGE_PNG;
				break;

			default:
				mediaType = null;
				break;
			}
			// 2. HttpHeaders 생성
			HttpHeaders httpHeaders = new HttpHeaders();

			// 3. 외장하드에 있는 파일을 읽어온다.
			// C:\ upload\273ea991-ceb4-4447-99d9-d6ed7969c760_book-icon.png
			in = new FileInputStream(uploadPath + File.separator + createFileName);

			// mediaType null이 아니면 httpHeader contentType 등록
			if (mediaType != null) {
				httpHeaders.setContentType(mediaType);
			}

			// 4. ResponseEntity<byte[]> entity 객체생성
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}

		return entity;
	}
	
	
	// *********************************************************************************
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// 중복되지않는 ID생성 7c547e42-3079-4b58-bf91-33fc7d139cfc
		UUID uid = UUID.randomUUID();
		// 7c547e42-3079-4b58-bf91-33fc7d139cfc_홍길동.jpg
		String createdFileName = uid.toString() + "_" + originalName;
		// uploadpath = "c:/upload/7c547e42-3079-4b58-bf91-33fc7d139cfc_홍길동.jpg
		File target = new File(uploadPath, createdFileName);
		FileCopyUtils.copy(fileData, target);
		return createdFileName;
	}
}
