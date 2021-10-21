package com.coder.servic;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coder.dao.AuthorDao;
import com.coder.form.AuthorForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.model.Author;




@Service
@Repository("authorRegisterService")
public class AuthorRegisterService {
	
	@Autowired
	private AuthorDao authorDao;

	
		
	
	public void prepareAuthorRegister(AuthorRegisterForm authorRegisterForm)
	{  AuthorForm authorForm=authorRegisterForm.getAuthorForm();
		if(authorForm!=null){
			if(authorForm.getAuthorId()!=null){
				Author author=this.authorDao.getAuthorById(Integer.parseInt(authorForm.getAuthorId()));
				authorForm.setAuthorId(author.getAuthorId()+"");
				authorForm.setAuthorName(author.getAuthorName());
				authorRegisterForm.setAuthorForm(authorForm);
				//System.out.println("Prepare Author Author Id:="+author.getAuthorId());
			}else{
				this.authorRegister(authorRegisterForm);
				authorForm=null;
				authorRegisterForm.setAuthorForm(authorForm);
			}
		}
		List<Author> authors=this.authorDao.getAuthors();
		authorRegisterForm.setAuthors(authors);
		
	}
	private int authorRegister(AuthorRegisterForm authorRegisterForm){
             Author author=new Author();
             author.setAuthorName(authorRegisterForm.getAuthorForm().getAuthorName());
             int id=authorDao.saveAuthor(author);
			return id;
	}
}
