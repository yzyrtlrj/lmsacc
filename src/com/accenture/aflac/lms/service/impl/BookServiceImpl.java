package com.accenture.aflac.lms.service.impl;

import java.util.List;

import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.BookDao;
import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.BookService;

public class BookServiceImpl implements BookService{
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public List<Book> findAll(Pagination p) {
		// TODO Auto-generated method stub
		PaginationUtil.execute(p);
		return bookDao.findAll(p.getOffset(), p.getLength());
	}

	@Override
	public Book findById(String id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	@Override
	public int add(Book entity) {
		// TODO Auto-generated method stub
		return bookDao.add(entity);
	}

	@Override
	public int update(Book entity) {
		// TODO Auto-generated method stub
		return bookDao.update(entity);
	}

	@Override
	public int delete(Book entity) {
		// TODO Auto-generated method stub
		//将数据的删除标志位置为1
		entity.setDeleteStatus(1);
		return bookDao.delete(entity);
	}

	@Override
	public List<Book> findByCatagory(Book entity) {
		// TODO Auto-generated method stub
		String catagoryName=entity.getCatagoryName();
		//如果catagoryName为空，则把值设为"",以防意外的null使hql出现错误
		if(catagoryName==null){
			catagoryName="";
		}
		Object[] params={catagoryName};
		String hql="from Book book where book.catagoryName=?";
		return  (List<Book>) bookDao.findByHQL(hql, params);
	}

	@Override
	public List<Book> findByBookName(Book entity) {
		// TODO Auto-generated method stub
		String bookName=entity.getBookName();
		//如果bookName为空，则把值设为"",以防意外的null使hql出现错误
		if(bookName==null){
			bookName="";
		}
		Object[] params={bookName};
		String hql="from Book book where book.bookName=?";
		return (List<Book>) bookDao.findByHQL(hql, params);
	}

	@Override
	public List<String> findALLCatagory() {
		// TODO Auto-generated method stub
		String hql="select distinct book.catagoryName from Book book";
		return (List<String>) bookDao.findByHQL(hql, null);
		
	}

	@Override
	public List<Book> searchByCondition(Book entity,Pagination p) {
		// TODO Auto-generated method stub
		/*//考虑到可能会多次拼接字符串，所以此处用StringBuffer取代String（String每次拼接都是生成一个新的对象，而StringBuffer不会）
		StringBuffer hql=new StringBuffer();
		hql.append("from Book book");
		//定义一个临时的Object类型的List来存放查询条件，因为在不知道确定查询条件数量时无法实例化出配对的复合条件要求的对象数组
		List<Object> temp=new ArrayList<>();
		Object[] params=null;
		//定义一个flag来确定要不要拼接and
		Boolean flag=false;
		
		//当查询条件部为空即开始拼接字符串
		if(entity!=null){
			if(entity.getBookName()!=""){
				flag=true;
				hql.append(" where book.bookName=?");
				temp.add(entity.getBookName());
			}
			if(entity.getAuthor()!=""){
				//当flag为true即代表where从句需要拼接and
				if(flag){
					hql.append(" and");
				}else{
					hql.append(" where");
				}
				flag=true;
				hql.append(" book.author=?");
				temp.add(entity.getAuthor());
			}
			if(entity.getCatagoryName()!=""){
				//当flag为true即代表where从句需要拼接and
				if(flag){
					hql.append(" and");
				}else{
					hql.append(" where");
				}
				flag=true;
				hql.append(" book.catagoryName=?");
				temp.add(entity.getCatagoryName());
			}
			if(entity.getIndexNum()!=""){
				//当flag为true即代表where从句需要拼接and
				if(flag){
					hql.append(" and");
				}else{
					hql.append(" where");
				}
				hql.append(" book.indexNum=?");
				temp.add(entity.getIndexNum());
			}
			params=new Object[temp.size()];
			for(int i=0;i<temp.size();i++){
				params[i]=temp.get(i);
			}
		}
		hql.append("limit "+p.getOffset()+","+p.getLength());		
		return (List<Book>) bookDao.findByHQL(hql.toString(), params);*/
		return bookDao.findAll(entity, p.getOffset(), p.getLength());
	}

	@Override
	public int countRows() {
		// TODO Auto-generated method stub
		return bookDao.countRows();
	}

}
