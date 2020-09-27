package com.example.demo;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SampleController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index (Model model) {
		return "hello";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView response(@ModelAttribute ParamObject members) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("result", members.getMembers());
		return mav;
	}

	public static class ParamObject {
		private List<Member> members = new ArrayList<Member>();
		public void setMembers(List<Member> members) {
			this.members = members;
		}
		public List<Member> getMembers() {
			return members;
		}
	}
}
