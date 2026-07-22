package com.zeus.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SpringController {
	
	@RequestMapping(value = "/spring/form1",method = RequestMethod.GET)
	public String springForm1(Model model) {
		log.info("/spring/form1");
		Member member = new Member();
		member.setUserId("hong");
		member.setUserName("홍길동");
		member.setPassword("123456");
		member.setEmail("zeus@naver.com");
		member.setIntroduction("안녕하세요 홍길동입니다.");
		
		//체크박스
//		List<CodeLabelValue> hobbyList = new ArrayList<>();
//		hobbyList.add(new CodeLabelValue("01","축구"));
//		hobbyList.add(new CodeLabelValue("02","영화"));
//		hobbyList.add(new CodeLabelValue("03","등산"));
//		member.setHobbyList(hobbyList);
		
		Map<String, String> hobbyMap = new LinkedHashMap<>();
		hobbyMap.put("축구", "01");
		hobbyMap.put("배구", "02");
		hobbyMap.put("농구", "03");
		member.setHobbyMap(hobbyMap);
		
		//외국인유무
		member.setForeigner(true);
		
		//hobbyArray(UI 각 항목이 존재함)
		List<String> hobbyList = new ArrayList<>();
		hobbyList.add("sports");
		hobbyList.add("music");
		hobbyList.add("movie");
		member.setHobbyList(hobbyList);
		
		model.addAttribute(member);
		
		return "spring/form1";
	}

	@RequestMapping(value = "/spring/register", method = RequestMethod.POST)
    // @ResponseBody
    public String register(Model model,@Validated Member member,BindingResult result,RedirectAttributes rttr) {
        log.info("/spring/register");

        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            List<ObjectError> globalErrors = result.getGlobalErrors();
            List<FieldError> fieldErrors = result.getFieldErrors();
            log.info("allErrors.size() = " + allErrors.size());
            log.info("globalErrors.size() = " + globalErrors.size());
            log.info("fieldErrors.size() = " + fieldErrors.size());
            for (int i = 0; i < allErrors.size(); i++) {
                ObjectError objectError = allErrors.get(i);
                log.info("allError = " + objectError);
            }
            for (int i = 0; i < globalErrors.size(); i++) {
                ObjectError objectError = globalErrors.get(i);
                log.info("globalError = " + objectError);
            }

            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);

                log.info("fieldError = " + fieldError);
                log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
            }
            rttr.addFlashAttribute("message", "입력값에 에러가 발생했습니다.");
            return "redirect:/spring/form1";
        }
    		
		return "spring/success";
	}
}
