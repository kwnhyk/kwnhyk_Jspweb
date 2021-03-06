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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.PageMaker;
import Lecture.Evaluation.page.SearchCriteria;
import Lecture.Evaluation.service.BoardService;
@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LogManager.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("list")
	
	public ModelAndView list(HttpSession session,@ModelAttribute("searchCriteria")SearchCriteria criteria) throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		
		 if(user !=null) {
			    
		logger.info("list..");
		 

		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setCriteria(criteria);
		    // 수정
		 //   pageMaker.setTotalCount(boardService.countBoard(criteria));
		    pageMaker.setTotalCount(boardService.countSearchedArticles(criteria));
		    int count = boardService.countSearchedArticles(criteria);
		   System.out.printf("count%d",count);
		   	
		  
		   
		    
		//List<BoardDTO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
	
		
		//mav.addObject("list",boardService.listCriteria(criteria));
		mav.addObject("list",boardService.listSearch(criteria));
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
	public String insert(@ModelAttribute ("vo") BoardDTO vo,HttpSession session)  throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		 
	String writer=(String) user.getUserID();
	vo.setWriter(writer);
	System.out.println(vo.toString());
		boardService.insert(vo);
		System.out.println("넘어가니?");
		return "redirect:list";
	}
	@GetMapping("view")
	public ModelAndView view(@RequestParam Integer bno,@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,HttpSession session)throws Exception{
		
		
	boardService.increaseViewcnt(bno, session);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("board/view");
	mav.addObject("dto",boardService.read(bno));
	return mav;
	}
	@GetMapping("updatePage")
	public String updatePage(@RequestParam Integer bno,@ModelAttribute("searchCriteria")SearchCriteria searchCriteria,Model model)throws Exception {
		 logger.info(searchCriteria.toString());
		 model.addAttribute("dto", boardService.read(bno));
		
		return "board/updatePage";
		
		
	}
	@PostMapping("update")
	public String update(SearchCriteria searchCriteria,RedirectAttributes redirectAttributes,@ModelAttribute BoardDTO vo,HttpSession session) throws Exception{
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		String writer=(String)user.getUserID();
		
		vo.setWriter(writer);
		boardService.update(vo);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum",searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType",searchCriteria.getSearchType());
		redirectAttributes.addAttribute("search",searchCriteria.getSearch());
		redirectAttributes.addFlashAttribute("msg", "updateSuccess");
		
		
		return "redirect:list";
	}
	@PostMapping("delete")
	public String delete(SearchCriteria searchCriteria,RedirectAttributes redirectAttributes,@RequestParam("bno") Integer bno) throws Exception{
		
		boardService.delete(bno);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum",searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType",searchCriteria.getSearchType());
		redirectAttributes.addAttribute("search",searchCriteria.getSearch());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:list";
	}


	
	
	
}
