package com.study.contents;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.contents.ContentsServiceImpl")
public class ContentsServiceImpl implements ContentsService {
  @Autowired
  private ContentsMapper mapper;
 
  @Override
  public int create(ContentsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.create(dto);
  }
 
  @Override
  public int update(ContentsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.update(dto);
  }
 
  @Override
  public int total(Map map) {
    // TODO Auto-generated method stub
    return mapper.total(map);
  }
 
  @Override
  public List<ContentsDTO> list(Map map) {
    // TODO Auto-generated method stub
    return mapper.list(map);
  }
 
  @Override
  public int updateFile(Map map) {
    // TODO Auto-generated method stub
    return mapper.updateFile(map);
  }

  @Override
  public ContentsDTO read(int contentsno) {
    // TODO Auto-generated method stub
    return mapper.read(contentsno);
  }

  @Override
  public List<Map> getCategory() {
    // TODO Auto-generated method stub
    return mapper.getCategory();
  }
  
  public List<ContentsDTO> mainlist(Map map) {
    // TODO Auto-generated method stub
    return mapper.mainlist(map);
  }

  @Override
  public ContentsDTO detail(int contentsno) {
    // TODO Auto-generated method stub
    return mapper.detail(contentsno);
  }

  @Override
  public void upViewcnt(int contentsno) {
    // TODO Auto-generated method stub
    
  }




 
}