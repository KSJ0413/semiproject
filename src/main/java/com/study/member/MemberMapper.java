package com.study.member;
 
import java.util.List;
import java.util.Map;
 
public interface MemberMapper {
 
        int duplicatedId(String id);
 
        int duplicatedEmail(String email);
 
        int create(MemberDTO dto);
 
        int loginCheck(Map<String, String> map);
 
        Map getGrade(String id);
 
        MemberDTO read(String id);
 
        int update(MemberDTO dto);
 
        int total(Map map);
 
        List<MemberDTO> list(Map map);
 
        int updateFile(Map map);
        
        MemberDTO mypage(String id);

        int idFind(Map<String, String> map);

        String idView(Map<String, String> map);

        int passwdFind(Map<String, String> map);

        String passwdView(Map<String, String> map);

        
 
}
 