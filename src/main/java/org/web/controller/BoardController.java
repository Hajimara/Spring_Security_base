package org.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.common.PageMaker;
import org.web.common.SearchCriteria;
import org.web.service.admin.board.AdminService;
import org.web.service.domain.BoardVO;

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService service;
	
	public void setService(AdminService service) {
		this.service = service;
	}
	
	public BoardController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		
		logger.info("list get.....");
		
		model.addAttribute("list",service.list(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "board/getBoardList";
	}
	/*
	 * Model 객체의 속성 (MVC의 M)을 참조
	 * @ModelAttribute("cri") view에서 이 객체를 액세스 할 수 있게 해준다.
	 * */
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get(@RequestParam("bno") int bno,Model model,@ModelAttribute("cri") SearchCriteria cri)throws Exception{
		logger.info("board get ...");
		
		model.addAttribute(service.get(bno));
		
		return "board/getBoard";
	}
	//게시판 등록 화면 
	@RequestMapping(value="/create", method= RequestMethod.GET)
	public String create(BoardVO board, Model model)throws Exception{
		logger.info("create get.....");
	
		return "board/createBoard";
	}	
	//게시판 등록 처리 
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public String create(BoardVO board, RedirectAttributes rttr)throws Exception{
		logger.info("create post.....");
		logger.info(board.toString());
		service.create(board);
		
		rttr.addFlashAttribute("msg","success");
		return "redirect:board/getBoardList";
	}
	//게시판 수정 화면 
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("bno")int bno,
			@ModelAttribute("cri") SearchCriteria cri,
			Model model)throws Exception{
		logger.info("update get......");
		service.get(bno);
		
		return "board/updateBoard";
	}
	//게시판 수정 처리 
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BoardVO board, SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		logger.info(rttr.toString());
		logger.info("update post....");
		
		service.update(board);
		//이전 페이지로 돌아가기 위해 
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		logger.info(rttr.toString());
		
		return "redirect:board/getBoardList";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("bno")int bno,SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		logger.info("delete .......");
		service.delete(bno);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:board/getBoardList";
	}
	
	
}
