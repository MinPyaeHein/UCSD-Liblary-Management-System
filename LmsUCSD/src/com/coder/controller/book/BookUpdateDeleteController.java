package com.coder.controller.book;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.AuthorForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookForm;
import com.coder.form.BookGroupForm;
import com.coder.form.SaveBookConfrimForm;
import com.coder.form.ShellForm;
import com.coder.form.ShellRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.form.UpdateBookForm;
import com.coder.model.BookAuthor;
import com.coder.model.BookGroup;
import com.coder.model.BookShell;
import com.coder.model.BookType;
import com.coder.servic.SaveBookConfrimServic;
import com.coder.servic.UpdateBookServic;




@Controller
@Transactional
public class BookUpdateDeleteController {
@Autowired
private SaveBookConfrimServic saveBookConfrimServic;
@Autowired
private UpdateBookServic updateBookServic;
@RequestMapping("/updateBookPath")
public String updateBookDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
{	
 String frmBookId=req.getParameter("frmBookId");
 UpdateBookForm   updateBookForm=new UpdateBookForm();
 updateBookForm.setBookId(frmBookId);
 updateBookServic.prepareUpdateBook(updateBookForm);
 HttpSession session=req.getSession(true);
 session.setAttribute("updateBookForm",updateBookForm);
 modelMap.addAttribute("updateBookForm",updateBookForm);
 return "updateBook1";
 
	}
     @RequestMapping("/updateBookSubmitPath1")
	public String updateBookSubmitDispatcher1(@ModelAttribute("updateBookForm") UpdateBookForm updateBookForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
    	 String next=req.getParameter("next");
 	     String finish=req.getParameter("finish");
 	     
	            BookForm bookForm=updateBookForm.getBookForm();
	            HttpSession session=req.getSession(true);
	            updateBookForm=(UpdateBookForm) session.getAttribute("updateBookForm");
	            updateBookForm.setBookForm(bookForm);
	          
	    if(next!=null){
	    	if(updateBookForm.getBookForm().getEditionId()!=null){
	
	    	}else{}
	    	
	    }else if(finish!=null){
	    	return "home";
	    }
	    session.setAttribute("delbookAuthors",new ArrayList<BookAuthor>());
	    session.setAttribute("delbookShells",new ArrayList<BookShell>());
	    session.setAttribute("delbookTypes",new ArrayList<BookType>());
	    session.setAttribute("bookAuthors",updateBookForm.getBookAuthors());
	    session.setAttribute("bookShells",updateBookForm.getBookShells());
	    session.setAttribute("bookTypes",updateBookForm.getBookTypes());
	    session.setAttribute("bookGroup",updateBookForm.getBookGroup());
   	    session.setAttribute("updateBookForm",updateBookForm);
	    
		return "updateBook2";
		}
     @RequestMapping("/updateBookSubmitPath2")
 	public String updateBookSubmitDispatcher2( ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
 	{	
 		  HttpSession session=req.getSession(true);
 		  UpdateBookForm updateBookForm =( UpdateBookForm) session.getAttribute("updateBookForm"); 
 		  BookGroup bookGroup=(BookGroup) session.getAttribute("bookGroup");
 		  
 		  ArrayList<BookAuthor> bookAuthors=(ArrayList<BookAuthor>) session.getAttribute("delbookAuthors");
 		  ArrayList<BookShell> bookShells =(ArrayList<BookShell>) session.getAttribute("delbookShells");
 		  ArrayList<BookType> bookTypes =(ArrayList<BookType>) session.getAttribute("delbookTypes");
 		  
 		  updateBookForm.setBookAuthors(bookAuthors);
 		  updateBookForm.setBookShells(bookShells);
 		  updateBookForm.setBookTypes(bookTypes);
 		  updateBookForm.setBookGroup(bookGroup);
 		  
 		  this.updateBookServic.updateBook(updateBookForm);
 		  
 		  SaveBookConfrimForm saveBookConfrimForm=new SaveBookConfrimForm();
 		  this.saveBookConfrimServic.prepareSaveBookConfrim(saveBookConfrimForm);
 		   modelMap.addAttribute("saveBookConfrimForm",saveBookConfrimForm);
 		  return "showAllBook";
 		}
    @RequestMapping("/updDeleteBookAuthorSubmitPath")
	public String deleteBookAuthorSubmitDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    int frmAuthorId=Integer.parseInt(req.getParameter("frmAuthorId"));
	    
	    
	    HttpSession session=req.getSession(true);	
	   
	    ArrayList<BookAuthor> bookAuthors =(  ArrayList<BookAuthor>) session.getAttribute("bookAuthors");
	    ArrayList<BookAuthor> delbookAuthors =(  ArrayList<BookAuthor>) session.getAttribute("delbookAuthors");
	  
	    int i=0;
	   for(BookAuthor at:bookAuthors){
	   if(at.getAuthor().getAuthorId()==frmAuthorId){
		   bookAuthors.remove(i);
		   delbookAuthors.add(at);
			   break;
		   }
		   i++;	   }
	   
	
	   session.setAttribute("bookAuthors", bookAuthors);
	    
		return "updateBook2";	}
	@RequestMapping("/updDeleteBookShellSubmitPath")
	public String deleteBookShellSubmitDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    int frmShellId=Integer.parseInt(req.getParameter("frmShellId"));
	    HttpSession session=req.getSession(true);	
	    ArrayList<BookShell> bookShells =(ArrayList<BookShell>) session.getAttribute("bookShells");
	    ArrayList<BookShell> delbookShells =(ArrayList<BookShell>) session.getAttribute("delbookShells");
	    int i=0;
	   for(BookShell bs:bookShells){
		  
		   if(bs.getShell().getShellId()==frmShellId){
			   bookShells.remove(i);
			   delbookShells.add(bs);
			   break;
		   }
		   i++; }
	 
	  
	   session.setAttribute("bookShells", bookShells);	
		
		return "updateBook2";
		
	
	}
	
	@RequestMapping("/updDeleteBookTypeSubmitPath")
	public String DeleteBookTypeSubmitDispatcher( ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    int frmTypeId=Integer.parseInt(req.getParameter("frmTypeId"));
	    HttpSession session=req.getSession(true);
	    ArrayList<BookType> bookTypes =(ArrayList<BookType>) session.getAttribute("bookTypes");
	    ArrayList<BookType> delbookTypes =(ArrayList<BookType>) session.getAttribute("delbookTypes");
	    
	    int i=0;
	    for(BookType bt:bookTypes){
	    	
		  if(bt.getType().getTypeId()==frmTypeId){
			 bookTypes.remove(i);
			 delbookTypes.add(bt);
			break;
		  }
		  i++;
		   }
	   
	    session.setAttribute("bookTypes",bookTypes);
	   
		return "updateBook2";
		}	
	
}
