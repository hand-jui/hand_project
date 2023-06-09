package sotongSotong.dao;

import java.util.ArrayList;

import sotongSotong.dto.DTO;

public interface IDAO {

	ArrayList<DTO> select();
	
	DTO selectByNo(int no);

	int insert(DTO dto);

	int update(DTO dto);

	int delete(DTO dto);


}
