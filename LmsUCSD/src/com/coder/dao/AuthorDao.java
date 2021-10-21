package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Author;





@Repository("authorDoa")
public class AuthorDao extends AbstractDao<Integer,Author>{
	
	public Integer saveAuthor(Author author)
	{
	return (Integer)super.persist(author);

		}
	public Author getAuthorById(int id){
		Author address=super.criteriaQuerryGetObjectById(id,"authorId");
		return address;
		}
	public List<Author> getAuthors(){
		List<Author> authors=super.getAllEntity();
		return authors;
	}
  
public void  updateAuthor(Author author)
{
super.update(author);

}



}
