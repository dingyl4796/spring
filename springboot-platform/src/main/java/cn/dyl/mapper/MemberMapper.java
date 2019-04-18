package cn.dyl.mapper;

import java.util.List;
import java.util.Map;

public interface MemberMapper {

    List<Map<String, Object>> findMembers(Map<String, Object> params);

    int banMember(Long id);


}