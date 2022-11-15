package com.xzg.wlxx.org.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.xzg.wlxx.core.utils.PinyinUtil;
import com.xzg.wlxx.org.OrgApplication;
import com.xzg.wlxx.org.entity.po.CompanyPo;
import com.xzg.wlxx.org.entity.vo.CompanyVo;
import com.xzg.wlxx.org.service.ICompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.test
 * @date 2022/11/12 10:28
 */
@SpringBootTest(classes = {OrgApplication.class})
@Slf4j
public class TestCompany extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ICompanyService companyService;

    private Faker faker = new Faker(Locale.CHINA);


    @Test
    @Rollback(false)
    public void test() throws Exception {
        IntStream.range(0, 10).forEach(i -> {
            Company mock = faker.company();
            CompanyPo companyPo = new CompanyPo();
            companyPo.setCompanyName(mock.name());
            companyPo.setCompanyCode(PinyinUtil.toPinyin(companyPo.getCompanyName()));
            companyPo.setLevel(faker.random().nextInt(0, 10));

            List<CompanyPo> parent = companyService.lambdaQuery()
                    .eq(CompanyPo::getLevel, i - 1)
                    .list();
            if (!CollectionUtil.isEmpty(parent)) {
                companyPo.setParentCompanyId(parent.get(0).getId());
            }
            companyService.save(companyPo);
        });
    }

    @Test
    public void testGetAll() {
        List<CompanyVo> vos = companyService.getAll();
        log.info(JSONUtil.toJsonStr(vos));
    }

    //@DataProvider
    //public Object[][] db() {
    //    return new Object[][]{};
    //}
}
