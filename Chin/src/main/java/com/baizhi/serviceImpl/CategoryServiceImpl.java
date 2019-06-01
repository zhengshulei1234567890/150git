package com.baizhi.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.Service.CategoryService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import org.apache.ibatis.session.SqlSession;



public class CategoryServiceImpl implements CategoryService {
	//类别管理
	@Override
	public List<Category> queryAll() {
		//先获得dao的引用
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
       // CategoryDao cd =(CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		//调用cd查询所有类别的方法
		List<Category> list=cd.queryAll();
		//处理业务
		//把查询出的结果返回给cation
		MybatisUtil.close();
		return list;		
	}

		//类别管理 一级页面
	@Override
	public void CategoryFirst(Category cate) {
		//先获得dao的引用
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
       // CategoryDao mapper = (CategoryDao)MybatisUtil.getMapper(CategoryDao.class);
	
		String id = UUID.randomUUID().toString();
		cate.setId(id);
								
			mapper.categoryFirst(cate);
			MybatisUtil.commit();
			MybatisUtil.close();
		
	}
	
	
	//类别管理    1级页面查询方法
	public List<Category> queryFirst(){
		//拿到dao层的引用
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
		//CategoryDao cd =(CategoryDao)MybatisUtil.getMapper(CategoryDao.class);
		List<Category> list = cd.queryFirst();
		return list;
	}
	
	
	//类别管理二级页面
	public void CategorySecond(Category cate){
		//拿到dao层的引用
	
	SqlSession sqlSession = MybatisUtil.getSqlSession();
	CategoryDao categorysecond= sqlSession.getMapper(CategoryDao.class);
	
		String id = UUID.randomUUID().toString();
		cate.setId(id);
		try{						
			categorysecond.categorySecond(cate);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//类别管理删除
	@Override
	public void CategoryDelect(Category category) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
       // CategoryDao cd =(CategoryDao)MybatisUtil.getMapper(CategoryDao.class);
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        BookDao bd = sqlSession1.getMapper(BookDao.class);
        //BookDao bd =(BookDao)MybatisUtil.getMapper(BookDao.class);
		System.out.println(category);
		if(category.getLevels()==1){
			List<Category> list=cd.categorySelertSecond(category);
			if(list.size()==0){
				cd.categoryDelect(category);
			}
		}else{
			List<Book> list = bd.BookFind(category.getId());
			//System.out.println(list);
			if(list.size()==0){
				cd.categoryDelect(category);
			}
		}
		MybatisUtil.commit();
		MybatisUtil.close();
	}

	
		//二级查询
	@Override
	public List<Category> querysecond() {
		//拿到dao层的引用
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
       // CategoryDao cd =(CategoryDao)MybatisUtil.getMapper(CategoryDao.class);
		List<Category> list = cd.querysecond();
		MybatisUtil.close();
		return list;
	
	}
	
			//front
	//分类查询
	@Override
	public List<Category> queryCategoryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
	   // CategoryDao cd =(CategoryDao)MybatisUtil.getMapper(CategoryDao.class);
		List<Category> list = cd.queryCategoryAll();
		return list;
	}
	
	@Override
	public Category categoryFid(String fid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryDao cd = sqlSession.getMapper(CategoryDao.class);
		//CategoryDao cd = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		Category category= cd.categoryFid(fid);
		return category;
	}

	
	
}	

