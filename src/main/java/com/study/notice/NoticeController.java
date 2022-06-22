package com.study.notice;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.notice.NoticeDTO;
import com.study.notice.NoticeService;
import com.study.utility.Utility;

@Controller
public class NoticeController {

  @Autowired
  @Qualifier("com.study.notice.NoticeServiceImpl")
  private NoticeService service;

  @GetMapping
  public String home(Locale locale, Model model) {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);
    return "/home";
  }

  @GetMapping("/notice/create")
  public String create() { // tiles에서 찾다가 없으면 Notice.xml에가서 찾음

    return "/notice/create";
  }

  @PostMapping("/notice/create")
  public String create(NoticeDTO dto) {

    if (service.create(dto) == 1) {
      return "redirect:list";
    } else {
      return "error";
    }
  }

  @RequestMapping("/notice/list")
  public String list(HttpServletRequest request) {
    // 검색관련------------------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if (col.equals("total")) {
      word = "";
    }
    // 페이지관련-----------------------
    int nowPage = 1;// 현재 보고있는 페이지
    if (request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 3;// 한페이지당 보여줄 레코드갯수

    // DB에서 가져올 순번-----------------
    int sno = ((nowPage - 1) * recordPerPage);
    // int eno = nowPage * recordPerPage;

    Map map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("cnt", recordPerPage);

    int total = service.total(map);

    List<NoticeDTO> list = service.list(map);

    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

    // request에 Model사용 결과 담는다
    request.setAttribute("list", list);
    request.setAttribute("nowPage", nowPage);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);

    // view페이지 리턴
    return "/notice/list";
  }

  @GetMapping("/notice/read")
  public String read(int noticeno, Model model) {

    service.upCnt(noticeno);

    NoticeDTO dto = service.read(noticeno);

    String content = dto.getContent().replaceAll("\r\n", "<br>");

    dto.setContent(content);

    model.addAttribute("dto", dto);

    return "/notice/read";
  }

  @GetMapping("/notice/delete")
  public String delete(int noticeno) {

    return "/notice/delete";
  }

  @PostMapping("/notice/delete")
  public String delete(int noticeno, String passwd) {

    Map map = new HashMap();
    map.put("noticeno", noticeno);
    map.put("passwd", passwd);
    int pcnt = service.passwd(map);

    int cnt = 0;
    if (pcnt == 1) {

      cnt = service.delete(noticeno);
    }

    if (pcnt != 1) {
      return "passwdError";
    } else if (cnt == 1) {
      return "redirect:./list";
    } else {
      return "error";
    }

  }

  /** 
   * tiles에 가서 update를 찾고 거기서 updateForm.jsp로 연결이 되어 있어 
   * 연결 시켜주고 postmapping으로 받아서 dto에 담고 dto를 mpa에 담고
   * passwd를 int pcnt로 받고
   * 1개 있으면 update에 dto를 cnt에 넣고
   * 그후 연결 실패 오류 나오게함
  **/
  @GetMapping("/notice/update") 
  public String update(int noticeno, Model model) {

    model.addAttribute("dto", service.read(noticeno));

    return "/notice/update";
  }

  @PostMapping("/notice/update")
  public String update(NoticeDTO dto) {

    Map map = new HashMap();
    map.put("noticeno", dto.getNoticeno());
    map.put("passwd", dto.getPasswd());
    int pcnt = service.passwd(map);

    int cnt = 0;
    if (pcnt == 1) {

      cnt = service.update(dto);
    }

    if (pcnt != 1) {
      return "./passwdError";
    } else if (cnt == 1) {
      return "redirect:./list";
    } else {
      return "error";
    }
  }
}
