package expe.ch3;

import expe.ch2.EmployeeModel;

public class PageManagerImpl extends PageManager {

	@Override
	public void firstPage() {
		// TODO Auto-generated method stub
		goPage(1);
	}

	@Override
	public void lastPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void prePage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextPage() {
		goPage(currentPage++);
	}

	@Override
	public void goPage(int page) {
		int snum = 0, endnum = 0;
		
		
		
		snum=(page-1)*rowsPerPage;
		endnum=page*rowsPerPage-1;
		
		currentPage=page;
		

		for (int i = snum; i < endnum && i < list.size(); i++) {
			EmployeeModel em = (EmployeeModel) list.get(i);
			em.getYgno();
		}

	}

}
