package expe.ch3;

import java.util.List;

public abstract class PageManager {
	// 父类的私有成员在子类中同样不可见
	protected int rowsPerPage;
	protected int currentPage;

	protected String sql;
	protected List list;

	public abstract void firstPage();

	public abstract void lastPage();

	public abstract void prePage();

	public abstract void nextPage();

	public abstract void goPage(int page);

}
