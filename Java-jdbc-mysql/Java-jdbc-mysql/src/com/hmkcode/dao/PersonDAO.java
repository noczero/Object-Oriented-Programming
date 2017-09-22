package com.hmkcode.dao;

import java.util.List;

import com.hmkcode.vo.Person;

public interface PersonDAO {
	
	public void insert(Person person);
	public List<Person> select();

}
