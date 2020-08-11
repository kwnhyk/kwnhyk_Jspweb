package Lecture.Evaluation.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.PageMaker;
import Lecture.Evaluation.service.BoardService;
@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LogManager.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("list")
	
	public ModelAndView list(HttpSession session,Criteria criteria) throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		
		 if(user !=null) {
			    
		logger.info("list..");
		 

		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setCriteria(criteria);
		    // 수정
		    pageMaker.setTotalCount(boardService.countBoard(criteria));
		    int count = boardService.countBoard(criteria);
		   System.out.printf("count%d",count);

		  

		    
		//List<BoardDTO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
	
		
		mav.addObject("list",boardService.listCriteria(criteria));
		mav.addObject("pageMaker",pageMaker);
		mav.setViewName("board/list");
		
		return mav;
		 }else {
			 String url = "redirect:../auth/form";
		        return new ModelAndView(url);
			 
		 }
	
	}
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	@PostMapping("insert")
	public String insert(@ModelAttribute BoardDTO vo,HttpSession session)  throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		 
	String writer=(String) user.getUserID();
	vo.setWriter(writer);
		boardService.insert(vo);
		return "redirect:list";
	}
	@GetMapping("view")
	public ModelAndView view(@RequestParam Integer bno,HttpSession session)throws Exception{
		
		
	boardService.increaseViewcnt(bno, session);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("board/view");
	mav.addObject("dto",boardService.read(bno));
	return mav;
	}
	@PostMapping("update")
	public String update(@ModelAttribute BoardDTO vo,HttpSession session) throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		String writer=(String)user.getUserID();
		
		vo.setWriter(writer);
		boardService.update(vo);
		return "redirect:list";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam Integer bno) throws Exception{
		boardService.delete(bno);
		return "redirect:list";
	}


	
	
	
}
