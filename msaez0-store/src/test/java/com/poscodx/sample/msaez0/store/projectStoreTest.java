forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/test/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store
fileName: {{namePascalCase}}StoreTest.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store;

import java.util.List;
import com.poscodx.base.share.util.json.JsonUtil;
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.postgresql.{{namePascalCase}}PostgresqlStore;
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.{{namePascalCase}}Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


/**
 * Auto generated class
 * 
 * 자동생성 프로그램 버전 : 1.0.0
 * 생성일시 :  2025-06-25 09:50:25.681
 * @FileName : 클래스에 대한 한글 명칭
 * Change history
 * @수정날짜;SCR_NO;수정자;수정내용
 * @2025-06-25 09:50:25.681;00000;홍길동;최초생성
 * 
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {
    ApplicationContext.class,
    {{namePascalCase}}PostgresqlStore.class
})
public class {{namePascalCase}}StoreTest {
    @Autowired
    private {{namePascalCase}}Store store;

    @Test
    public void test() {
        List<{{namePascalCase}}> entities = this.store.retrieveAll();
        String json = JsonUtil.toJson(entities);
        System.out.println(entities.size());
        System.out.println(json);
    }
}
