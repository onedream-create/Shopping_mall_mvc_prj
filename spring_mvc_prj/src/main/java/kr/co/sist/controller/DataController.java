package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DataController {
	
	@RequestMapping(value="send/use_request.do",method = GET)
	public String useRequest(HttpServletRequest request) {
		//�߻��� �����͸� HttpServletRequest�� �����Ͽ� View�� ����.
		
		request.setAttribute("name", "<u>������</u>");//Controller���� �ۼ��� �±װ� View�� ���޵Ǿ�
		//<c:out>�� ���� ��µǸ� c:out�� tag �� �ؼ����� �ʰ� �״�� ��µȴ�. 
		request.setAttribute("subjects", 
				new String[] {"Java SE","Oracle","JDBC","HTML","CSS","JavaScript"});
		
		return "data/use_request";
	}//useRequest
	
	@RequestMapping(value="send/use_model.do",method = GET)
	//BindingAwareModelMap
	public String useModel( Model model ) {// �����ڰ� ��ü������ ���� �ʴ´�. 
		//�߻��� �����͸� Model�� �����Ͽ� View�� ����.
		
		model.addAttribute("name", "<u>����ȯ</u>");
		model.addAttribute("subjects", 
				new String[] {"Model���","Java SE","Oracle","JDBC","HTML","CSS","JavaScript"});
		
		return "data/use_request";
	}//useRequest
	
	@RequestMapping(value="send/use_model_and_view.do",method = GET)
	//��ȯ���� ModelAndView�� ����
	public ModelAndView useModelAndView( ) {
		//�߻��� �����͸� ModelAndView�� �����Ͽ� View�� ����.
		
		//ModelAndView�� ����
		ModelAndView mav=new ModelAndView();
		//view������
		mav.setViewName("data/use_request");
		//������ : ������ ���� requestScope�� ����Ǿ� ����.
		mav.addObject("name", "<u>����ȯ</u>");
		mav.addObject("subjects", 
				new String[] {"<strong>ModelAndView���</strong>","Java SE","Oracle","JDBC","HTML","CSS","JavaScript"});
		
		return mav;
	}//useRequest
}//class