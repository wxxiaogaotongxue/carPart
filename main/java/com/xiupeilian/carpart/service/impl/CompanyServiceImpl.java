package com.xiupeilian.carpart.service.impl;/**
 * @ProjectName: carPart
 * @Package: com.xiupeilian.carpart.service.impl
 * @ClassName: CompanyServiceImpl
 * @Author: sunflower
 * @Description:
 * @Date: 2019/8/30 14:16
 * @Version: 1.0
 */

import com.xiupeilian.carpart.mapper.CompanyMapper;
import com.xiupeilian.carpart.model.Company;
import com.xiupeilian.carpart.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Xiao Gao Student
 * @CreateDate: 2019/8/30 14:16 
 * @Version: 1.0
 **/
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public Company findCompanyByid(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }
}
