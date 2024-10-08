package chap13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public List<Board> getBoardDaoList() {
		
		List<Board> list = new ArrayList<Board>();
		
		list.add(new Board ("제목1","내욕1"));
		list.add(new Board ("제목2","내욕2"));
		list.add(new Board ("제목3","내욕3"));
		return list;
		
	}

}
