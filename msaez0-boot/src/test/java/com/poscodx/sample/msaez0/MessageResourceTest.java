forEach: BoundedContext
path: {{nameCamelCase}}/{{nameCamelCase}}-boot/src/test/java/com/poscodx/{{options.serviceId}}/{{nameCamelCase}}
fileName: MessageResourceTest.java
---
package com.poscodx.{{options.serviceId}}.{nameCamelCase};

import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;


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
@SpringBootTest
public class MessageResourceTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    public void test() {
        String code;
        String[] args = null;
        Locale locale = Locale.getDefault();
        Locale localeKorea = Locale.KOREA;
        Locale localeUS = Locale.US;
        //
        code = "MSG0001";
        System.out.println(code + "(default) -> " + messageSource.getMessage(code, args, locale));
        System.out.println(code + "(Korean ) -> " + messageSource.getMessage(code, args, localeKorea));
        System.out.println(code + "(English) -> " + messageSource.getMessage(code, args, localeUS));
        //
        code = "MSG0002";
        args = new String[]{"유진"};
        System.out.println(code + "(default) -> " + messageSource.getMessage(code, args, locale));
        System.out.println(code + "(Korean ) -> " + messageSource.getMessage(code, args, localeKorea));
        System.out.println(code + "(English) -> " + messageSource.getMessage(code, args, localeUS));
        //
        code = "MSG0003";
        args = new String[]{"유진", "3"};
        System.out.println(code + "(default) -> " + messageSource.getMessage(code, args, locale));
        System.out.println(code + "(Korean ) -> " + messageSource.getMessage(code, args, localeKorea));
        System.out.println(code + "(English) -> " + messageSource.getMessage(code, args, localeUS));
    }
}
