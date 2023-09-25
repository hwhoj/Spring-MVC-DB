package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.sax.SAXResult;

@Controller
public class HelloController {

    @GetMapping("hello") // web 어플리케이션에서 /hello라고 들어오면 이 메소드를 호출
    public String hello(Model model){
        //model이란 mvc 모델을 뜻함

        model.addAttribute("data", "Hello!!");
        return "hello";

        //hello.html에 있는 <p th:text="'안녕하세요. ' + ${data}">안녕하세요. 손님</p>
        //부분에서 ${data}가 Hello!!로 치환된다

        //기본적으로 resources > templates 하위의 폴더에서 리턴값과 같은 파일을 찾는다
    }

    // 정적 컨텐츠, mvc와 템플릿 엔진, API
    // 1. 정적 (static) 컨텐츠는 파일을 그대로 보여줌
    // 2. mvc와 템플릿 엔진 : 템플릿 엔진을 mvc 패턴으로 쪼개서 뷰를 템플릿 엔진으로 렌더링 된 html을 유져에게 전달
    // 3. api는 객체를 반환하는 개념


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        //http://localhost:8080/hello-mvc?name=spring!! name= 부분에 입력받은 파라미터대로 화면에 출력됨

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body부에 직접 입력하겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
