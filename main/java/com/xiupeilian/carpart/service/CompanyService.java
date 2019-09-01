package com.xiupeilian.carpart.service;/**
 * @ProjectName: carPart
 * @Package: com.xiupeilian.carpart.service
 * @ClassName: CompanyService
 * @Author: sunflower
 * @Description:
 * @Date: 2019/8/30 14:17
 * @Version: 1.0
 */

import com.xiupeilian.carpart.model.Company;

/**
 * @Description:
 * @Author: Xiao Gao Student
 * @CreateDate: 2019/8/30 14:17 
 * @Version: 1.0
 **/
public interface CompanyService {
    Company findCompanyByid(Integer id);
}
