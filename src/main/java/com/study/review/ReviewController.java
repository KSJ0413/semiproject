package com.study.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.utility.Utility;


@RestController
public class ReviewController {
  private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
 
  @Autowired
  private ReviewMapper mapper;
 
  @GetMapping("/bbs/reply/list/{contentsno}/{sno}/{eno}")
  public ResponseEntity<List<ReviewDTO>> getList(
      @PathVariable("contentsno") int contentsno, 
      @PathVariable("sno") int sno,
      @PathVariable("eno") int eno) {
 
    Map map = new HashMap();
    map.put("sno", sno);
    map.put("eno", eno);
    map.put("contentsno", contentsno);
    System.out.println("map:"+map);
    System.out.println("sno:"+sno);
    System.out.println("eno:"+eno);
    System.out.println("contentsno:"+contentsno);
    
 
    return new ResponseEntity<List<ReviewDTO>>(mapper.list(map), HttpStatus.OK);
  }
 
  @GetMapping("/bbs/reply/page")
  public ResponseEntity<String> getPage(
     int nPage, int nowPage,int contentsno ,String col,String word )  {
 
    int total = mapper.total(contentsno);
    String url = "/contents/detail/"+contentsno;

    int recordPerPage = 3; // 한페이지당 출력할 레코드 갯수
 
    String paging = Utility.rpaging1(total, nowPage, recordPerPage, col, word,url, nPage);
    System.out.println("paging:"+paging);
    return new ResponseEntity<>(paging, HttpStatus.OK);
 
  }
  @PostMapping("/bbs/reply/create")
  public ResponseEntity<String> create(@RequestBody ReviewDTO vo) {
 
    log.info("ReviewDTO1: " + vo.getContent());
    log.info("ReviewDTO1: " + vo.getId());
    log.info("ReviewDTO1: " + vo.getContentsno());
 
    vo.setContent(vo.getContent().replaceAll("/n/r", "<br>"));
 
    int flag = mapper.create(vo);
 
    log.info("Reply INSERT flag: " + flag);
 
    return flag == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
 
  @GetMapping("/bbs/reply/{rnum}")
  public ResponseEntity<ReviewDTO> get(@PathVariable("rnum") int rnum) {
 
    log.info("get: " + rnum);
 
    return new ResponseEntity<>(mapper.read(rnum), HttpStatus.OK);
  }
  @PutMapping("/reply/")
  public ResponseEntity<String> modify(@RequestBody ReviewDTO vo, 
      @PathVariable("rnum") int rnum) {
 
    log.info("modify: " + vo);
 
    return mapper.update(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 
  }
 
  @DeleteMapping("/reply/{rnum}")
  public ResponseEntity<String> remove(@PathVariable("rnum") int rnum) {
 
    log.info("remove: " + rnum);
 
    return mapper.delete(rnum) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 
  }
}
 
