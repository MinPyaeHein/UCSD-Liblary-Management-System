package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.Position;
import com.coder.model.Student;
import com.coder.model.Teacher;





@Repository("positionDao")
public class PositionDao extends AbstractDao<Integer,Position>{
	
	public Integer savePosition(Position position)
	{
	return (Integer)super.persist(position);
    }
	
	public Position getPositionById(int id){
		Position position=super.criteriaQuerryGetObjectById(id,"positionId");
	return position;}
  
public void  updatePosition(Position position)
{
super.update(position);

}
public void  deletePosition(Position position)
{
super.delete(position);

}

public List<Position> getPositions() {
	List<Position> positions=(List<Position>)super.getAllEntity();
		return positions;
	}

}
