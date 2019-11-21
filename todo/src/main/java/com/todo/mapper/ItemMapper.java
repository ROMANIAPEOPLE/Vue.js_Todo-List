package com.todo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.dto.ItemDto;


@Mapper
public interface ItemMapper {
	void insert(ItemDto item);
	List<ItemDto> findAll();
	void deleteOne(int id);
	void deleteAll();
	int size();
	String findOne(int id);
}