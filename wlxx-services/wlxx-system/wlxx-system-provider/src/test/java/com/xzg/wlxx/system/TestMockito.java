package com.xzg.wlxx.system;

import com.xzg.wlxx.system.client.entity.TDict;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzgan
 * @date 2022/6/17
 * @since jdk1.8
 */
@SpringBootTest(classes = SystemApplication.class)
@Slf4j
@AutoConfigureMockMvc
@MockitoSettings
public class TestMockito {
    //@MockBean
    //TDictMapper dictMapper;

    @BeforeEach
    public void init() {
        List<TDict> list = new ArrayList<>();
        TDict dict = new TDict();
        dict.setDictCode("XXX");
        list.add(dict);
        //Mockito.when(dictMapper.selectList(Mockito.any())).thenReturn(list);
    }

    @Test
    public void test() {
        //List<TDict> s = dictMapper.selectList(new LambdaQueryWrapper<TDict>());
        //log.info("======={}", s);
    }
}
