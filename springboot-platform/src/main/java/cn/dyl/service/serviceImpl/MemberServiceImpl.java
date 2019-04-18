/**
 * Project Name:banma
 * File Name:MemberServiceImpl.java
 * Package Name:cn.bluemobi.banma.service.impl
 * Date:2015年12月14日下午12:50:20
 * Copyright (c) 2015, bluemobi.cn All Rights Reserved.
 *
 */

package cn.dyl.service.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dyl.mapper.MemberMapper;
import cn.dyl.service.MemberService;


/**
 * Description: <br/>
 * Date: 2015年12月14日 下午12:50:20 <br/>
 * 
 * @author lvxh
 * @version
 * @see
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
    private MemberMapper memberMapper;


    @Override
    public List<Map<String, Object>> findMembers(int pageNo, int pageSize, String start, String end) {
		System.out.println("进入service");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		List<Map<String, Object>> list = memberMapper.findMembers(params);
		if (list != null && list.size() > 0) {
			for (Map<String, Object> item : list) {
				if (item.get("nickName") != null) {
					try {
						String contentDecode = URLDecoder.decode(item.get("nickName").toString(), "UTF-8");
						item.put("nickName", contentDecode);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		 
        return list;
    }

    @Override
    public int banMember(Long id) {
        memberMapper.banMember(id);
        return 1;
    }

    
}
