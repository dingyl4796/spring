/**
 * Project Name:banma
 * File Name:MemberService.java
 * Package Name:cn.bluemobi.banma.service
 * Date:2015年12月14日下午12:49:15
 * Copyright (c) 2015, bluemobi.cn All Rights Reserved.
 *
 */

package cn.dyl.service;

import java.util.List;
import java.util.Map;



/**
 * Description: <br/>
 * Date: 2015年12月14日 下午12:49:15 <br/>
 * 
 * @author lvxh
 * @version
 * @see
 */
public interface MemberService {

	int banMember(Long id);

	List<Map<String, Object>> findMembers(int pageNo, int pageSize, String start, String end);

}
