package cn.lntu.t31;

import java.util.List;

public class MutiCondition {
	
	public List<Condition> MoreCondition;
	public String Clause;
        
	public List<Condition> getMoreCondition() {
		return MoreCondition;
	}
	public void setMoreCondition(List<Condition> moreCondition) {
		MoreCondition = moreCondition;
	}
	public String getClause() {
		return Clause;
	}
	
	public void setClause(String clause) {
		Clause = clause;
	}
	public int getMoreConditionCount(){
		return this.MoreCondition.size();
	}

}
