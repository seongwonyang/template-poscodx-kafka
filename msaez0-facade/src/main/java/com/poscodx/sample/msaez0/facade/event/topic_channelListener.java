forEach: Event
path: {{#outgoing "Policy" this}}{{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-facade/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/facade/event{{/outgoing}}
fileName: {{nameCamelCase}}Listener.java
except: {{^outgoing "Policy" this}}{{/outgoing}}
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.facade.event;

import java.util.function.Consumer;
import com.poscodx.reuse.common.util.kafka.annotation.PosEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


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


@Slf4j
@Component("{{nameCamelCase}}_channel")
public class {{nameCamelCase}}Listener
implements Consumer<Message<String>>
{
    
    @PosEventHandler
    @Override
    public void {{nameCamelCase}}(Message<String> message) {
        String payload = message.getPayload();
        // TODO
        // T obj = JsonUtil.fromJson(payload, T)
        // someFlow.someMethod(obj)
    }
}
