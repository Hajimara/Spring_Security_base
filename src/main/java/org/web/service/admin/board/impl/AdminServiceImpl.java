package org.web.service.admin.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.web.common.SearchCriteria;
import org.web.service.admin.board.AdminService;
import org.web.service.domain.BoardVO;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("adminDaoImpl")
	private AdminDaoImpl dao;
	
	public void setDao(AdminDaoImpl dao) {
		this.dao = dao;
	}
	
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
		
	}

	@Override
	public BoardVO get(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.get(bno);
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		delete(bno);
	}

	@Override
	public List<BoardVO> list(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCount(cri);
	}
	
}
