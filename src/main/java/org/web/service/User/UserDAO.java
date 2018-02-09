package org.web.service.User;

import java.util.List;

import org.web.service.domain.UserVO;
import org.web.service.dto.LoginDTO;
public interface UserDAO {
	
	public UserVO login(LoginDTO dto)throws Exception;

	public void create(UserVO vo)throws Exception;
	
	public void delete(String uid)throws Exception;
	
	public List<UserVO> listAll() throws Exception;
}
