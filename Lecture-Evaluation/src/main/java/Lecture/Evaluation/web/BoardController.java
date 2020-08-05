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
import Lecture.Evaluation.service.BoardService;
@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LogManager.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("list")
	
	public ModelAndView list(BoardDTO vo) throws Exception{
		
		logger.info("list..");
		List<BoardDTO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
	
		
		mav.addObject("list",list);
		mav.setViewName("board/list");
		logger.info("왜 안돼~~~~~~");
		return mav;
		
	
	}
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	@PostMapping("insert")
	public String insert(BoardDTO vo)  throws Exception{
		
		boardService.insert(vo);
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
	public String update(@ModelAttribute BoardDTO vo) throws Exception{
		boardService.update(vo);
		return "redirect:list";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		return "reddirect:list";
	}


	
	
	
}
