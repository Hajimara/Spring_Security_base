package org.web.service.User.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.web.service.User.UserDAO;
import org.web.service.domain.UserVO;
import org.web.service.dto.LoginDTO;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	private static String namespace="UserMapper";
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	// Constructor
	public UserDAOImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".login", dto);
	}

	@Override
	public void create(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String uid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
