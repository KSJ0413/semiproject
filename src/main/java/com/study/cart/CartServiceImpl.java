package com.study.cart;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.cart.CartServiceImpl")
public class CartServiceImpl implements CartService {

  @Autowired
  private CartMapper mapper;
  
  
  @Override
  public int create(CartDTO dto) {
    // TODO Auto-generated method stub
    return mapper.create(dto);
  }


  @Override
  public List<CartDTO> list(String id) {
    // TODO Auto-generated method stub
    return mapper.list(id);
  }


  @Override
  public void delete(int cartno) {
    // TODO Auto-generated method stub
    mapper.delete(cartno);
  }



}
