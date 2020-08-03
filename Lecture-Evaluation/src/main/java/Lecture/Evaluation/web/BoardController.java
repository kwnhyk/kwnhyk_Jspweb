package Lecture.Evaluation.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Lecture.Evaluation.domain.BoardVO;
import Lecture.Evaluation.service.BoardService;
@Controller
@RequestMapping("/board")
public class BoardController {

	
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("list")
	public ModelAndView list() throws Exception{
		List<BoardVO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		mav.addObject("list",list);
		return mav;
		
	
	}
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	@PostMapping("insert")
	public String insert(@ModelAttribute BoardVO vo)  throws Exception{
		
		boardService.create(vo);
		return "redirect:list";
	}
	@GetMapping("view")
	public ModelAndView view(@RequestParam int bno,HttpSession session)throws Exception{
		
		
	boardService.increaseViewcnt(bno, session);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("board/view");
	mav.addObject("dto",boardService.read(bno));
	return mav;
	}
	@PostMapping("update")
	public String update(@ModelAttribute BoardVO vo) throws Exception{
		boardService.update(vo);
		return "redirect:list";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		return "reddirect:list";
	}


	
	
	
}
