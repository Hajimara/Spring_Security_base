package org.web.service.admin.board;

import java.util.List;

import org.web.common.SearchCriteria;
import org.web.service.domain.BoardVO;

public interface AdminService {
	public BoardVO get(Integer bno)throws Exception;
	
	public void create(BoardVO vo)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> list(SearchCriteria cri)throws Exception;
	
	public int totalCount(SearchCriteria cri)throws Exception;
}
