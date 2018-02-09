package org.web.service.admin.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.web.common.SearchCriteria;
import org.web.service.admin.board.AdminDao;
import org.web.service.domain.BoardVO;

@Repository("adminDaoImpl")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession session;
	
	private static String namespace ="AdminMapper";
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public AdminDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public BoardVO get(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".get", bno);
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".create",vo);
		
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",bno);
		
	}

	@Override
	public List<BoardVO> list(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list", cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".totalCount",cri);
	}

}
